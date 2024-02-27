import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

public class Main {
    public static void main(String[] args) {
        String expr = "a = 1 - 2 - 3;";
        ArithmeticExpressionsLexer lexer = new ArithmeticExpressionsLexer(CharStreams.fromString(expr));
        TokenStream tokens = new CommonTokenStream(lexer);
        ArithmeticExpressionsParser parser = new ArithmeticExpressionsParser(tokens);
        ArithmeticExpressionsParser.SContext tree = parser.s();

        Evaluator evaluator = new Evaluator();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(evaluator, tree);
        evaluator.getVariables().forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
