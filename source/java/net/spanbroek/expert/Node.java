package net.spanbroek.expert;

import java.io.*;
import java.util.*;

/**
 * Represents a node in the knowledge graph.
 */
public class Node implements Serializable {

    /**
     * The node identifier.
     */
    private String id = null;

    /**
     * The list of assignments that belong to this node.
     */
    private LinkedList assignments = new LinkedList();

    /**
     * The list of links that belong to this node.
     */
    private LinkedList links = new LinkedList();
    
    /**
     * Indicates whether or not only the first matching link should be 
     * evaluated.
     */
    private boolean firstmatch = false;

    /**
     * Returns the node identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the node identifier.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the list of assignments.
     */
    public List getAssignments() {
        return assignments;
    }

    /**
     * Adds an assignment.
     */
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    /**
     * Returns the list of links.
     */
    public List getLinks() {
        return links;
    }

    /**
     * Adds a link.
     */
    public void addLink(Link link) {
        links.add(link);
    }
    
    /**
     * Sets the boolean that indicates whether or not only the first matching 
     * link should be evaluated.
     */
    public void setFirstmatch(boolean firstmatch) {
        this.firstmatch = firstmatch;
    }
    
    /**
     * Returns whether or not only the first matching link should be evaluated.
     */
    public boolean getFirstmatch() {
        return firstmatch;
    }
    

}
