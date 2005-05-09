package net.spanbroek.expert.mbean;

/**
 * MBean interface.
 */
public interface JndiLoaderMBean {

   /**
    * Called upon mbean creation.
    */
  void create() ;

   /**
    * Called upon mbean start.
    */
  void start() ;

   /**
    * Called upon mbean stop.
    */
  void stop() ;

   /**
    * Called before mbean destruction. Removes the loaded object from JNDI.
    */
  void destroy() ;

   /**
    * Returns the JNDI name.
    */
  java.lang.String getJndiName() ;

   /**
    * Returns the reload interval.
    */
  int getReloadInterval() ;

   /**
    * Sets the JNDI name.
    */
  void setJndiName(java.lang.String jndiName) ;

   /**
    * Sets the reload interval.
    */
  void setReloadInterval(int reloadInterval) ;

}
