package net.spanbroek.expert;

import java.util.Properties;

public class BitwiseAndExpression implements Expression {
    
    /**
     * The property key.
     */
    private String key = null;
    
    /**
     * The bitmask that a property should equal, for this expression to evaluate
     * to <code>true</code>.
     */
    private String value = null;
    
    /**
     * For a description of the radix value, see the java.lang.Long parseLong method.
     * The property and the value are required to have the same radix.
     * Radix is required to be fixed. Sorry no runtime evaluation here.
     */
    private String radix = null;

    /**
     * Evaluates this expression in the specified context.
     * If the either the radix, value or property cannot be read, it will return false.
     * It returns true if 1 or more bits are set.
     */
    public boolean evaluate (Properties context) {String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);
        String property = context.getProperty(key);
        
        try {
            int radix = Integer.parseInt(this.radix);
            long v = Long.parseLong(this.value, radix);            
            long p = Long.parseLong(property, radix);
            
            return (v & p) != 0;
        }
        catch(NumberFormatException exception) {
            return false;
        }
    }

    
    /**
     * @return Returns the key.
     */
    public String getKey () {
        return key;
    }
    /**
     * @param key The key to set.
     */
    public void setKey (String key) {
        this.key = key;
    }
    /**
     * @return Returns the radix.
     */
    public String getRadix () {
        return radix;
    }
    /**
     * @param radix The radix to set.
     */
    public void setRadix (String radix) {
        this.radix = radix;
    }
    /**
     * @return Returns the value.
     */
    public String getValue () {
        return value;
    }
    /**
     * @param value The value to set.
     */
    public void setValue (String value) {
        this.value = value;
    }
}
