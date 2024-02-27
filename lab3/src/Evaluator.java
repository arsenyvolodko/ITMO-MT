import parser.*;

import java.util.HashMap;

public class Evaluator extends ArithmeticExpressionsBaseListener {
    private final HashMap<String, Integer> variables = new HashMap<>();

    public HashMap<String, Integer> getVariables() {
        return variables;
    }

    @Override
    public void exitEquation(ArithmeticExpressionsParser.EquationContext ctx) {
        String variableName = ctx.VARIABLE().getText();
        int value = getValue(ctx.expression());
        variables.put(variableName, value);
    }

    private int getValue(ArithmeticExpressionsParser.ExpressionContext ctx) {
        if (ctx.addSubOp() != null) {
            if (ctx.addSubOp().MINUS() != null) {
                return -(getValue(ctx.term()) - getValue(ctx.expression()));
            } else if (ctx.addSubOp().PLUS() != null) {
                return getValue(ctx.term()) + getValue(ctx.expression());
            }
        }

        return getValue(ctx.term());
    }

    private int getValue(ArithmeticExpressionsParser.TermContext ctx) {
        int u = 1;
        if (ctx.unaryMinus() != null) {
            u = -1;
        }
        if (ctx.mullDivOp() != null) {
            if (ctx.mullDivOp().TIMES() != null) {
                return getValue(ctx.factor()) * getValue(ctx.term()) * u;
            } else if (ctx.mullDivOp().DIV() != null) {
                int val1 = getValue(ctx.factor());
                int val2 = getValue(ctx.term());
                if (val1 == 0) {
                    throw new RuntimeException("Division by zero");
                }
                return val2 / val1 * u;
            }
        }

        return getValue(ctx.factor()) * u;
    }

    private int getValue(ArithmeticExpressionsParser.FactorContext ctx) {
        if (ctx.atom() == null) {
            return getValue(ctx.expression());
        } else if (ctx.atom().NUMBER() != null) {
            return Integer.parseInt(ctx.atom().NUMBER().getText());
        } else if (ctx.atom().VARIABLE() != null) {
            String variableName = ctx.atom().VARIABLE().getText();
            if (variables.containsKey(variableName)) {
                return variables.get(variableName);
            } else {
                throw new RuntimeException("Unknown variable: " + variableName);
            }
        } else if (ctx.expression() != null) {
            return getValue(ctx.expression());
        }
        return 0;
    }
}