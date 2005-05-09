package net.spanbroek.expert.mbean;

import org.apache.log4j.*;
import javax.naming.*;

/**
 * An abstract MBean that can be used to put something in JNDI, and reload it
 * every now and then.
 * 
 * @jmx.mbean
 */
public abstract class JndiLoader implements JndiLoaderMBean {

    /**
     * The log4j logger.
     */
    private Logger logger = Logger.getLogger(getClass());

    /**
     * Indicates whether or not this mbean has been started.
     */
    private boolean started = false;

    /**
     * The reload interval.
     */
    private int reloadInterval = 30 * 60 * 1000;

    /**
     * The JNDI name where the loaded object is stored.
     */
    private String jndiName = null;

    /**
     * The thread that is used for reloading.
     */
    private ReloadThread thread;

    /**
     * Called upon mbean creation.
     * 
     * @jmx.managed-attribute
     */
    public synchronized void create () {
    // skip
    }

    /**
     * Called upon mbean start.
     * 
     * @jmx.managed-attribute
     */
    public synchronized void start () {
        thread = new ReloadThread();
        thread.start();
        started = true;
        
        logger.info("Resource has been loaded: " + getResourceName());
    }

    /**
     * Called upon mbean stop.
     * 
     * @jmx.managed-attribute
     */
    public synchronized void stop () {
        thread.quit();
        thread = null;
        started = false;
        logger.info("Resource has been removed: " + getResourceName());
    }

    /**
     * Called before mbean destruction. Removes the loaded object from JNDI.
     * 
     * @jmx.managed-attribute
     */
    public synchronized void destroy () {
        try {
            Context context = new InitialContext();
            context.unbind(jndiName);
            context.close();
            context = null;
        }
        catch (Exception exception) {
            logger.error(exception);
        }
    }

    /**
     * Restarts this mbean if it is already started. If is isn't started, this
     * method does nothing. This method is usefull for restarting the mbean
     * after an attribute (such as the reload interval) has changed.
     */
    protected synchronized void restart () {
        if (started) {
            stop();
            start();
        }
    }

    /**
     * Returns the JNDI name.
     * 
     * @jmx.managed-attribute
     */
    public String getJndiName () {
        return jndiName;
    }

    /**
     * Returns the reload interval.
     * 
     * @jmx.managed-attribute
     */
    public int getReloadInterval () {
        return reloadInterval;
    }

    /**
     * Sets the JNDI name.
     * 
     * @jmx.managed-attribute
     */
    public void setJndiName (String jndiName) {
        this.jndiName = jndiName;
        restart();
    }

    /**
     * Sets the reload interval.
     * 
     * @jmx.managed-attribute
     */
    public void setReloadInterval (int reloadInterval) {
        this.reloadInterval = reloadInterval;
        restart();
    }
    
    /**
     * This should show a display name fro the resource.
     * @return
     */
    protected abstract String getResourceName();

    /**
     * This method is called periodically to see if the resource should be
     * reloaded.
     * 
     * @return It will return true if the resource was modified.
     */
    protected abstract boolean isResourceModified ();

    /**
     * This method is called every now and then to load the object that will be
     * stored in JNDI. If this method returns <code>null</code> then nothing
     * will be altered in JNDI.
     */
    protected abstract Object load ();

    /**
     * Thread that will be used to reload every now and then. Interrupt this
     * thread to make it stop.
     */
    private class ReloadThread extends Thread {
        private boolean quit = false;
        
        public void quit(){
            quit = true;
        }

        /**
         * Starts reloading.
         */
        public void run () {
            logger.info("Started monitoring " + getResourceName());
            while (!quit) {
                try {
                    if (isResourceModified()) {
                        Object object = load();
                        if (object != null) {
                            String[] s = jndiName.split("/");
                            Context c = new InitialContext();
                            for (int i = 0; i < s.length - 1; i++) {
                                try {
                                    c = (Context) c.lookup(s[i]);
                                }
                                catch (NamingException exception) {
                                    c = c.createSubcontext(s[i]);
                                }
                            }
                            c.rebind(s[s.length - 1], object);
                        }
                    }
                }
                catch (Exception exception) {
                    logger.error(exception);
                }
                try {
                    sleep(reloadInterval);
                }
                catch (InterruptedException exception) {
                    // skip
                }
            }
            
            logger.info("Stopped monitoring " + getResourceName());
        }

    }

}