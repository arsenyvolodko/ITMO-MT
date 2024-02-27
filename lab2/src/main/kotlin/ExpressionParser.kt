class ExpressionParser(lexemes: List<Lexeme>) {
    private val lexemes: ArrayList<Lexeme>
    private var curPos = 0
    private lateinit var tree: MyNode
    private lateinit var currentNode: MyNode

    init {
        this.lexemes = lexemes as ArrayList<Lexeme>
    }

    private fun take(token: Token, node: MyNode) {
        if (this.curToken() != token) {
            throw ParserException("Expected $token, found ${this.curValue()}")
        }
        node.addChild(MyNode(this.curValue()))
        this.curPos++
    }

    private fun takeEps(node: MyNode) {
        node.addChild(MyNode("EPS"))
    }

    private fun curToken(): Token {
        return lexemes[curPos].token
    }

    private fun curValue(): String {
        return lexemes[curPos].value
    }

    fun parse(): MyNode {
        val curNode = MyNode(NonTerminal.ROOT.name)
        tree = curNode
        this.currentNode = curNode
        this.parseS()

        when (curToken()) {
            Token.EOF -> {
                return this.tree
            }

            else -> {
                throw ParserException("Expected EOF, found ${this.curValue()}")
            }
        }
    }
    
    private fun updateCurNode(name: String): MyNode {
        val curNode = MyNode(name)
        this.currentNode.addChild(curNode)
        this.currentNode = curNode
        return curNode
    }
    
    private fun curNodeToParent(node: MyNode) {
        this.currentNode = node.parent!!
    }

    private fun parseS() {
        val curNode = updateCurNode(NonTerminal.S.name)

        when (curToken()) {
            Token.DECLARATION -> {
                take(Token.DECLARATION, curNode)
                take(Token.VARIABLE, curNode)
                this.parseI()
                this.parseE()
            }
            else -> throw ParserException("Expected 'val' or 'var', found ${this.curValue()}")
        }

        curNodeToParent(curNode)
    }

    private fun parseI() {
        val curNode = updateCurNode(NonTerminal.I.name)

        when (curToken()) {
            Token.EQUAL -> {
                take(Token.EQUAL, curNode)
                this.parseV()
            }

            Token.COLON -> {
                take(Token.COLON, curNode)
                this.parseT()
            }

            else -> {
                throw ParserException("Expected '=' or ':', found ${this.curValue()}")
            }
        }

        curNodeToParent(curNode)
    }

    private fun parseV() {
        val curNode = updateCurNode(NonTerminal.V.name)

        when (curToken()) {
            Token.NUM -> {
                take(Token.NUM, curNode)
            }

            else -> parseNA()
        }

        curNodeToParent(curNode)
    }

    private fun parseNA() {
        val curNode = updateCurNode(NonTerminal.NA.name)

        when (curToken()) {
            Token.ARRAY -> {
                take(Token.ARRAY, curNode)
                take(Token.LEFT_BRACKET, curNode)
                this.parseD()
                take(Token.RIGHT_BRACKET, curNode)
            }

            else -> {
                takeEps(curNode)
            }
        }

        curNodeToParent(curNode)
    }

    private fun parseT() {
        val curNode = updateCurNode(NonTerminal.T.name)

        when (curToken()) {

            Token.TYPE_INT -> {
                take(Token.TYPE_INT, curNode)
                this.parseNI()
            }

            Token.TYPE_ARRAY -> {
                take(Token.TYPE_ARRAY, curNode)
                this.parseNAE()
            }

            else -> throw ParserException("Expected 'Int' or 'Array<Int>', found ${this.curValue()}")
        }

        curNodeToParent(curNode)
    }

    private fun parseNI() {
        val curNode = updateCurNode(NonTerminal.NI.name)


        when (curToken()) {
            Token.EQUAL -> {
                take(Token.EQUAL, curNode)
                take(Token.NUM, curNode)
            }

            else -> takeEps(curNode)
        }

        curNodeToParent(curNode)
    }


    private fun parseNAE() {
        val curNode = updateCurNode(NonTerminal.NAE.name)

        when (curToken()) {
            Token.EQUAL -> {
                take(Token.EQUAL, curNode)
                take(Token.ARRAY, curNode)
                take(Token.LEFT_BRACKET, curNode)
                this.parseDE()
                take(Token.RIGHT_BRACKET, curNode)
            }

            else -> {
                takeEps(curNode)
            }
        }

        curNodeToParent(curNode)
    }

    private fun parseDE() {
        val curNode = updateCurNode(NonTerminal.DE.name)

        when (curToken()) {
            Token.NUM -> {
                take(Token.NUM, curNode)
                this.parseC()
            }

            else -> {
                takeEps(curNode)
            }
        }

        curNodeToParent(curNode)
    }

    private fun parseC() {
        val curNode = updateCurNode(NonTerminal.C.name)

        when (curToken()) {
            Token.COMMA -> {
                take(Token.COMMA, curNode)
                this.parseD()
            }

            else -> {
                takeEps(curNode)
            }
        }
        curNodeToParent(curNode)
    }

    private fun parseD() {
        val curNode = updateCurNode(NonTerminal.D.name)

        when (curToken()) {
            Token.NUM -> {
                take(Token.NUM, curNode)
                this.parseC()
            }

            else -> throw ParserException("Expected 'num', found ${this.curValue()}")
        }
        curNodeToParent(curNode)
    }

    private fun parseE() {
        val curNode = updateCurNode(NonTerminal.E.name)


        when (curToken()) {
            Token.SEMICOLON -> {
                take(Token.SEMICOLON, curNode)
                this.parseP()
            }

            else -> {
                takeEps(curNode)
            }
        }

        curNodeToParent(curNode)
    }

    private fun parseP() {
        val curNode = updateCurNode(NonTerminal.P.name)

        when (curToken()) {

            Token.DECLARATION -> {
                take(Token.DECLARATION, curNode)
                take(Token.VARIABLE, curNode)
                this.parseI()
                this.parseE()
            }

            else -> {
                takeEps(curNode)
            }
        }
        curNodeToParent(curNode)

    }
}