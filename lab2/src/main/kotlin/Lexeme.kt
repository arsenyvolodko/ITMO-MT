data class Lexeme(val value: String, val token: Token) {
    override fun toString(): String {
        return "($value $token)"
    }
}