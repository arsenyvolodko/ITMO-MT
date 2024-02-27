enum class Token {
    DECLARATION, COLON, EQUAL,
    SEMICOLON, NUM, TYPE_INT, TYPE_ARRAY, VARIABLE, EOF,
    ARRAY, RIGHT_BRACKET, LEFT_BRACKET,
    COMMA
}

enum class NonTerminal {
    S, E, NI, NA, T, NAE, D, V, DE, C, I, P, ROOT
}
