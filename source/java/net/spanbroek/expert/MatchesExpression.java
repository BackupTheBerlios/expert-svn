package net.spanbroek.expert;

import java.util.regex.*;
import java.util.*;

/**
 * Represents a 'matches' expression. This expression will evaluate to
 * <code>true</code> when the specified property matches the specified regular
 * expression.
 */
public class MatchesExpression implements Expression {

    /**
     * The property key.
     */
    private String key = null;

    /**
     * The regular expression.
     */
    private String value = null;
    
    /**
     * Indicates whether or not this expression is case sensitive.
     */
    private boolean casesensitive = true;

    /**
     * The pattern that was generated from the regular expression.
     */
    private Pattern pattern = null;
    
    /**
     * Evaluates this expression in the specified context.
     */
    public boolean evaluate(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);
        String property = context.getProperty(key);
        return property!=null && pattern.matcher(property).matches();
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
     * Returns the regular expression.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the regular expression.
     */
    public void setValue(String value) {
        this.value = value;
        compilePattern();
    }

    /**
     * Returns whether or not this expression is case sensitive.
     */
    public boolean getCasesensitive() {
        return casesensitive;
    }
        
    /**
     * Sets whether or not this expression is case sensitive.
     */
    public void setCasesensitive(boolean casesensitive) {
        this.casesensitive = casesensitive;
        compilePattern();
    }

    /**
     * Generates the pattern.
     */
    private void compilePattern() {
        pattern = casesensitive 
          ? Pattern.compile(value) 
          : Pattern.compile(value, Pattern.CASE_INSENSITIVE);
    }
}
