package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;contains&gt; XML tag.
 */
public class ContainsUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>ContainsExpression</code> object.
     */
    public Object newObject(String name) {
        return new ContainsExpression();
    }

}
