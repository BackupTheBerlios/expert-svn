package net.spanbroek.expert;

import java.io.*;
import java.util.*;

/**
 * Represents an assignment.
 */
public interface Assignment extends Serializable {

    /**
     * Apply this assignment to the specified context.
     */
    void apply(Properties context);

}
