    package com.bard.davol.serviceImpl;
    
    import com.bard.davol.util.HibernateUtil;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.context.internal.ManagedSessionContext;
    
    public class AbstractLogicImpl
    {
      protected Session session;
    
      public AbstractLogicImpl()
      {
      }
    
      public AbstractLogicImpl(Session session)
      {
        if (session == null) {
          session = HibernateUtil.getSessionFactory().openSession();
          ManagedSessionContext.bind(session);
        }
      }
    
      public void closeSession(Session session) {
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
        if (session != null) {
          session.flush();
          if (session.isOpen())
            session.close();
        }
      }
    }

/* Location:           D:\新建文件夹\bard-cms-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.serviceImpl.AbstractLogicImpl
 * JD-Core Version:    0.5.4
 */