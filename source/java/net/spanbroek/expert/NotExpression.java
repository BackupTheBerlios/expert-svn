package net.spanbroek.expert;

import java.util.*;

/**
 * Represents a logical 'not' expression.
 */
public class NotExpression implements Expression {

    /**
     * The expression operand.
     */
    private Expression operand = null;

    /**
     * Evaluates the expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        return !operand.evaluate(context);
    }

    /**
     * Returns the expression operand.
     */
    public Expression getOperand() {
        return operand;
    }

    /**
     * Sets the expression operand.
     */
    public void setOperand(Expression operand) {
        this.operand = operand;
    }

}
