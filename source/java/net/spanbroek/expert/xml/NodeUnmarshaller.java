package net.spanbroek.expert.xml;

import net.spanbroek.expert.*;
import com.lifecde.jxm.*;

/**
 * Contains the logic for unmarshalling a &lt;node&gt; XML tag.
 */
public class NodeUnmarshaller extends Unmarshaller {

    /**
     * Returns a <code>Node</code> object.
     */
    public Object newObject(String name) {
        return new Node();
    }

    /**
     * Adds an <code>Assignment</code> or a <code>Link</code> to a
     * </code>Node</code>.
     */
    public void add(Object parent, String currentName, Object current) {
        if (parent instanceof Node) {
            Node node = (Node)parent;
            if (current instanceof Link) {
                node.addLink((Link)current);
            }
            if (current instanceof Assignment) {
                node.addAssignment((Assignment)current);
            }
        }

    }

}
