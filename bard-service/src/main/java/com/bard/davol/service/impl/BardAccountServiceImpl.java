 package com.bard.davol.service.impl;

 import com.bard.davol.bean.Usertoken;
 import com.bard.davol.service.BardAccountService;
 import com.bard.davol.util.CommonUtil;
 import com.bard.davol.util.HibernateUtil;
 import com.bard.davol.util.UsertokenLRUCache;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang.StringUtils;
 import org.hibernate.Query;
 import org.hibernate.SQLQuery;
 import org.hibernate.Session;
 import org.hibernate.SessionFactory;
 import org.hibernate.context.internal.ManagedSessionContext;
 import org.hibernate.transform.Transformers;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

 public class BardAccountServiceImpl
   implements BardAccountService
 {
   private static final Logger logger = LoggerFactory.getLogger(BardAccountServiceImpl.class);

   public Usertoken getUsertoken(String udid)
   {
     if (StringUtils.isNotEmpty(udid)) {
       Session session = null;
       try {
         String utoken = null;
         session = HibernateUtil.getSessionFactory().openSession();
         ManagedSessionContext.bind(session);
         Query query = session.createSQLQuery("select utoken,level from t_token where udid=:udid and status='0'");
         query.setString("udid", udid);
         query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

         List list = query.list();
         String level = "";
         if ((list != null) && (list.size() > 0)) {
           utoken = ((Map)list.get(0)).get("utoken").toString();
           level = ((Map)list.get(0)).get("level").toString();
         }
         if (StringUtils.isNotEmpty(utoken)) {
           Usertoken userToken = new Usertoken();
           userToken.setUdid(udid);
           userToken.setUtoken(utoken);
           userToken.setTimestamp(new Date().getTime());
           userToken.setLevel(level);
           UsertokenLRUCache.addUsertoken(userToken);
           return userToken;
         }
       } catch (Exception e) {
         logger.error("get utoken failed!", e);
         ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
         if (session != null) {
           session.flush();
           if (session.isOpen()) {
             session.close();
           }
         }
       }
     }
     return null;
   }

   public int saveUsertoken(String udid, String utoken)
   {
     int cnt = 0;
     if ((StringUtils.isNotEmpty(udid)) && (StringUtils.isNotEmpty(utoken))) {
       Session session = null;
       try {
         session = HibernateUtil.getSessionFactory().openSession();
         ManagedSessionContext.bind(session);
         cnt = session.createSQLQuery("replace into Usertoken (udid, logindate, utoken) values(:udid, unix_timestamp(), :utoken)").setString("udid", udid).setString("utoken", utoken).executeUpdate();
       }
       catch (Exception e)
       {
         logger.error("save utoken failed!", e);
         ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
         if (session != null) {
           session.flush();
           if (session.isOpen()) {
             session.close();
           }
         }
       }
     }
     return cnt;
   }

   public Map<String, Object> loginByUdid(String udid, String utoken)
   {
     Map map = new HashMap();
     map.put("isMatch", Boolean.valueOf(false));
     map.put("level", "");
     if ((StringUtils.isNotEmpty(udid)) && (StringUtils.isNotEmpty(utoken))) {
       Usertoken userToken = UsertokenLRUCache.getUsertoken(udid);
       if (userToken == null) {
         userToken = getUsertoken(udid);
       }
       if (userToken != null) {
         if (utoken.equals(userToken.getUtoken())) {
           map.put("isMatch", Boolean.valueOf(true));
         } else {
           userToken = getUsertoken(udid);
           if ((userToken != null) && (userToken.getUtoken().equals(utoken))) {
             map.put("isMatch", Boolean.valueOf(true));
           }
         }
         userToken = getUsertoken(udid);
         map.put("level", userToken.getLevel());
       }
     }
     return map;
   }

   public boolean isValidUtoken(String utoken)
   {
     if (StringUtils.isNotEmpty(utoken)) {
       Session session = null;
       try {
         String status = null;
         session = HibernateUtil.getSessionFactory().openSession();
         ManagedSessionContext.bind(session);
         Query query = session.createSQLQuery("select tid, status from t_token where utoken=:utoken");
         query.setString("utoken", utoken);
         query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

         List list = query.list();
         if ((list != null) && (list.size() > 0)) {
           status = ((Map)list.get(0)).get("status").toString();
         }
         if ((StringUtils.isNotEmpty(status)) &&
           (CommonUtil.VALID.equals(status)))
           return true;
       }
       catch (Exception e)
       {
         logger.error("validate utoken failed.", e);
         ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
         if (session != null) {
           session.flush();
           if (session.isOpen()) {
             session.close();
           }
         }
       }
     }
     return false;
   }
 }

