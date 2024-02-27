import org.junit.Test
import org.junit.Assert.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

class MyClassTest {

    private fun assertNotThrow(expressions: List<String>) {
        for (expr in expressions) {
            assertDoesNotThrow {
                ExpressionParser(LexAnalyzer(expr).analyze()).parse()
            }
        }
    }

    private fun assertThrow(expressions: List<String>) {
        for (expr in expressions) {
            assertThrows(ParserException::class.java) {
                ExpressionParser(LexAnalyzer(expr).analyze()).parse()
            }
        }
    }

    @Test
    fun oneVarIntBaseTest() {
        val cases = listOf(
            "val a: Int",
            "var b: Int;",
            "val c: Int = 0",
            "var d: Int = 5;",
            "val severalLetters: Int = 50;",
            "var negateNum: Int = -150;",
            "var positiveNum: Int = +150;"
        )
        assertNotThrow(cases)
    }

    @Test
    fun oneVarArrayBaseTest() {
        val cases = listOf(
            "val a: Array<Int>",
            "var b: Array<Int>;",
            "val c: Array<Int> = arrayOf(0)",
            "val c = arrayOf(0)",
            "var d: Array<Int> = arrayOf(1, 2);",
            "var d = arrayOf(1, 2);",
            "var sevLetters: Array<Int> = arrayOf(1, 2);",
            "var sevLetters = arrayOf(1, 2);",
            "var emptyArray: Array<Int> = arrayOf();"
        )
        assertNotThrow(cases)
    }

    @Test
    fun varHardNamedTest() {
        val cases = listOf(
            "val name: Int",
            "var name2: Array<Int> = arrayOf(0)",
            "val name_: Int",
            "val __name: Array<Int> = arrayOf(0)",
            "var Name: Int",
            "val NaMe: Array<Int> = arrayOf(0)",
            "var name_name: Int",
            "var name_name_2: Array<Int> = arrayOf(0)",
            "var n2k2: Int",
            "var A_2_tr_34uu____: Array<Int> = arrayOf(0)"
        )
        assertNotThrow(cases)
    }

    @Test
    fun incorrectNamesTest() {
        val cases = listOf(
            "val _: Int",
            "val __: Array<Int> = arrayOf(0)",
            "val 5: Int",
            "val 5_: Array<Int> = arrayOf(0)",
            "val val : Int",
            "val var: Array<Int> = arrayOf(0)"
        )
        assertThrow(cases)
    }

    @Test
    fun severalVarsIntTest() {
        val cases = listOf(
            "val a: Int; var b: Int",
            "var a: Int; val b: Int;",
            "val a: Int = 5; var b: Int = -1;",
            "val a: Int = 5; var b: Int = -1",
            "var a: Int = 4; var b: Int; val c: Int; var d: Int",
            "var a: Int; var b: Int = 6; val c: Int; var d = -10;"
        )
        assertNotThrow(cases)
    }

    @Test
    fun severalVarsArrayTest() {
        val cases = listOf(
            "   val a   : Array<Int>  ; var b: Array<Int>  ",
            "var a: Array<Int>  ;  val b: Array<Int> ;",
            "val a: Array<Int>  =  arrayOf(); var b : Array<Int> = arrayOf(1, -1)",
            "val a: Array<Int>; val a = arrayOf(1, 2)",
            "val a: Array<Int>; val b: Array<Int> = arrayOf(); val c = arrayOf(1, 2, 3)",
        )
        assertNotThrow(cases)
    }

    @Test
    fun severalIncorrectVarsTest() {
        val cases = listOf(
            "val a: Int var b: Int;",
            "val a: Int = 5 var b: Int;",
            "val a: Array<Int> = arrayOf(a)",
            "val a: Array<Int> = arrayOf(1) val a: Int = 5",
        )
        assertThrow(cases)
    }

    @Test
    fun registerIncorrectTests() {
        val cases = listOf(
            "Val a: Int",
            "vAl a: Int",
            "VAL a: int",
            "val a: INT",
            "val a: ARRAY<Int>",
            "val a: Array<INT>",
            "val a: Array<int> = ArrayOf(1, 2);",
        )
        assertThrow(cases)
    }

    @Test
    fun randomIncorrectIntTests() {
        val cases = listOf(
            "",
            "val a",
            "var a Int",
            "var b:: Int",
            "var : Int",
            "var a: String",
            "var a = lol",
            "var a = var",
            "var a: var = 5",
            "var a: var = ",
            "var a: var = ;",
            "va: var = 5;",
            "5: var = 5;",
            "var a: Int = -",
            "var a: Int = +;"
        )
        assertThrow(cases)
    }

    @Test
    fun randomIncorrectArrayTests() {
        val cases = listOf(
            "val a: Array<Int> = arrayOf(a)",
            "val a = arrayOf()",
            "val a = arrayOf(1, a)",
            "val a: Array<int> = arrayOf(1, 2)",
            "val a = arrayOf(1, 2",
            "val a = arrayOf 1, 2)",
        )
        assertThrow(cases)
    }
}
