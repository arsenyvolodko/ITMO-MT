package generator

import adapter.*
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.stream.Collectors

class ParserGen(grammarAdapter: GrammarAdapter, path: Path) {
    private val grammarAdapter: GrammarAdapter
    private val firstAndFollow: FirstAndFollow
    private val path: Path

    constructor(grammarAdapter: GrammarAdapter) : this(
        grammarAdapter,
        Path.of("src/main/kotlin/generatedParserFor" + grammarAdapter.grammarName)
    )

    init {
        this.grammarAdapter = grammarAdapter
        firstAndFollow = FirstAndFollow(grammarAdapter)
        this.path = path
    }

    fun generateParserFiles() {
        try {
            Files.createDirectories(path)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        generateParser()
    }

    private fun generateClassResourceCode(sourceCode: String, s: String) {
        try {
            Files.newBufferedWriter(Path.of("$path/$s")).use { bufferedWriter ->
                bufferedWriter.write(
                    java.lang.String.format(
                        """
                    package generatedParserFor%s



                    """.trimIndent(), grammarAdapter.grammarName
                    )
                )
                bufferedWriter.write(sourceCode)
            }
        } catch (e: IOException) {
            //
        }
    }

    private fun generateParser() {
        val map: Map<RuleTransition, List<Rule>> = grammarAdapter
            .getRules()
            .stream()
            .collect(
                Collectors.groupingBy(
                    Rules::terminal,
                    Collectors.mapping(
                        Rules::rule,
                        Collectors.toList()
                    )
                )
            )
        val sourceCode = sourceCode
        generateFun(map, sourceCode)
        generateClasses(map.keys, sourceCode)
        generateClassResourceCode(
            sourceCode.toString() + """
                }

                """.trimIndent(), "Parser.kt"
        )
    }

    private fun generateFun(map: Map<RuleTransition, List<Rule>>, sourceCode: StringBuilder) {
        for ((key, value) in map) {
            val nameToken: String = key.nameRule
            val nameClass = nameToken[0].toString().uppercase(Locale.getDefault()) + nameToken.substring(1)
            sourceCode.append(
                java.lang.String.format(
                    """
                            fun %s%s: %s {
                                val res = %s()
                                when (token.typeToken) {

                        """.trimIndent(),
                    nameToken,
                    convertAttr(key.implementation),
                    nameClass,
                    nameClass,
                    nameClass,
                    nameToken
                )
            )
            var isEps = false
            var codeForFollow = ""
            for (rule in value) {
                val production: List<Eval> = rule.evals
                val firsts = firstAndFollow.getFirstString(rule.eval)
                if (firsts.contains("EPS")) {
                    isEps = true
                    codeForFollow = rule.evals[0].code
                }
                firsts.remove("EPS")
                if (firsts.isEmpty()) {
                    continue
                }
                generateCases(sourceCode, firsts)
                var i = 0
                for (product in production) {
                    for (token in product.getRules()) {
                        if (token.rule!!.matches(Regex("[A-Z]+"))) {
                            sourceCode.append(
                                java.lang.String.format(
                                    """
                                                    if (token.typeToken !== TypeToken.%s) {
                                                        throw ParseException("No valid token, ${'$'}{token.typeToken}", 0)
                                                    }
                                                    val %s%d = token.text
                                                    nextToken()

                                    """.trimIndent(), token.rule, token.rule, i
                                )
                            )
                        } else {
                            val name: String = token.rule
                            sourceCode.append(
                                java.lang.String.format(
                                    """
                                val %s%d = %s%s

                                """.trimIndent(),
                                    name,
                                    i,
                                    token.rule,
                                    token.attributes,
//                                    token.rule,
//                                    i
                                ).replace("\\$".toRegex(), "res.")
                            )
                        }
                        i++
                    }
                    val code = getCode(product.code)
                    if (code.isNotEmpty()) sourceCode.append(
                        String.format(
                            """
                            %s

                            """.trimIndent(), code
                        ).replace("\\$".toRegex(), "res.")
                    )
                }
                sourceCode.append(
                    """
                                }

                    """.trimIndent()
                )
            }
            if (isEps) {
                generateCases(sourceCode, firstAndFollow.getFollow()[nameToken])

                sourceCode.append(
                    String.format(
                        """
                                %s
                            }

                    """.trimIndent(), getCode(codeForFollow)
                    ).replace("\\$".toRegex(), "res.")
                )
            }
            sourceCode.append(
                """
                            else -> throw ParseException("No valid token, ${'$'}{token.typeToken}", 0)
                        }

                        return res
                    }



                """.trimIndent()
            )
        }
    }

    private fun generateClasses(nonTerminals: Set<RuleTransition>, sourceCode: StringBuilder) {
        sourceCode.append("\n")
        for (nonTerm in nonTerminals) {
            val name: String = nonTerm.nameRule
            val nameClass = name.substring(0, 1).uppercase(Locale.getDefault()) + name.substring(1)
            sourceCode.append(
                String.format(
                    """
                    class %s {

                """.trimIndent(), nameClass
                )
            )
//            println("logging:")
//            println(nonTerm.attribute)
            sourceCode.append(
                Arrays
                    .stream(
                        getCode(nonTerm.attribute)
                            .split("value ,".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    )
                    .map { attr: String -> TAB + TAB + "var " + convertAttr(attr, true) + "\n}\n" }
                    .collect(Collectors.joining())
            )
        }
    }

    private fun getInitializer(type: String): String {
        return when {
            type.startsWith("Int") -> " = 0"
            type.startsWith("HashMap") -> " = HashMap()"
            else -> ""
        }

    }

    private fun convertAttr(attr: String, init: Boolean = false): String {
        if (attr.isEmpty() || attr == "()") return attr
        val flag = attr.startsWith('(')
        val attrs = attr.removePrefix("(").removeSuffix(")")
//        println("attrs: $attr")
        var refactoredAttrs = ""
        var collectionFlag = false
        for (i in attrs.indices) {
            if (attrs[i] == '<') {
                collectionFlag = true

            } else if (attrs[i] == ',') {
                refactoredAttrs = if (collectionFlag) {
                    refactoredAttrs.plus(",")
                } else {
                    refactoredAttrs.plus(";")
                }
                continue
            } else if (collectionFlag && attrs[i] == '>') {
                collectionFlag = false
            }
            refactoredAttrs = refactoredAttrs.plus(attrs[i])
        }
        val attrsList = refactoredAttrs.split("; ").toMutableList()
//        println("attrsList: $attrsList")
        for (i in attrsList.indices) {
            val curStrList = attrsList[i].split(" ").toMutableList().asReversed()
            curStrList[1] = curStrList[1][0].uppercase() + curStrList[1].substring(1, curStrList[1].length)
            val convertedType = curStrList[1]
            var resStr = curStrList.joinToString(": ")
            if (init) {
                resStr += this.getInitializer(convertedType)
            }
            attrsList[i] = resStr
        }
//        println("res: ${if (flag) "(" + attrsList.joinToString(", ") + ")" else attrsList.joinToString(", ")}")
        return if (flag) "(" + attrsList.joinToString(", ") + ")" else attrsList.joinToString(", ")
    }

    companion object {
        private const val TAB = "    "
        private val sourceCode: StringBuilder
            get() {
                val sourceCode = StringBuilder()
                val sourceCodeHeadParser = """
                import java.text.ParseException
                import java.math.BigInteger

                @Suppress("UNUSED_VARIABLE")
                class Parser(private val tokens: LexicalAnalyzer) {
                private lateinit var token: Token

                private fun nextToken() {
                    tokens.nextToken()
                    token = tokens.token
                }

                init {
                    nextToken()
                }
                
                """.trimIndent()
                sourceCode.append(sourceCodeHeadParser)
                return sourceCode
            }

        private fun getCode(code: String): String {
            return Optional.ofNullable(code).map { c: String ->
                c.substring(
                    1,
                    c.length - 1
                )
            }.orElse("")
        }

        private fun generateCases(sourceCode: StringBuilder, tokens: Set<String>?) {
            sourceCode.append("TypeToken.").append(java.lang.String.join(", TypeToken.", tokens)).append(" -> {\n")
        }
    }
}
