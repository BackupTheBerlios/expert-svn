package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;
import org.xml.sax.*;

/**
 * Contains the logic for unmarshalling an &lt;assign&gt; XML tag.
 */
public class AssignUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>LiteralAssignment</code> object.
     */
    public Object newObject(String name) {
        return new LiteralAssignment();
    }

}
