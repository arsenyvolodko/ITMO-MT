package generatedParserForThirdLab
               
import java.text.ParseException
import java.util.regex.Matcher
import java.util.regex.Pattern
                
class LexicalAnalyzer(expression: String) {
    private val tokenMatcher: Matcher
    lateinit var token: Token
                
    init {
        tokenMatcher = PATTERN_EXPRESSION.matcher(expression)
    }
                
    fun nextToken() {
        while (tokenMatcher.find()) {
            if (Character.isWhitespace(tokenMatcher.group()[0])) continue
            for (typeToken in TypeToken.entries) {
                val tokenStr = tokenMatcher.group()
                if (typeToken.match(tokenStr)) {
                    token = Token(typeToken, tokenStr)
                    return
                }
            }
            throw ParseException("No valid token", 0)
        }
        token = Token(TypeToken.END, "$")
    }
                
    companion object {
        private val PATTERN_EXPRESSION = Pattern.compile("\\+|-|\\*|/|gcd|(0|[1-9][0-9]*)|\\(|\\)|ε|=|;|[a-zA-Z][a-zA-Z0-9]*|.")
    }
}