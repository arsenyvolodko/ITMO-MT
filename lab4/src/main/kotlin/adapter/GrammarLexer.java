// Generated from java-escape by ANTLR 4.11.1
package adapter;

import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, Var=6, Number=7, Whitespace=8, 
		NewLine=9, REGEXP=10, RETURNS=11, CODE=12, DEF_ATTR=13, IMPL_ATTR=14, 
		New_line=15, BlockComment=16, LineComment=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "Var", "Number", "Whitespace", 
			"NewLine", "REGEXP", "RETURNS", "CODE", "DEF_ATTR", "IMPL_ATTR", "New_line", 
			"BlockComment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "';'", "':'", "'|'", "'\\u03B5'", null, null, null, 
			null, null, "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "Var", "Number", "Whitespace", "NewLine", 
			"REGEXP", "RETURNS", "CODE", "DEF_ATTR", "IMPL_ATTR", "New_line", "BlockComment", 
			"LineComment"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\u0004\u0000\u0011\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u00056\b\u0005"+
		"\n\u0005\f\u00059\t\u0005\u0001\u0006\u0004\u0006<\b\u0006\u000b\u0006"+
		"\f\u0006=\u0001\u0006\u0004\u0006A\b\u0006\u000b\u0006\f\u0006B\u0001"+
		"\u0006\u0001\u0006\u0005\u0006G\b\u0006\n\u0006\f\u0006J\t\u0006\u0003"+
		"\u0006L\b\u0006\u0001\u0007\u0004\u0007O\b\u0007\u000b\u0007\f\u0007P"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0004\bV\b\b\u000b\b\f\bW\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0005\t^\b\t\n\t\f\ta\t\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000bj\b\u000b\n\u000b\f\u000b"+
		"m\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\fs\b\f\n\f\f\f"+
		"v\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r|\b\r\n\r\f\r\u007f\t\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0004\u000e\u0084\b\u000e\u000b\u000e\f\u000e\u0085"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u008e\b\u000f\n\u000f\f\u000f\u0091\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u009c\b\u0010\n\u0010\f\u0010\u009f\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0005_kt}\u008f\u0000\u0011\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001"+
		"\u000009\u0002\u0000\n\n  \u0002\u0000\n\n\r\r\u00af\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0001#\u0001\u0000\u0000\u0000\u0003+\u0001\u0000\u0000\u0000\u0005-"+
		"\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t1\u0001\u0000"+
		"\u0000\u0000\u000b3\u0001\u0000\u0000\u0000\rK\u0001\u0000\u0000\u0000"+
		"\u000fN\u0001\u0000\u0000\u0000\u0011U\u0001\u0000\u0000\u0000\u0013["+
		"\u0001\u0000\u0000\u0000\u0015d\u0001\u0000\u0000\u0000\u0017g\u0001\u0000"+
		"\u0000\u0000\u0019p\u0001\u0000\u0000\u0000\u001by\u0001\u0000\u0000\u0000"+
		"\u001d\u0083\u0001\u0000\u0000\u0000\u001f\u0089\u0001\u0000\u0000\u0000"+
		"!\u0097\u0001\u0000\u0000\u0000#$\u0005g\u0000\u0000$%\u0005r\u0000\u0000"+
		"%&\u0005a\u0000\u0000&\'\u0005m\u0000\u0000\'(\u0005m\u0000\u0000()\u0005"+
		"a\u0000\u0000)*\u0005r\u0000\u0000*\u0002\u0001\u0000\u0000\u0000+,\u0005"+
		";\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0005:\u0000\u0000.\u0006"+
		"\u0001\u0000\u0000\u0000/0\u0005|\u0000\u00000\b\u0001\u0000\u0000\u0000"+
		"12\u0005\u03b5\u0000\u00002\n\u0001\u0000\u0000\u000037\u0007\u0000\u0000"+
		"\u000046\u0007\u0001\u0000\u000054\u0001\u0000\u0000\u000069\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\f\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u0000:<\u0007\u0002\u0000\u0000"+
		";:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000=>\u0001\u0000\u0000\u0000>L\u0001\u0000\u0000\u0000?A\u0007\u0002"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"DH\u0005.\u0000\u0000EG\u0007\u0002\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000K;\u0001\u0000"+
		"\u0000\u0000K@\u0001\u0000\u0000\u0000L\u000e\u0001\u0000\u0000\u0000"+
		"MO\u0007\u0003\u0000\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RS\u0006\u0007\u0000\u0000S\u0010\u0001\u0000\u0000\u0000"+
		"TV\u0007\u0004\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000YZ\u0006\b\u0000\u0000Z\u0012\u0001\u0000\u0000\u0000[_\u0005"+
		"\"\u0000\u0000\\^\t\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\"\u0000\u0000"+
		"c\u0014\u0001\u0000\u0000\u0000de\u0005-\u0000\u0000ef\u0005>\u0000\u0000"+
		"f\u0016\u0001\u0000\u0000\u0000gk\u0005{\u0000\u0000hj\t\u0000\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000ln\u0001\u0000\u0000\u0000mk\u0001\u0000"+
		"\u0000\u0000no\u0005}\u0000\u0000o\u0018\u0001\u0000\u0000\u0000pt\u0005"+
		"[\u0000\u0000qs\t\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000sv\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0005]\u0000\u0000"+
		"x\u001a\u0001\u0000\u0000\u0000y}\u0005(\u0000\u0000z|\t\u0000\u0000\u0000"+
		"{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005)\u0000\u0000\u0081\u001c"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0007\u0004\u0000\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0006\u000e\u0000\u0000\u0088\u001e"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005/\u0000\u0000\u008a\u008b\u0005"+
		"*\u0000\u0000\u008b\u008f\u0001\u0000\u0000\u0000\u008c\u008e\t\u0000"+
		"\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005*\u0000\u0000\u0093\u0094\u0005/\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0006\u000f\u0000\u0000"+
		"\u0096 \u0001\u0000\u0000\u0000\u0097\u0098\u0005/\u0000\u0000\u0098\u0099"+
		"\u0005/\u0000\u0000\u0099\u009d\u0001\u0000\u0000\u0000\u009a\u009c\b"+
		"\u0004\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001"+
		"\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0006\u0010\u0000\u0000\u00a1\"\u0001\u0000"+
		"\u0000\u0000\u0010\u000057=BHKPW_kt}\u0085\u008f\u009d\u0001\u0006\u0000"+
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