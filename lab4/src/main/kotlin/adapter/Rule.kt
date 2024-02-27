package adapter


class Rule(var evals: List<Eval>) {

    val eval: MutableList<String?>
        get() {
            val result = mutableListOf<String?>()
            for (eval in evals) {
                for (useRule in eval.getRules()) {
                    result.add(useRule.rule)
                }
            }
            return result
        }
}