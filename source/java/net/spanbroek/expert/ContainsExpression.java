package net.spanbroek.expert;

import java.util.*;

/**
 * Represents a 'contains' expression. This expression will evaluate to
 * <code>true</code>, when the property referenced by this expression contains
 * the expected value. For instance, a <code>ContainsExpression</code> with an
 * expected value of <code>foo</code> will evaluate to <code>true</code> when
 * the referenced property is equal to <code>bar,foo</code>, but not when the
 * referenced property is equal to <code>food</code>.
 */
public class ContainsExpression implements Expression {

    /**
     * The property key.
     */
    private String key = null;

    /**
     * The value that a property should contain, for this expression to
     * evaluate to <code>true</code>.
     */
    private String value = null;

    /**
     * Evaluates this expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);    
        String property = context.getProperty(key);
        if (property != null) {
            String[] values = property.split(",");
            for (int i=0; i<values.length; i++) {
                if (values[i].trim().equals(value)) {
                    return true;
                }
            }
        }
        return false;
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
     * Returns the value that a property should contain, for this expression to
     * evaluate to <code>true</code>.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value that a property should contain, for this expression to
     * evaluate to <code>true</code>.
     */
    public void setValue(String value) {
        this.value = value;
    }

}
