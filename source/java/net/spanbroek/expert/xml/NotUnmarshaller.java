package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;not&gt; XML tag.
 */
public class NotUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>NotExpression</code> object.
     */
    public Object newObject(String name) {
        return new NotExpression();
    }

    /**
     * Sets an <code>Expression</code> operand in a </code>NotExpression</code>.
     */
    public void add(Object parent, String currentName, Object current) {
        if (parent instanceof NotExpression && current instanceof Expression) {
            ((NotExpression)parent).setOperand((Expression)current);
        }

    }

}
