package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling an &lt;and&gt; XML tag.
 */
public class AndUnmarshaller extends Unmarshaller {

    /**
     * Returns an <code>AndExpression</code> object.
     */
    public Object newObject(String name) {
        return new AndExpression();
    }

    /**
     * Adds an <code>Expression</code> to a </code>AndExpression</code>.
     */
    public void add(Object parent, String currentName, Object current) {
        if (parent instanceof AndExpression && current instanceof Expression) {
            ((AndExpression)parent).addOperand((Expression)current);
        }

    }

}
