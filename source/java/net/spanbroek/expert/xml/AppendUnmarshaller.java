package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling an &lt;append&gt; XML tag.
 */
public class AppendUnmarshaller extends Unmarshaller {

    /**
     * Returns an <code>AppendAssignment</code> object.
     */
    public Object newObject(String name) {
        return new AppendAssignment();
    }

}
