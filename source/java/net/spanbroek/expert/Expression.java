package net.spanbroek.expert;

import java.io.*;
import java.util.*;

/**
 * Represents a boolean expression.
 */
public interface Expression extends Serializable {

    /**
     * Evaluates the expression in the specified context.
     */
    boolean evaluate(Properties context);

}
