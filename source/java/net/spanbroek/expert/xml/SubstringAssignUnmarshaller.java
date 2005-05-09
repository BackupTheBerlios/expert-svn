package net.spanbroek.expert.xml;

import com.lifecde.jxm.Unmarshaller;

import net.spanbroek.expert.SubstringAssignment;

public class SubstringAssignUnmarshaller extends Unmarshaller {
    /**
     * Returns an <code>SubstringAssignment</code> object.
     */
    public Object newObject(String name) {
        return new SubstringAssignment();
    }
}
