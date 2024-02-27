package generatedParserForThirdLab;
               
import java.util.regex.Pattern;
                
enum class TypeToken(regexp: String) {
    END("\\$"),
	PLUS("\\+"),
	MINUS("-"),
	MUL("\\*"),
	DIV("/"),
	GCD("gcd"),
	N("(0|[1-9][0-9]*)"),
	OPEN("\\("),
	CLOSE("\\)"),
	EPS("ε"),
	EQ("="),
	SEMICOLON(";"),
	VARIABLE("[a-zA-Z][a-zA-Z0-9]*");
    private val pattern: Pattern
                
    init {
        pattern = Pattern.compile(regexp)
    }

    fun match(text: String): Boolean {
        return pattern.matcher(text).matches()
    }
}
