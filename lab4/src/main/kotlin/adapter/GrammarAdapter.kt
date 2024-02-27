package adapter


class GrammarAdapter {
    var grammarName: String? = null
    private val tokens: MutableList<Terminals> = ArrayList()
    private val rules: MutableList<Rules> = ArrayList()

    fun getTokens(): List<Terminals> {
        return tokens
    }

    fun getRules(): List<Rules> {
        return rules
    }

    fun addToken(nameTerminal: String, token: String) {
        tokens.add(Terminals(nameTerminal, token))
    }

    fun addRules(terminal: RuleTransition, rule: Rule) {
        rules.add(Rules(terminal, rule))
    }
}
