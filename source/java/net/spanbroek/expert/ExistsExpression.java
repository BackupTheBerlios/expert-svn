package net.spanbroek.expert;

import java.util.*;

/**
 * Represents an 'exists' expression. This expression will evaluate to
 * <code>true</code>, when the property referenced by this expression is 
 * present.
 */
public class ExistsExpression implements Expression {

    /**
     * The property key.
     */
    private String key = null;
    
    /**
     * Evaluates this expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        return (context.getProperty(key) != null);
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

}
