package net.spanbroek.expert;

import com.lifecde.jxm.*;
import org.xml.sax.*;
import java.io.*;
import java.util.*;

/**
 * Represents a body of knowledge, from which other knowledge can be infered.
 */
public class InferenceEngine implements Serializable {

    /**
     * The graph that represents the knowledge.
     */
    private NodeSet nodes;

    /**
     * Constructs an <code>InferenceEngine</code>, reading an XML representation
     * of the knowledge graph from the specified <code>InputStream</code>.
     * @throws ParsingException when an error occurs while parsing the XML
     * representation.
     */
    public InferenceEngine(InputStream in) throws ParsingException {
        Reader mapReader = null;
        try {
            // load XMLMap
            mapReader = new InputStreamReader(
              InferenceEngine.class.getResourceAsStream("jxm.xml")
            );
            XMLMap map = XMLMap.unmarshal(mapReader);
            ObjectXMLReader objectReader = new ObjectXMLReader();
            objectReader.setXMLMap(map);
            // read nodes
            nodes = (NodeSet)objectReader.parse(new InputStreamReader(in));
        }
        catch(IOException exception) {
            throw new ParsingException(exception);
        }
        catch(SAXException exception) {
            throw new ParsingException(exception);
        }
        finally {
            if (mapReader != null) {
                try { mapReader.close(); } catch(IOException exception) {}
            }
        }
        // check links
        for (Iterator i=nodes.values().iterator(); i.hasNext(); ) {
            Node node = (Node)i.next();
            for (Iterator j=node.getLinks().iterator(); j.hasNext(); ) {
                Link link = (Link)j.next();
                if (!nodes.containsKey(link.getTarget())) {
                    throw new ParsingException(
                      "link target " + link.getTarget() + " does not exist"
                    );
                }
            }
        }
    }

    /**
     * Constructs an <code>InferenceEngine</code>, reading an XML representation
     * of the knowledge graph from the specified file.
     * @throws ParsingException when an error occurs while parsing the XML
     * representation.
     */
    public InferenceEngine(String file) throws ParsingException {
        this(createInputStream(file));
    }

    /**
     * Convenience method that catches any IOException that might occur while
     * creating a <code>FileInputStream</code>, and wraps it with a
     * <code>ParsingException</code>.
     */
    static private InputStream createInputStream(String file)
      throws ParsingException {
        try {
            return new FileInputStream(file);
        }
        catch(IOException exception) {
            throw new ParsingException(exception);
        }
    }

    /**
     * Starting with the specified context and at the specified node in the
     * knowledge graph, more knowledge is infered from the knowledge graph
     * and stored in the context.
     */
    private void infer(Properties context, Node node) {
        // apply the assignments that belong to this node
        List assignments = node.getAssignments();
        for (Iterator i=assignments.iterator(); i.hasNext(); ) {
            ((Assignment)i.next()).apply(context);
        }
        // evaluate all links
        List bestLinks = new LinkedList();
        int bestPriority = Integer.MIN_VALUE;
        List links = node.getLinks();
        for (Iterator i=links.iterator(); i.hasNext(); ) {
            // only evaluate links that are at least as good as the current result
            Link link = (Link)i.next();
            if (bestPriority <= link.getPriority()) {
                // if link conditions are met, add this link to the list of
                // best links, and adjust best priority
                if (link.evaluate(context)) {
                    if (bestPriority < link.getPriority()) {
                        bestLinks.clear();
                    }
                    bestLinks.add(link);
                    bestPriority = link.getPriority();
                }
            }
        }
        // recursively call the infer method on the best links
        Iterator i = bestLinks.iterator();
        if (node.getFirstmatch()) {
            // only follow first link
            if (i.hasNext()) {
                infer(context, nodes.getNode(((Link)i.next()).getTarget()));
            }
        }
        else {
            // follow all links
            while (i.hasNext()) {
                infer(context, nodes.getNode(((Link)i.next()).getTarget()));
            }
        }
        
    }

    /**
     * Starting with the specified context, more knowledge is infered from
     * the knowledge graph and stored in the context.
     */
    public void infer(Properties context) {
        infer(context, nodes.getRoot());
    }

    /**
     * Recursively replaces all occurrences of ${key} in the specified string 
     * with the value that is associated with 'key' in the specified context. 
     */
    static public String evaluate(String string, Properties properties) {
        StringBuffer buffer = new StringBuffer(string);
        for (int i=0; i<buffer.length(); i=evaluate(buffer, properties, i));
        return buffer.toString();
    }

    /**
     * Recursively replaces all occurrences of ${key} in the specified string
     * buffer with the value that is associated with 'key' in the specified 
     * context. Replacement takes place from the specified begin character
     * until either a '}' is encountered, or the end of the buffer is reached.
     */    
    static private int evaluate(StringBuffer buffer, Properties properties,
      int begin) {
        int state = 0;
        for (int i=begin; i<buffer.length(); i++) {
            switch(buffer.charAt(i)) {
                case '$':
                    state = 1;
                    break;
                case '{':
                    if (state == 1) {
                        int a = i-1;
                        int b = i+1;
                        int c = evaluate(buffer, properties, b);
                        int d = c+1;
                        String key = buffer.substring(b, c);
                        String value = properties.getProperty(key);
                        if (value == null) value = "";
                        buffer.replace(a, d, value);
                        i = a + value.length() - 1;
                    }
                    state = 0;
                    break;
                case '}':
                    return i;
                default:
                    state = 0;
                    break;
            }
        }
        return buffer.length();
    }
    
    /**
     * Exception that is thrown when an error occurs while parsing an
     * XML representation of a knowledge graph.
     */
    static public class ParsingException extends Exception {

        /**
         * Constructs a <code>ParsingException</code>.
         */
        public ParsingException() {
            super();
        }

        /**
         * Constructs a <code>ParsingException</code> with the specified
         * detail message.
         */
        public ParsingException(String message) {
            super(message);
        }

        /**
         * Constructs a <code>ParsingException</code> with the specified
         * cause.
         */
        public ParsingException(Throwable cause) {
            super(cause);
        }

    }
}
