package net.spanbroek.expert;

import java.util.*;

/**
 * Represents an 'assign' statement. When applied, this statement assigns a
 * specified value to a specified property. When the 'overwrite' attribute is
 * set to <code>false</code>, the assignment is only executed when the specified
 * property is not yet present.
 */
public class LiteralAssignment implements Assignment {

    /**
     * The property key.
     */
    private String key = null;

    /**
     * The value that will be assigned.
     */
    private String value =  null;

    /**
     * A boolean indicating whether or not to overwrite the property.
     */
    private boolean overwrite = true;

    /**
     * Applies the 'assign' statement.
     */
    public void apply(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);
        if (overwrite || !context.containsKey(key)) {
            context.put(key, value);
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
     * Returns the value that will be assigned.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value that will be assigned.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the boolean indicating whether or not to overwrite the property.
     */
    public boolean getOverwrite() {
        return overwrite;
    }

    /**
     * Sets the boolean indicating whether or not to overwrite the property.
     */
    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

}
