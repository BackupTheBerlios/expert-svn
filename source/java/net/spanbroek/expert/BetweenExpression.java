package net.spanbroek.expert;

import java.util.*;

/**
 * Represents a 'between' expression. This expression will evaluate to
 * <code>true</code>, when the property referenced by this expression contains
 * a value between (inclusive) the high and low values. If high, low and the 
 * property contain a number, they are compared numerically. If one of the 
 * values is not a number, they are compared lexicographically. For instance, a 
 * <code>BetweenExpression</code> with a low of <code>0</code> and a high of 
 * <code>8</code> will evaluate to <code>true</code> when the referenced
 * property is equal to <code>4</code>, but not when the referenced property is
 * equal to <code>four</code>.
 */
public class BetweenExpression implements Expression {

    /**
     * The property key.
     */
    private String key = null;
    
    /**
     * The lower bound of the interval that the value should be contained in, 
     * for this expression to evaluate to <code>true</code>.
     */
    private String low = null;
    
    /**
     * The upper bound of the interval that the value should be contained in, 
     * for this expression to evaluate to <code>true</code>.
     */
    private String high = null;

    /**
     * Evaluates this expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String low = InferenceEngine.evaluate(this.low, context);
        String high = InferenceEngine.evaluate(this.high, context);
        String property = context.getProperty(key);
        try {
            long l = Long.parseLong(low);
            long h = Long.parseLong(high);
            long p = Long.parseLong(property);
            return l <= p && p <= h;
        }
        catch(NumberFormatException exception) {
            return (low.compareTo(property) <= 0)
               && (property.compareTo(high) <= 0);
        }
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
     * Returns the lower bound of the interval that the value should be 
     * contained in, for this expression to evaluate to <code>true</code>.
     */
    public String getLow() {
        return low;
    }
    
    /**
     * Sets the lower bound of the interval that the value should be contained 
     * in, for this expression to evaluate to <code>true</code>.
     */
    public void setLow(String low) {
        this.low = low;
    }
    
    /**
     * Returns the upper bound of the interval that the value should be 
     * contained in, for this expression to evaluate to <code>true</code>.
     */
    public String getHigh() { // yeah man!
        return high;
    }
    
    /**
     * Sets the upper bound of the interval that the value should be 
     * contained in, for this expression to evaluate to <code>true</code>.
     */
    public void setHigh(String high) {
        this.high = high;
    }
    
}