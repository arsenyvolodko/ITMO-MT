// Generated from ArithmeticExpressions.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ArithmeticExpressionsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VARIABLE=1, SEMICOLON=2, NUMBER=3, LPAREN=4, RPAREN=5, PLUS=6, MINUS=7, 
		TIMES=8, DIV=9, EQ=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VARIABLE", "SEMICOLON", "VALID_ID_START", "VALID_ID_CHAR", "NUMBER", 
			"UNSIGNED_INTEGER", "LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "DIV", 
			"EQ", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "';'", null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VARIABLE", "SEMICOLON", "NUMBER", "LPAREN", "RPAREN", "PLUS", 
			"MINUS", "TIMES", "DIV", "EQ", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ArithmeticExpressionsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ArithmeticExpressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000bH\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0005"+
		"\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003+\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0004\u00050\b\u0005\u000b\u0005\f\u0005"+
		"1\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0004\rC\b\r\u000b\r\f\rD\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001"+
		"\u0003\u0002\u0005\u0000\u0007\u0000\t\u0003\u000b\u0000\r\u0004\u000f"+
		"\u0005\u0011\u0006\u0013\u0007\u0015\b\u0017\t\u0019\n\u001b\u000b\u0001"+
		"\u0000\u0002\u0003\u0000AZ__az\u0003\u0000\t\n\r\r  H\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003$\u0001\u0000\u0000\u0000"+
		"\u0005&\u0001\u0000\u0000\u0000\u0007*\u0001\u0000\u0000\u0000\t,\u0001"+
		"\u0000\u0000\u0000\u000b/\u0001\u0000\u0000\u0000\r3\u0001\u0000\u0000"+
		"\u0000\u000f5\u0001\u0000\u0000\u0000\u00117\u0001\u0000\u0000\u0000\u0013"+
		"9\u0001\u0000\u0000\u0000\u0015;\u0001\u0000\u0000\u0000\u0017=\u0001"+
		"\u0000\u0000\u0000\u0019?\u0001\u0000\u0000\u0000\u001bB\u0001\u0000\u0000"+
		"\u0000\u001d!\u0003\u0005\u0002\u0000\u001e \u0003\u0007\u0003\u0000\u001f"+
		"\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0002\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000$%\u0005;\u0000\u0000%\u0004\u0001\u0000"+
		"\u0000\u0000&\'\u0007\u0000\u0000\u0000\'\u0006\u0001\u0000\u0000\u0000"+
		"(+\u0003\u0005\u0002\u0000)+\u000209\u0000*(\u0001\u0000\u0000\u0000*"+
		")\u0001\u0000\u0000\u0000+\b\u0001\u0000\u0000\u0000,-\u0003\u000b\u0005"+
		"\u0000-\n\u0001\u0000\u0000\u0000.0\u000209\u0000/.\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u00002\f\u0001\u0000\u0000\u000034\u0005(\u0000\u00004\u000e\u0001"+
		"\u0000\u0000\u000056\u0005)\u0000\u00006\u0010\u0001\u0000\u0000\u0000"+
		"78\u0005+\u0000\u00008\u0012\u0001\u0000\u0000\u00009:\u0005-\u0000\u0000"+
		":\u0014\u0001\u0000\u0000\u0000;<\u0005*\u0000\u0000<\u0016\u0001\u0000"+
		"\u0000\u0000=>\u0005/\u0000\u0000>\u0018\u0001\u0000\u0000\u0000?@\u0005"+
		"=\u0000\u0000@\u001a\u0001\u0000\u0000\u0000AC\u0007\u0001\u0000\u0000"+
		"BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0006\r\u0000"+
		"\u0000G\u001c\u0001\u0000\u0000\u0000\u0005\u0000!*1D\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}