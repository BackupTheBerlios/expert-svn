package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling an &lt;equals&gt; XML tag.
 */
public class EqualsUnmarshaller extends Unmarshaller {

    /**
     * Returns an <code>EqualsExpression</code> object.
     */
    public Object newObject(String name) {
        return new EqualsExpression();
    }

}
