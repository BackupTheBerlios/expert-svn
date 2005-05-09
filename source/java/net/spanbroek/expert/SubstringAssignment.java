package net.spanbroek.expert;

import java.util.Properties;

public class SubstringAssignment implements Assignment {

    /**
     * The property key.
     */
    private String key = null;

    /**
     * The value that will be appended.
     */
    private String value =  null;
    
    private int beginIndex = 0;
    
    private int endIndex = 0;

    /**
     * Applies this 'append' statement to the specified context.
     */
    public void apply(Properties context) {
        String key = InferenceEngine.evaluate(this.key, context);
        String value = InferenceEngine.evaluate(this.value, context);    
        String property = context.getProperty(key);
        
        if (endIndex < 0){
            endIndex = value.length();
        }
        
        if (beginIndex > 0 && beginIndex <= endIndex && endIndex <= value.length()){            
            if (property == null || "".equals(property)) {
                context.put(key, value.substring(beginIndex, endIndex));
            }
            else {
                context.put(key, property + "," + value.substring(beginIndex, endIndex));
            }
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
    
    /**
     * @return Returns the startIndex.
     */
    public String getBeginIndex () {
        return beginIndex+"";
    }
    
    /**
     * @param startIndex The startIndex to set.
     */
    public void setBeginIndex (String beginIndex) {
        this.beginIndex = Integer.parseInt(beginIndex);
    }
    
    /**
     * @return Returns the stopIndex.
     */
    public String getEndIndex () {
        return endIndex+"";
    }
    
    /**
     * @param stopIndex The stopIndex to set.
     */
    public void setEndIndex (String endIndex) {
        this.endIndex = Integer.parseInt(endIndex);
    }
}
