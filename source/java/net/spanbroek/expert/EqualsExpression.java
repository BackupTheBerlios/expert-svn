package net.spanbroek.expert;

import java.util.*;

/**
 * Represents an 'equals' expression.
 */
public class EqualsExpression implements Expression {

    /**
     * The property key.
     */
    private String key = null;

    /**
     * The value that a property should equal, for this expression to evaluate
     * to <code>true</code>.
     */
    private String value = null;

    /**
     * Evaluates this expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);    
        String property = context.getProperty(key);
        return property!=null && context.getProperty(key).equals(value);
    }

    /**
     * Returns the property key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the property key.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Returns the value that a property should equal, for this expression to
     * evaluate to <code>true</code>.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value that a property should equal, for this expression to
     * evaluate to <code>true</code>.
     */
    public void setValue(String value) {
        this.value = value;
    }

}
