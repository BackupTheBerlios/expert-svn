package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling an &lt;ends_with&gt; XML tag.
 */
public class EndsWithUnmarshaller extends Unmarshaller {

    /**
     * Returns an <code>EndsWithExpression</code> object.
     */
    public Object newObject(String name) {
        return new EndsWithExpression();
    }

}
