package net.spanbroek.expert;

import java.io.*;

/**
 * Represents a link from one node in the knowledge graph to another.
 */
public class Link extends AndExpression implements Serializable {

    /**
     * The target node.
     */
    private String target = null;

    /**
     * The priority of this link.
     */
    private int priority = 0;

    /**
     * Returns the target node.
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the target node.
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Returns the link priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the link priority.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

}
