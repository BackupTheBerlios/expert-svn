package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;starts_with&gt; XML tag.
 */
public class StartsWithUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>StartsWithExpression</code> object.
     */
    public Object newObject(String name) {
        return new StartsWithExpression();
    }

}
