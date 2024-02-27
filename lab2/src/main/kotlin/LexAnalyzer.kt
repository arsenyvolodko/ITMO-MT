class LexAnalyzer(private val source: String) {

    private var curPos = 0
    private val lexemes = ArrayList<Lexeme>()

    private fun eof() = curPos == source.length

    private fun isBlank(): Boolean {
        return Character.isWhitespace(source[curPos])
    }

    private fun isDigit(): Boolean {
        if (eof()) return false
        return Character.isDigit(source[curPos])
    }

    private fun isLetter(): Boolean {
        if (eof()) return false
        return Character.isLetter(source[curPos])
    }

    private fun isUnderscore(): Boolean {
        if (eof()) return false
        return source[curPos] == '_'
    }

    private fun take(): Char {
        return source[curPos++]
    }

    private fun take(c: Char): Boolean {

        if (c == source[curPos]) {
            take()
            return true
        }

        return false
    }

    private fun take(str: String): Boolean {
        val startPos = curPos
        var pos = 0
        while (!eof() && pos < str.length) {
            if (!take(str[pos])) {
                curPos = startPos
                return false
            }
            pos++
        }
        return true
    }

    private fun skipWhitespaces() {
        while (!eof() && isBlank()) take()
    }

    private fun getVar(c: Char): String {
        val variable = StringBuilder(c.toString())
        while (isLetter() || isUnderscore() || isDigit()) {
            variable.append(take())
        }
        val strVar = variable.toString()
        if (strVar.all { it == '_' }) {
            throw ParserException("Incorrect variable name: $strVar")
        }
        return strVar
    }

    private fun getNum(c: Char): Int {
        val num = StringBuilder(c.toString())
        while (isDigit()) {
            num.append(take())
        }
        try {
            return num.toString().toInt()
        } catch (e: NumberFormatException) {
            throw ParserException("Incorrect number: $num")
        }
    }

    fun analyze(): ArrayList<Lexeme> {
        while (!eof()) {
            when (val c = take()) {
                ':' -> lexemes.add(Lexeme(":", Token.COLON))
                ';' -> lexemes.add(Lexeme(";", Token.SEMICOLON))
                '=' -> lexemes.add(Lexeme("=", Token.EQUAL))
                '(' -> lexemes.add(Lexeme("(", Token.LEFT_BRACKET))
                ')' -> lexemes.add(Lexeme(")", Token.RIGHT_BRACKET))
                ',' -> lexemes.add(Lexeme(",", Token.COMMA))
                'I' -> {
                    if (take("nt "))
                        lexemes.add(Lexeme("Int", Token.TYPE_INT))
                    else if (take("nt;")) {
                        lexemes.add(Lexeme("Int", Token.TYPE_INT))
                        lexemes.add(Lexeme(";", Token.SEMICOLON))
                    } else {
                        val variable = getVar('I')
                        lexemes.add(Lexeme(variable, Token.VARIABLE))
                    }
                }

                'a' -> {
                    if (take("rrayOf")) {
                        lexemes.add(Lexeme("arrayOf", Token.ARRAY))
                    } else {
                        val variable = getVar('a')
                        lexemes.add(Lexeme(variable, Token.VARIABLE))
                    }
                }

                'A' -> {
                    if (take("rray<Int>"))
                        lexemes.add(Lexeme("Array<Int>", Token.TYPE_ARRAY))
                    else {
                        val variable = getVar('A')
                        lexemes.add(Lexeme(variable, Token.VARIABLE))
                    }
                }

                'v' -> {
                    if (take("ar "))
                        lexemes.add(Lexeme("var", Token.DECLARATION))
                    else if (take("al "))
                        lexemes.add(Lexeme("val", Token.DECLARATION))
                    else {
                        val variable = getVar('v')
                        if (variable == "var" || variable == "val") {
                            throw ParserException("Incorrect variable name: $variable")
                        }
                    }
                }

                else -> {
                    if (Character.isWhitespace(c)) {
                        skipWhitespaces()
                    } else if (Character.isLetter(c) || c == '_') {
                        val variable = getVar(c)
                        lexemes.add(Lexeme(variable, Token.VARIABLE))
                    } else if (Character.isDigit(c) || c == '-' || c == '+') {
                        val num = getNum(c)
                        lexemes.add(Lexeme(num.toString(), Token.NUM))
                    } else {
                        throw ParserException("error")
                    }
                }
            }
        }
        lexemes.add(Lexeme("", Token.EOF))
        return lexemes
    }
}