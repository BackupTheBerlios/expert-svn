package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;nodes&gt; XML tag.
 */
public class NodesUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>NodeSet</code> object.
     */
    public Object newObject(String name) {
        return new NodeSet();
    }

    /**
     * Adds a <code>Node</code> to a </code>NodeSet</code>.
     */
    public void add(Object parent, String currentName, Object current) {
        if (parent instanceof NodeSet && current instanceof Node) {
            ((NodeSet)parent).addNode((Node)current);
        }
    }

}
