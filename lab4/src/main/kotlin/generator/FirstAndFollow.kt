package generator

import adapter.GrammarAdapter
import adapter.Rules

class FirstAndFollow(rules: GrammarAdapter) {
    private val rules: List<Rules>
    private val first: MutableMap<String, MutableSet<String>> = HashMap()
    private val follow: MutableMap<String, MutableSet<String>> = HashMap()

    init {
        this.rules = rules.getRules()
        if (this.rules.isNotEmpty()) {
            constructFirst()
            constructFollow()
        }
    }

    fun getFirst(): Map<String, MutableSet<String>> {
        return first
    }

    fun getFollow(): Map<String, MutableSet<String>> {
        return follow
    }

    fun getFirstString(products: MutableList<String?>?): MutableSet<String> {
        if (products!!.isEmpty()) {
            return HashSet(setOf("EPS"))
        }
        val res = HashSet<String>()
        for (c in products) {
            if (c!!.matches("[A-Z]+".toRegex())) {
                res.add(c)
            } else if (first.containsKey(c)) {
                res.addAll(first[c]!!)
                if (first[c]!!.contains("EPS")) {
                    continue
                }
            }
            break
        }
        return res
    }

    private fun constructFirst() {
        var changed = true
        while (changed) {
            changed = false
            for (rule in rules) {
                val title: String = rule.terminal.nameRule
                val szBfr = first.computeIfAbsent(
                    title
                ) { _: String? -> HashSet() }.size
                first[title]!!.addAll(getFirstString(rule.rule.eval))
                changed = changed or (first[title]!!.size > szBfr)
            }
        }
    }

    private fun constructFollow() {
        var change = true
        follow[rules[0].terminal.nameRule] = HashSet(setOf("END"))
        while (change) {
            change = false
            for (rule in rules) {
                val products: MutableList<String?> = rule.rule.eval
                val a: String = rule.terminal.nameRule
                for (i in products.indices) {
                    val b = products[i]
                    if (!b!!.matches("[A-Z]+".toRegex()) && b != "EPS") {
                        val curSize = follow.computeIfAbsent(b) { _: String? -> HashSet() }.size
                        val firstGamma = getFirstString(products.subList(i + 1, products.size))
                        if (firstGamma.contains("EPS")) {
                            follow[b]!!.addAll(follow.computeIfAbsent(a) { HashSet() })
                        }
                        firstGamma.remove("EPS")
                        follow[b]!!.addAll(firstGamma)
                        change = change or (curSize < follow[b]!!.size)
                    }
                }
            }
        }
    }
}
