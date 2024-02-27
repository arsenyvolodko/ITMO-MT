import org.junit.jupiter.api.Test;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.ArithmeticExpressionsLexer;
import parser.ArithmeticExpressionsParser;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void testEasy() {
        String expr = "a = 5 + 3;";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", 8);
        }});
    }

    @Test
    public void testTwoVars() {
        String expr = "a = 5 + 3; b = a - 10;";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", 8);
            put("b", -2);
        }});
    }

    @Test
    public void testNegativeNumbers() {
        String expr = "b = -8;";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("b", -8);
        }});
    }

    @Test
    public void manyMinuses() {
        String expr = "a = -5 - -(-4 - -2);";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", -7);
        }});
    }


    @Test
    public void testComplexExpression() {
        String expr = "a = 4; b = a - 5; c = a * (b + 2) - 7;";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", 4);
            put("b", -1);
            put("c", -3);
        }});
    }

    @Test
    public void testMultipleOperations() {
        String expr = "x = 10; y = 3 * x + 2 - x; z = y - 5;";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("x", 10);
            put("y", 22);
            put("z", 17);
        }});

    }

    @Test
    public void testDivision() {
        String expr1 = "a = 20; b = 2 + 3; c = a / b;";
        String expr2 = "a = 0; b = 20 / a;";
        HashMap<String, Integer> input = runTest(expr1);
        assertEqual(input, new HashMap<>() {{
            put("a", 20);
            put("b", 5);
            put("c", 4);
        }});
        assertThrows(RuntimeException.class, () -> runTest(expr2));
    }

    @Test
    public void testExpressionWithBrackets() {
        String expr = "a = 5; b = 3; c = 4; d = 1; result = (a + b) * (c - d);";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", 5);
            put("b", 3);
            put("c", 4);
            put("d", 1);
            put("result", 24);
        }});
    }

    @Test
    public void testNestedBrackets() {
        String expr = "a = 5; b = a - 8; c = -5; d = -1; result = (a + b) * ((c - d) + 1);";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", 5);
            put("b", -3);
            put("c", -5);
            put("d", -1);
            put("result", -6);
        }});
    }

    @Test
    public void testUnaryOperators() {
        String expr = "m = -10; n = 5;";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("m", -10);
            put("n", 5);
        }});
    }

    @Test
    public void justToBeSureItWorks() {
        String expr = "a = 10; b = -5; c = 2 * a + (b - 3) / 2; " +
                     "d = c * (a + b) - 7 / (c + 1); " +
                     "e = -(d + 2 * c) / (a - b); " +
                     "result = e + (a + b) * (c - d);";
        HashMap<String, Integer> input = runTest(expr);
        assertEqual(input, new HashMap<>() {{
            put("a", 10);
            put("b", -5);
            put("c", 16);
            put("d", 80);
            put("e", -7);
            put("result", -327);
        }});
    }




    private static HashMap<String, Integer> runTest(String expr) {
        System.out.println("Running test for expression: " + expr);
        ArithmeticExpressionsLexer lexer = new ArithmeticExpressionsLexer(CharStreams.fromString(expr));
        TokenStream tokens = new CommonTokenStream(lexer);
        ArithmeticExpressionsParser parser = new ArithmeticExpressionsParser(tokens);
        ArithmeticExpressionsParser.SContext tree = parser.s();

        Evaluator evaluator = new Evaluator();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(evaluator, tree);
        return evaluator.getVariables();
    }

    private static void assertEqual(HashMap<String, Integer> input, HashMap<String, Integer> expected) {
        assert input.size() == expected.size();
        for (String key : input.keySet()) {
            assert expected.containsKey(key);
            assert expected.get(key).equals(input.get(key));
        }
    }
}
