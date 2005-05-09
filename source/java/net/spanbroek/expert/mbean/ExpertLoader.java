package net.spanbroek.expert.mbean;

import java.io.File;

import org.apache.log4j.*;

import net.spanbroek.expert.InferenceEngine;

/**
 * Loads the expert xml file that is specified using 
 * {@link #setFileName(String)} into JNDI under the name specified using 
 * {@link #setJndiName(String)}. The object that is loaded into JNDI is of type
 * {@link net.spanbroek.expert.InferenceEngine}.
 *
 * @jmx.mbean
 */
public class ExpertLoader extends JndiLoader implements ExpertLoaderMBean {

    /**
     * The log4j logger.
     */    
    private Logger logger = Logger.getLogger(getClass());
    
    /**
     * The expert xml file name.
     */
    private String fileName = null;
    
    /**
     * This is timestamp of the loaded configuration file.
     */
    private long lastModified = -1;
    
    /**
     * Returns the expert xml file name.
     *
     * @jmx.managed-attribute
     */    
    public String getFileName() {
        return fileName;
    }
    
    /**
     * Sets the expert xml file name.
     *
     * @jmx.managed-attribute
     */    
    public void setFileName(String fileName) {
        this.fileName = fileName;
        restart();
    }
        
    /* (non-Javadoc)
     * @see net.spanbroek.expert.mbean.JndiLoader#getResourceName()
     */
    protected String getResourceName () {
        return fileName;
    }
    
    /**
     * This will check the file's timestamp to see if it has been modified.
     */
    protected boolean isResourceModified () {        
        File file = new File(fileName);
        logger.debug("Check for resource modification.");
        
        boolean isChanged = (lastModified != file.lastModified());
        
        if (isChanged){
            logger.info(fileName + " has changed.");
        }
        
        return isChanged;
    }
    
    /**
     * Loads the {@link net.spanbroek.expert.InferenceEngine} object.
     */
    protected Object load() {
        try {
            InferenceEngine ie = new InferenceEngine(fileName);
            
            File file = new File(fileName);
            lastModified = file.lastModified();
            
            logger.info(fileName + " is loaded.");
            
            return ie;
        }
        catch(Exception exception) {
            logger.error(exception);
            return null;
        }
    }
    
    // because inheritance for these beans isn't supported yet, we have to 
    // restate the methods of the super class here:

    /**
     * @jmx.managed-attribute
     */
    public void create() {
        super.create();
    }
    
    /**
     * @jmx.managed-attribute
     */
    public void start() {
        super.start();
    }
    
    /**
     * @jmx.managed-attribute
     */
    public void stop() {
        super.stop();
    }
    
    /**
     * @jmx.managed-attribute
     */
    public void destroy() {
        super.destroy();
    }

    /**
     * @jmx.managed-attribute
     */
    public String getJndiName() {
        return super.getJndiName();
    }

    /**
     * @jmx.managed-attribute
     */
    public int getReloadInterval() {
        return super.getReloadInterval();
    }

    /**
     * @jmx.managed-attribute
     */
    public void setJndiName(String jndiName) {
        super.setJndiName(jndiName);
    }

    /**
     * @jmx.managed-attribute
     */
    public void setReloadInterval(int reloadInterval) {
        super.setReloadInterval(reloadInterval);
    }
}