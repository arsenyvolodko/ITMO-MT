package adapter

class Rules(name: RuleTransition, rule: Rule) {
    private var name: RuleTransition
    var rule: Rule

    init {
        this.name = name
        this.rule = rule
    }

    var terminal: RuleTransition
        get() = name
        set(name) {
            this.name = name
        }
}
