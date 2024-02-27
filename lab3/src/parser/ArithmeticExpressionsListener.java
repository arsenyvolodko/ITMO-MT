// Generated from ArithmeticExpressions.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticExpressionsParser}.
 */
public interface ArithmeticExpressionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(ArithmeticExpressionsParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(ArithmeticExpressionsParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(ArithmeticExpressionsParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(ArithmeticExpressionsParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ArithmeticExpressionsParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ArithmeticExpressionsParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ArithmeticExpressionsParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ArithmeticExpressionsParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ArithmeticExpressionsParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ArithmeticExpressionsParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(ArithmeticExpressionsParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(ArithmeticExpressionsParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(ArithmeticExpressionsParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(ArithmeticExpressionsParser.AddSubOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#mullDivOp}.
	 * @param ctx the parse tree
	 */
	void enterMullDivOp(ArithmeticExpressionsParser.MullDivOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#mullDivOp}.
	 * @param ctx the parse tree
	 */
	void exitMullDivOp(ArithmeticExpressionsParser.MullDivOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ArithmeticExpressionsParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ArithmeticExpressionsParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticExpressionsParser#equls}.
	 * @param ctx the parse tree
	 */
	void enterEquls(ArithmeticExpressionsParser.EqulsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticExpressionsParser#equls}.
	 * @param ctx the parse tree
	 */
	void exitEquls(ArithmeticExpressionsParser.EqulsContext ctx);
}