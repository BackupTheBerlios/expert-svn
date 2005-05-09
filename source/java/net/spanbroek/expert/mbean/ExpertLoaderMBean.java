package net.spanbroek.expert.mbean;

/**
 * MBean interface.
 */
public interface ExpertLoaderMBean {

   /**
    * Returns the expert xml file name.
    */
  java.lang.String getFileName() ;

   /**
    * Sets the expert xml file name.
    */
  void setFileName(java.lang.String fileName) ;

  void create() ;

  void start() ;

  void stop() ;

  void destroy() ;

  java.lang.String getJndiName() ;

  int getReloadInterval() ;

  void setJndiName(java.lang.String jndiName) ;

  void setReloadInterval(int reloadInterval) ;

}
