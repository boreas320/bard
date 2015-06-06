    package com.bard.davol.common;
    
    import java.util.HashMap;
    import java.util.Map;
    import org.hibernate.Session;
    
    public class ContextManager
    {
      private static final ThreadLocal<Map<String, Object>> context = new ThreadLocal();
    
      public static void bindSession(Session session) {
        contextMap(true).put(Session.class.getSimpleName(), session);
      }
    
      public static Session currentSession() {
        return (Session)contextMap(false).get(Session.class.getSimpleName());
      }
    
      public static Session unbindSession() {
        Session existing = null;
        Map map = contextMap(false);
        if (map != null) {
          existing = (Session)map.remove(Session.class.getSimpleName());
        }
        return existing;
      }
    
      private static synchronized Map<String, Object> contextMap(boolean createMap) {
        Map map = (Map)context.get();
        if ((map == null) && (createMap)) {
          map = new HashMap();
          context.set(map);
        }
        return map;
      }
    }

/* Location:           D:\新建文件夹\bard-cms-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.common.ContextManager
 * JD-Core Version:    0.5.4
 */