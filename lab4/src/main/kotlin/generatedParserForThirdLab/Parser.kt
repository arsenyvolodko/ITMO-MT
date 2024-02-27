package generatedParserForThirdLab


import java.math.BigInteger
import java.text.ParseException

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

    fun i(dict: HashMap<String, Int>): I {
        val res = I()
        when (token.typeToken) {
            TypeToken.N -> {
                if (token.typeToken !== TypeToken.N) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val N0 = token.text
                nextToken()
                res.value = Integer.parseInt("-" + N0)
            }

            TypeToken.OPEN -> {
                if (token.typeToken !== TypeToken.OPEN) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val OPEN0 = token.text
                nextToken()
                val expr1 = expr(dict)
                if (token.typeToken !== TypeToken.CLOSE) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val CLOSE2 = token.text
                nextToken()
                res.value = -(expr1.value)
            }

            TypeToken.VARIABLE -> {
                if (token.typeToken !== TypeToken.VARIABLE) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val VARIABLE0 = token.text
                nextToken()
                res.value = -dict[VARIABLE0]!!
            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun term(dict: HashMap<String, Int>): Term {
        val res = Term()
        when (token.typeToken) {
            TypeToken.VARIABLE, TypeToken.N, TypeToken.OPEN, TypeToken.MINUS -> {
                val factor0 = factor(dict)
                val termS1 = termS(dict, factor0.value)
                res.value = termS1.value
            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun initVariable(dict: HashMap<String, Int>): InitVariable {
        val res = InitVariable()
        when (token.typeToken) {
            TypeToken.VARIABLE -> {
                if (token.typeToken !== TypeToken.VARIABLE) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val VARIABLE0 = token.text
                nextToken()
                if (token.typeToken !== TypeToken.EQ) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val EQ1 = token.text
                nextToken()
                res.value.putAll(dict)
                val expr2 = expr(res.value)
                if (token.typeToken !== TypeToken.SEMICOLON) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val SEMICOLON3 = token.text
                nextToken()
                res.value.put(VARIABLE0, expr2.value)
                val initVariable4 = initVariable(res.value)
                res.value.putAll(initVariable4.value)
            }

            TypeToken.SEMICOLON -> {
                if (token.typeToken !== TypeToken.SEMICOLON) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val SEMICOLON0 = token.text
                nextToken()
            }

            TypeToken.END -> {

            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun termS(dict: HashMap<String, Int>, acc: Int): TermS {
        val res = TermS()
        when (token.typeToken) {
            TypeToken.MUL -> {
                if (token.typeToken !== TypeToken.MUL) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val MUL0 = token.text
                nextToken()
                val factor1 = factor(dict)
                res.value = acc * factor1.value
                val termS2 = termS(dict, res.value)
                res.value = termS2.value
            }

            TypeToken.DIV -> {
                if (token.typeToken !== TypeToken.DIV) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val DIV0 = token.text
                nextToken()
                val factor1 = factor(dict)
                res.value = acc / factor1.value
                val termS2 = termS(dict, res.value)
                res.value = termS2.value
            }

            TypeToken.SEMICOLON, TypeToken.GCD, TypeToken.CLOSE, TypeToken.PLUS, TypeToken.MINUS -> {
                res.value = acc
            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun expr(dict: HashMap<String, Int>): Expr {
        val res = Expr()
        when (token.typeToken) {
            TypeToken.VARIABLE, TypeToken.N, TypeToken.OPEN, TypeToken.MINUS -> {
                val term0 = term(dict)
                val exprS1 = exprS(dict, term0.value)
                res.value = exprS1.value
            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun parse(): Parse {
        val res = Parse()
        when (token.typeToken) {
            TypeToken.VARIABLE, TypeToken.SEMICOLON -> {
                val initVariable0 = initVariable(res.value)
                res.value.putAll(initVariable0.value)
            }

            TypeToken.END -> {

            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun factor(dict: HashMap<String, Int>): Factor {
        val res = Factor()
        when (token.typeToken) {
            TypeToken.N -> {
                if (token.typeToken !== TypeToken.N) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val N0 = token.text
                nextToken()
                res.value = Integer.parseInt(N0)
            }

            TypeToken.OPEN -> {
                if (token.typeToken !== TypeToken.OPEN) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val OPEN0 = token.text
                nextToken()
                val expr1 = expr(dict)
                if (token.typeToken !== TypeToken.CLOSE) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val CLOSE2 = token.text
                nextToken()
                res.value = expr1.value
            }

            TypeToken.MINUS -> {
                if (token.typeToken !== TypeToken.MINUS) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val MINUS0 = token.text
                nextToken()
                val i1 = i(dict)
                res.value = i1.value
            }

            TypeToken.VARIABLE -> {
                if (token.typeToken !== TypeToken.VARIABLE) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val VARIABLE0 = token.text
                nextToken()
                res.value = dict[VARIABLE0]!!
            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    fun exprS(dict: HashMap<String, Int>, acc: Int): ExprS {
        val res = ExprS()
        when (token.typeToken) {
            TypeToken.PLUS -> {
                if (token.typeToken !== TypeToken.PLUS) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val PLUS0 = token.text
                nextToken()
                val term1 = term(dict)
                res.value = acc + term1.value
                val exprS2 = exprS(dict, res.value)
                res.value = exprS2.value
            }

            TypeToken.MINUS -> {
                if (token.typeToken !== TypeToken.MINUS) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val MINUS0 = token.text
                nextToken()
                val term1 = term(dict)
                res.value = acc - term1.value
                val exprS2 = exprS(dict, res.value)
                res.value = exprS2.value
            }

            TypeToken.GCD -> {
                if (token.typeToken !== TypeToken.GCD) {
                    throw ParseException("No valid token, ${token.typeToken}", 0)
                }
                val GCD0 = token.text
                nextToken()
                val term1 = term(dict)
                res.value = BigInteger.valueOf(acc.toLong()).gcd(BigInteger.valueOf(term1.value.toLong())).toInt()
                val exprS2 = exprS(dict, res.value)
                res.value = exprS2.value
            }

            TypeToken.SEMICOLON, TypeToken.CLOSE -> {
                res.value = acc
            }

            else -> throw ParseException("No valid token, ${token.typeToken}", 0)
        }

        return res
    }


    class I {
        var value: Int = 0
    }

    class Term {
        var value: Int = 0
    }

    class InitVariable {
        var value: HashMap<String, Int> = HashMap()
    }

    class TermS {
        var value: Int = 0
    }

    class Expr {
        var value: Int = 0
    }

    class Parse {
        var value: HashMap<String, Int> = HashMap()
    }

    class Factor {
        var value: Int = 0
    }

    class ExprS {
        var value: Int = 0
    }
}
