package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;link&gt; XML tag.
 */
public class LinkUnmarshaller extends AndUnmarshaller {

    /**
     * Returns a <code>Link</code> object.
     */
    public Object newObject(String name) {
        return new Link();
    }

}
