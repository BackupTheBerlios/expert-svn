package net.spanbroek.expert;

import java.util.*;

/**
 * Represents a set of nodes.
 */
public class NodeSet extends HashMap {

    /**
     * The root (starting) node.
     */
    private String root = null;

    /**
     * Adds a node.
     */
    public void addNode(Node node) {
        put(node.getId(), node);
    }

    /**
     * Returns the node with the specified id.
     */
    public Node getNode(String id) {
        return (Node)get(id);
    }

    /**
     * Returns the root (starting) node.
     */
    public Node getRoot() {
        return getNode(root);
    }

    /**
     * Sets the root (starting) node.
     */
    public void setRoot(String root) {
        this.root = root;
    }

}
