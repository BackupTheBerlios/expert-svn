package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling an &lt;exists&gt; XML tag.
 */
public class ExistsUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>ExistsExpression</code> object.
     */
    public Object newObject(String name) {
        return new ExistsExpression();
    }

}
