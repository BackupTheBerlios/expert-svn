package net.spanbroek.expert;

import java.util.*;

/**
 * Represents an 'append' statement. When applied, this statement appends a
 * value to a specified property. For instance, when a property has the value
 * <code>foo</code>, then after applying an 'append' statement with value
 * <code>bar</code>, the property will have value <code>foo,bar</code>. When a
 * property is empty, the 'append' statement has the same effect as an 'assign'
 * statement.
 */
public class AppendAssignment implements Assignment {

    /**
     * The property key.
     */
    private String key = null;

    /**
     * The value that will be appended.
     */
    private String value =  null;

    /**
     * Applies this 'append' statement to the specified context.
     */
    public void apply(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);    
        String property = context.getProperty(key);
        if (property == null || "".equals(property)) {
            context.put(key, value);
        }
        else {
            context.put(key, property + "," + value);
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
     * Returns the value that will be appended.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value that will be appended.
     */
    public void setValue(String value) {
        this.value = value;
    }

}
