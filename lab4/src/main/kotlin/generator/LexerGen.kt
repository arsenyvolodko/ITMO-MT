package generator

import adapter.GrammarAdapter
import adapter.Terminals
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

class LexerGen(grammarAdapter: GrammarAdapter, path: Path) {
    private val grammarAdapter: GrammarAdapter
    private val path: Path

    constructor(grammarAdapter: GrammarAdapter) : this(
        grammarAdapter,
        Path.of("src/main/kotlin/generatedParserFor" + grammarAdapter.grammarName)
    )

    init {
        this.grammarAdapter = grammarAdapter
        this.path = path
    }

    fun generateLexerFiles() {
        try {
            Files.createDirectories(path)
        } catch (ignored: IOException) {
        }
        generateTokenClass()
        generateTypeToken()
        generateLexicalAnalyzer()
    }

    private fun generateTokenClass() {
        val sourceCodeToken = String.format(
            """
                package generatedParserFor%s;

                data class Token(val typeToken: TypeToken, val text: String)
                """.trimIndent(), grammarAdapter.grammarName
        )
        try {
            Files.newBufferedWriter(Path.of("$path/Token.kt")).use { bufferedWriter ->
                bufferedWriter.write(
                    sourceCodeToken
                )
            }
        } catch (e: IOException) {
            //
        }
    }

    private fun generateTypeToken() {
        val startClass = String.format(
            """
                package generatedParserFor%s;
                               
                import java.util.regex.Pattern;
                                
                enum class TypeToken(regexp: String) {
                    END("\\${'$'}"),
                    """.trimIndent(), grammarAdapter.grammarName
        )
        val endClass = """
                    private val pattern: Pattern
                                
                    init {
                        pattern = Pattern.compile(regexp)
                    }
                
                    fun match(text: String): Boolean {
                        return pattern.matcher(text).matches()
                    }
                }
                
                """.trimIndent()
        try {
            Files.newBufferedWriter(Path.of("$path/TypeToken.kt")).use { bufferedWriter ->
                bufferedWriter.write((startClass
                        + grammarAdapter
                    .getTokens()
                    .stream()
                    .map { entry -> ((TAB + entry.nameTerminal) + "(" + entry.token) + ")" }
                    .collect(Collectors.joining(",\n", "\n", ";\n"))
                        ) + endClass)
            }
        } catch (e: IOException) {
            //
        }
    }

    private fun generateLexicalAnalyzer() {

        val reg = grammarAdapter.getTokens()
            .stream()
            .map(Terminals::token)
            .map { s -> s.substring(1, s.length - 1) }
            .collect(Collectors.joining("|", "\"", "|.\""))


        val lexicalAnalyzerText = String.format(
            """
                package generatedParserFor%s
                               
                import java.text.ParseException
                import java.util.regex.Matcher
                import java.util.regex.Pattern
                                
                class LexicalAnalyzer(expression: String) {
                    private val tokenMatcher: Matcher
                    lateinit var token: Token
                                
                    init {
                        tokenMatcher = PATTERN_EXPRESSION.matcher(expression)
                    }
                                
                    fun nextToken() {
                        while (tokenMatcher.find()) {
                            if (Character.isWhitespace(tokenMatcher.group()[0])) continue
                            for (typeToken in TypeToken.entries) {
                                val tokenStr = tokenMatcher.group()
                                if (typeToken.match(tokenStr)) {
                                    token = Token(typeToken, tokenStr)
                                    return
                                }
                            }
                            throw ParseException("No valid token", 0)
                        }
                        token = Token(TypeToken.END, "$")
                    }
                                
                    companion object {
                        private val PATTERN_EXPRESSION = Pattern.compile(%s)
                    }
                }""".trimIndent(),
            grammarAdapter.grammarName, reg
        )

        try {
            Files.newBufferedWriter(Path.of("$path/LexicalAnalyzer.kt")).use { bufferedWriter ->
                bufferedWriter.write(lexicalAnalyzerText)
            }
        } catch (e: IOException) {
            //
        }

    }

    companion object {
        private const val TAB = "\t"
    }
}
