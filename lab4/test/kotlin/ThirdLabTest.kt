import generatedParserForThirdLab.LexicalAnalyzer
import generatedParserForThirdLab.Parser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ThirdLabTest {
    companion object {
        @JvmStatic
        fun testData(): List<Array<Any>> {
            return listOf(
                arrayOf(
                    "  a = 1  ;",
                    hashMapOf("a" to 1)
                ),
                arrayOf(
                    "  b = - 2  ;",
                    hashMapOf("b" to -2)
                ),
                arrayOf(
                    "a = -10  ;" +
                            " b = 10 + 5 ; ",
                    hashMapOf("a" to -10, "b" to 15)
                ),
                arrayOf(
                    "a = 4 + 5 ;" +
                            " b = a - 10 * 2  ; ",
                    hashMapOf("a" to 9, "b" to -11)
                ),
                arrayOf(
                    "a = 4 ;" +
                            " b = a + 4;" +
                            " c = -a + ( b - 10 ) ;" +
                            " d = 2 * a - 5 + (  c + 2  )  ;",
                    hashMapOf("a" to 4, "b" to 8, "c" to -6, "d" to -1)
                ),
                arrayOf(
                    "a = 25 gcd 5 + 10;",
                    hashMapOf("a" to 15)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun testCorrectExpression(expr: String, expectedResult: HashMap<String, Int>) {
        val result = Assertions.assertDoesNotThrow<Parser.Parse> {
            Parser(LexicalAnalyzer(expr)).parse()
        }.value

        Assertions.assertTrue(expectedResult == result)
    }
}
