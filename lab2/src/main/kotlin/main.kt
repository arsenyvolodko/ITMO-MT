fun main() {
    val expr = "var a: Int = 6; val c: Int; var d = -10;" +
            "val e: Array<Int>; val f: Array<Int> = arrayOf(1, 2, 3)"

    val tree = ExpressionParser(LexAnalyzer(expr).analyze()).parse()
    tree.plot()
}
