package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;between&gt; XML tag.
 */
public class BetweenUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>BetweenExpression</code> object.
     */
    public Object newObject(String name) {
        return new BetweenExpression();
    }

}
