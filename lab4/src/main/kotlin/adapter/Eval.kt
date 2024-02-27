package adapter

class Eval(rules: List<UseRule>, code: String) {
    private var rules: List<UseRule>
    var code: String

    init {
        this.rules = rules
        this.code = code
    }

    fun getRules(): List<UseRule> {
        return rules
    }

    fun setRules(rules: List<UseRule>) {
        this.rules = rules
    }
}
