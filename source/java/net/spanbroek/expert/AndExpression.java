package net.spanbroek.expert;

import java.util.*;

/**
 * Represents a logical 'and' expression. It is allowed to have more than two
 * arguments.
 */
public class AndExpression implements Expression {

    /**
     * The operands.
     */
    private LinkedList operands = new LinkedList();

    /**
     * Evaluates the 'and' expression.
     */
    public boolean evaluate(Properties context) {
        boolean result = true;
        for (Iterator i=operands.iterator(); result && i.hasNext(); ) {
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
