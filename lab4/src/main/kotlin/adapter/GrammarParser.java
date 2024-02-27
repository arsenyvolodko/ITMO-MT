// Generated from java-escape by ANTLR 4.11.1
package adapter;

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, Var=6, Number=7, Whitespace=8, 
		NewLine=9, REGEXP=10, RETURNS=11, CODE=12, DEF_ATTR=13, IMPL_ATTR=14, 
		New_line=15, BlockComment=16, LineComment=17;
	public static final int
		RULE_grName = 0, RULE_abstractGrammar = 1, RULE_rules = 2, RULE_terminalRule = 3, 
		RULE_nonTerminalRule = 4, RULE_rule = 5, RULE_eval = 6, RULE_attr = 7, 
		RULE_heritableAttr = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"grName", "abstractGrammar", "rules", "terminalRule", "nonTerminalRule", 
			"rule", "eval", "attr", "heritableAttr"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GrNameContext extends ParserRuleContext {
		public String grammarName;
		public Token Var;
		public TerminalNode Var() { return getToken(GrammarParser.Var, 0); }
		public GrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grName; }
	}

	public final GrNameContext grName() throws RecognitionException {
		GrNameContext _localctx = new GrNameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__0);
			setState(19);
			((GrNameContext)_localctx).Var = match(Var);
			setState(20);
			match(T__1);
			 ((GrNameContext)_localctx).grammarName =  (((GrNameContext)_localctx).Var!=null?((GrNameContext)_localctx).Var.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbstractGrammarContext extends ParserRuleContext {
		public GrammarAdapter grammar;
		public GrNameContext grName;
		public GrNameContext grName() {
			return getRuleContext(GrNameContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public AbstractGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractGrammar; }
	}

	public final AbstractGrammarContext abstractGrammar() throws RecognitionException {
		AbstractGrammarContext _localctx = new AbstractGrammarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_abstractGrammar);

		    GrammarAdapter grammar = new GrammarAdapter();
		    ((AbstractGrammarContext)_localctx).grammar =  grammar;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			((AbstractGrammarContext)_localctx).grName = grName();
			setState(24);
			rules(grammar);

			    _localctx.grammar.setGrammarName(((AbstractGrammarContext)_localctx).grName.grammarName);

			setState(26);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RulesContext extends ParserRuleContext {
		public GrammarAdapter grammar;
		public List<TerminalRuleContext> terminalRule() {
			return getRuleContexts(TerminalRuleContext.class);
		}
		public TerminalRuleContext terminalRule(int i) {
			return getRuleContext(TerminalRuleContext.class,i);
		}
		public List<NonTerminalRuleContext> nonTerminalRule() {
			return getRuleContexts(NonTerminalRuleContext.class);
		}
		public NonTerminalRuleContext nonTerminalRule(int i) {
			return getRuleContext(NonTerminalRuleContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RulesContext(ParserRuleContext parent, int invokingState, GrammarAdapter grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_rules; }
	}

	public final RulesContext rules(GrammarAdapter grammar) throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState(), grammar);
		enterRule(_localctx, 4, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Var) {
				{
				setState(30);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(28);
					terminalRule(grammar);
					}
					break;
				case 2:
					{
					setState(29);
					nonTerminalRule(grammar);
					}
					break;
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TerminalRuleContext extends ParserRuleContext {
		public GrammarAdapter grammar;
		public Token Var;
		public Token REGEXP;
		public TerminalNode Var() { return getToken(GrammarParser.Var, 0); }
		public TerminalNode REGEXP() { return getToken(GrammarParser.REGEXP, 0); }
		public TerminalRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TerminalRuleContext(ParserRuleContext parent, int invokingState, GrammarAdapter grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_terminalRule; }
	}

	public final TerminalRuleContext terminalRule(GrammarAdapter grammar) throws RecognitionException {
		TerminalRuleContext _localctx = new TerminalRuleContext(_ctx, getState(), grammar);
		enterRule(_localctx, 6, RULE_terminalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((TerminalRuleContext)_localctx).Var = match(Var);
			setState(36);
			match(T__2);
			setState(37);
			((TerminalRuleContext)_localctx).REGEXP = match(REGEXP);
			setState(38);
			match(T__1);
			 _localctx.grammar.addToken((((TerminalRuleContext)_localctx).Var!=null?((TerminalRuleContext)_localctx).Var.getText():null), (((TerminalRuleContext)_localctx).REGEXP!=null?((TerminalRuleContext)_localctx).REGEXP.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonTerminalRuleContext extends ParserRuleContext {
		public GrammarAdapter grammar;
		public Token Var;
		public HeritableAttrContext heritableAttr;
		public AttrContext attr;
		public TerminalNode Var() { return getToken(GrammarParser.Var, 0); }
		public HeritableAttrContext heritableAttr() {
			return getRuleContext(HeritableAttrContext.class,0);
		}
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState, GrammarAdapter grammar) {
			super(parent, invokingState);
			this.grammar = grammar;
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalRule; }
	}

	public final NonTerminalRuleContext nonTerminalRule(GrammarAdapter grammar) throws RecognitionException {
		NonTerminalRuleContext _localctx = new NonTerminalRuleContext(_ctx, getState(), grammar);
		enterRule(_localctx, 8, RULE_nonTerminalRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((NonTerminalRuleContext)_localctx).Var = match(Var);
			setState(42);
			((NonTerminalRuleContext)_localctx).heritableAttr = heritableAttr();
			setState(43);
			((NonTerminalRuleContext)_localctx).attr = attr();
			 RuleTransition ruleTransition = new RuleTransition((((NonTerminalRuleContext)_localctx).Var!=null?((NonTerminalRuleContext)_localctx).Var.getText():null), (((NonTerminalRuleContext)_localctx).attr!=null?_input.getText(((NonTerminalRuleContext)_localctx).attr.start,((NonTerminalRuleContext)_localctx).attr.stop):null), (((NonTerminalRuleContext)_localctx).heritableAttr!=null?_input.getText(((NonTerminalRuleContext)_localctx).heritableAttr.start,((NonTerminalRuleContext)_localctx).heritableAttr.stop):null));
			setState(45);
			match(T__2);
			setState(46);
			rule_(grammar, ruleTransition);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(47);
				match(T__3);
				setState(48);
				rule_(grammar, ruleTransition);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public GrammarAdapter grammar;
		public RuleTransition name;
		public EvalContext eval;
		public Token CODE;
		public List<EvalContext> eval() {
			return getRuleContexts(EvalContext.class);
		}
		public EvalContext eval(int i) {
			return getRuleContext(EvalContext.class,i);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public RuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RuleContext(ParserRuleContext parent, int invokingState, GrammarAdapter grammar, RuleTransition name) {
			super(parent, invokingState);
			this.grammar = grammar;
			this.name = name;
		}
		@Override public int getRuleIndex() { return RULE_rule; }
	}

	public final RuleContext rule_(GrammarAdapter grammar,RuleTransition name) throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState(), grammar, name);
		enterRule(_localctx, 10, RULE_rule);

		    List<Eval> evals = new ArrayList<>();

		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(56);
					((RuleContext)_localctx).eval = eval();
					 evals.add(((RuleContext)_localctx).eval.evl); 
					}
					}
					setState(61); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Var );
				 _localctx.grammar.addRules(_localctx.name, new Rule(evals)); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(T__4);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(66);
					((RuleContext)_localctx).CODE = match(CODE);
					}
				}

				 _localctx.grammar.addRules(_localctx.name, new Rule(List.of(new Eval(List.of(), (((RuleContext)_localctx).CODE!=null?((RuleContext)_localctx).CODE.getText():null))))); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EvalContext extends ParserRuleContext {
		public Eval evl;
		public Token Var;
		public Token IMPL_ATTR;
		public Token CODE;
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public List<TerminalNode> Var() { return getTokens(GrammarParser.Var); }
		public TerminalNode Var(int i) {
			return getToken(GrammarParser.Var, i);
		}
		public List<TerminalNode> IMPL_ATTR() { return getTokens(GrammarParser.IMPL_ATTR); }
		public TerminalNode IMPL_ATTR(int i) {
			return getToken(GrammarParser.IMPL_ATTR, i);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eval);

		   List<UseRule> useRules = new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				((EvalContext)_localctx).Var = match(Var);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IMPL_ATTR) {
					{
					setState(73);
					((EvalContext)_localctx).IMPL_ATTR = match(IMPL_ATTR);
					}
				}

				 useRules.add(new UseRule((((EvalContext)_localctx).Var!=null?((EvalContext)_localctx).Var.getText():null), (((EvalContext)_localctx).IMPL_ATTR!=null?((EvalContext)_localctx).IMPL_ATTR.getText():null))); 
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Var );
			setState(81);
			((EvalContext)_localctx).CODE = match(CODE);
			 ((EvalContext)_localctx).evl =  new Eval(useRules, (((EvalContext)_localctx).CODE!=null?((EvalContext)_localctx).CODE.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrContext extends ParserRuleContext {
		public TerminalNode DEF_ATTR() { return getToken(GrammarParser.DEF_ATTR, 0); }
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(DEF_ATTR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeritableAttrContext extends ParserRuleContext {
		public TerminalNode IMPL_ATTR() { return getToken(GrammarParser.IMPL_ATTR, 0); }
		public HeritableAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heritableAttr; }
	}

	public final HeritableAttrContext heritableAttr() throws RecognitionException {
		HeritableAttrContext _localctx = new HeritableAttrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_heritableAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(IMPL_ATTR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0011Y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u001f\b\u0002\n\u0002\f\u0002\"\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u00042\b\u0004\n\u0004\f\u00045\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005<\b"+
		"\u0005\u000b\u0005\f\u0005=\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005D\b\u0005\u0001\u0005\u0003\u0005G\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0003\u0006K\b\u0006\u0001\u0006\u0004\u0006N\b\u0006\u000b"+
		"\u0006\f\u0006O\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0000\u0000W\u0000\u0012\u0001\u0000\u0000\u0000\u0002"+
		"\u0017\u0001\u0000\u0000\u0000\u0004 \u0001\u0000\u0000\u0000\u0006#\u0001"+
		"\u0000\u0000\u0000\b)\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000\u0000"+
		"\fM\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000\u0010V\u0001"+
		"\u0000\u0000\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u0014\u0005"+
		"\u0006\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0016\u0006"+
		"\u0000\uffff\uffff\u0000\u0016\u0001\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0003\u0000\u0000\u0000\u0018\u0019\u0003\u0004\u0002\u0000\u0019\u001a"+
		"\u0006\u0001\uffff\uffff\u0000\u001a\u001b\u0005\u0000\u0000\u0001\u001b"+
		"\u0003\u0001\u0000\u0000\u0000\u001c\u001f\u0003\u0006\u0003\u0000\u001d"+
		"\u001f\u0003\b\u0004\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001d"+
		"\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0005\u0001\u0000\u0000"+
		"\u0000\" \u0001\u0000\u0000\u0000#$\u0005\u0006\u0000\u0000$%\u0005\u0003"+
		"\u0000\u0000%&\u0005\n\u0000\u0000&\'\u0005\u0002\u0000\u0000\'(\u0006"+
		"\u0003\uffff\uffff\u0000(\u0007\u0001\u0000\u0000\u0000)*\u0005\u0006"+
		"\u0000\u0000*+\u0003\u0010\b\u0000+,\u0003\u000e\u0007\u0000,-\u0006\u0004"+
		"\uffff\uffff\u0000-.\u0005\u0003\u0000\u0000.3\u0003\n\u0005\u0000/0\u0005"+
		"\u0004\u0000\u000002\u0003\n\u0005\u00001/\u0001\u0000\u0000\u000025\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u0000"+
		"46\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0005\u0002\u0000"+
		"\u00007\t\u0001\u0000\u0000\u000089\u0003\f\u0006\u00009:\u0006\u0005"+
		"\uffff\uffff\u0000:<\u0001\u0000\u0000\u0000;8\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?@\u0006\u0005\uffff\uffff\u0000@G\u0001"+
		"\u0000\u0000\u0000AC\u0005\u0005\u0000\u0000BD\u0005\f\u0000\u0000CB\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EG\u0006\u0005\uffff\uffff\u0000F;\u0001\u0000\u0000\u0000FA\u0001\u0000"+
		"\u0000\u0000G\u000b\u0001\u0000\u0000\u0000HJ\u0005\u0006\u0000\u0000"+
		"IK\u0005\u000e\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LN\u0006\u0006\uffff\uffff\u0000MH\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0005\f\u0000\u0000"+
		"RS\u0006\u0006\uffff\uffff\u0000S\r\u0001\u0000\u0000\u0000TU\u0005\r"+
		"\u0000\u0000U\u000f\u0001\u0000\u0000\u0000VW\u0005\u000e\u0000\u0000"+
		"W\u0011\u0001\u0000\u0000\u0000\b\u001e 3=CFJO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}