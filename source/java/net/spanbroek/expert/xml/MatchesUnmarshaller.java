package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;matches&gt; XML tag.
 */
public class MatchesUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>MatchesExpression</code> object.
     */
    public Object newObject(String name) {
        return new MatchesExpression();
    }

}
