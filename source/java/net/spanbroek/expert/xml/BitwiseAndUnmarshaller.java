package net.spanbroek.expert.xml;

import com.lifecde.jxm.Unmarshaller;

import net.spanbroek.expert.BitwiseAndExpression;

/**
 * Contains the logic for unmarshalling an &lt;bitwise_and&gt; XML tag.
 */
public class BitwiseAndUnmarshaller extends Unmarshaller {
    /**
     * Returns an <code>BitwiseAndExpression</code> object.
     */
    public Object newObject(String name) {
        return new BitwiseAndExpression();
    }
}
