//import generatedParserForthirdLab.LexicalAnalyzer
//import generatedParserForthirdLab.Parser
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.params.ParameterizedTest
//import org.junit.jupiter.params.provider.ValueSource
//
//class CaslculatorTest {
//    @ParameterizedTest(name = "Test")
//    @ValueSource(strings = [
//        "-(100) *( 123-120)",
//        "-33*(73-51)+34",
//        "-(-(-13))",
//        " 1",
//        "0",
//        "-12",
//        "-123 + -21312",
//        "123 / 123 / 123 + 123"])
//    fun testCorrectExpression1(expr: String) {
//        val k = Assertions.assertDoesNotThrow<Parser.Expr> {
//            Parser(
//                LexicalAnalyzer(expr)
//            ).par
//        }
//        println(k.value)
//    }
//}
