package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling an &lt;or&gt; XML tag.
 */
public class OrUnmarshaller extends Unmarshaller {

    /**
     * Returns an <code>OrExpression</code> object.
     */
    public Object newObject(String name) {
        return new OrExpression();
    }

    /**
     * Adds an <code>Expression</code> to an </code>OrExpression</code>.
     */
    public void add(Object parent, String currentName, Object current) {
        if (parent instanceof OrExpression && current instanceof Expression) {
            ((OrExpression)parent).addOperand((Expression)current);
        }

    }

}
