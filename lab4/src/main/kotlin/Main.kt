import adapter.GrammarAdapter
import adapter.GrammarLexer
import adapter.GrammarParser
import generator.FirstAndFollow
import generator.LexerGen
import generator.ParserGen
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.*


fun main() {
    val expressions = Files.readString(Path.of("src/main/antlr/3rdLab.grammar"))
    val charStream: CharStream = CharStreams.fromString(expressions)
    val grammarLexer = GrammarLexer(charStream)
    val grammarParser = GrammarParser(CommonTokenStream(grammarLexer))
    val grammarAdapter: GrammarAdapter = grammarParser.abstractGrammar()!!.grammar

    val firstAndFollow = FirstAndFollow(grammarAdapter)
    println(isLL1(firstAndFollow, grammarAdapter))
    val generatorParser = ParserGen(grammarAdapter)
    val generatorLexer = LexerGen(grammarAdapter)
    generatorParser.generateParserFiles()
    generatorLexer.generateLexerFiles()
}


fun isLL1(ff: FirstAndFollow, grammarAdapter: GrammarAdapter): Boolean {
    val first: Map<String, MutableSet<String>> = ff.getFirst()
    val follow: Map<String, MutableSet<String>> = ff.getFollow()
    for (rule in grammarAdapter.getRules()) {
        val nonTerminal: String = rule.terminal.nameRule
        val firstOfNonTerminal = first[nonTerminal]!!
        for (terminal in firstOfNonTerminal) {
            if (first.containsKey(terminal) && !first[terminal]?.let
                { Collections.disjoint(it, firstOfNonTerminal) }!!
            ) {
                return false
            }
            if (firstOfNonTerminal.contains("EPS") && follow.containsKey(terminal) &&
                !first[terminal]?.let { follow[nonTerminal]?.let { it1 -> Collections.disjoint(it, it1) } }!!
            ) {
                return false
            }
        }
    }
    return true
}