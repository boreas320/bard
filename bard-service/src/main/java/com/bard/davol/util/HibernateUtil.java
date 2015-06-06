 package com.bard.davol.util;

 import org.hibernate.SessionFactory;
 import org.hibernate.cfg.Configuration;
 import org.hibernate.service.ServiceRegistry;
 import org.hibernate.service.ServiceRegistryBuilder;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

 public class HibernateUtil
 {
   private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
   private static HibernateUtil instance = null;
   private SessionFactory sessionFactory;

   private void init()
   {
     try
     {
       String hibernateCfg = System.getProperty("hibernate.cfg.path", "hibernate.cfg.xml");
       logger.info("use hibernateCfg:" + hibernateCfg);
       Configuration cfg = new Configuration().configure(hibernateCfg);
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
       this.sessionFactory = cfg.buildSessionFactory(serviceRegistry);
       logger.info("Initiate SessionFactory creation successfully.");
     } catch (Throwable ex) {
       logger.error("Initiating SessionFactory creation failed.", ex);
       throw new ExceptionInInitializerError(ex);
     }
   }

   public static SessionFactory getSessionFactory() {
     if (instance == null) {
       synchronized (HibernateUtil.class) {
         if (instance == null) {
           instance = new HibernateUtil();
           instance.init();
         }
       }
     }
     return instance.sessionFactory;
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.util.HibernateUtil
 * JD-Core Version:    0.5.4
 */