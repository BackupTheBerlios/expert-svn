package net.spanbroek.expert;

import java.util.*;

/**
 * Represents a logical 'or' expression. It is allowed to have more than two
 * arguments.
 */
public class OrExpression implements Expression {

    /**
     * The list of operands.
     */
    private LinkedList operands = new LinkedList();

    /**
     * Evaluates the expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        boolean result = false;
        for (Iterator i=operands.iterator(); !result && i.hasNext(); ) {
            result = ((Expression)i.next()).evaluate(context);
        }
        return result;
    }

    /**
     * Returns the list of operands.
     */
    public List getOperands() {
        return operands;
    }

    /**
     * Adds an operand.
     */
    public void addOperand(Expression operand) {
      operands.add(operand);
    }

}
