package com.bard.davol.serviceImpl;

import com.bard.davol.entity.UserToken;
import com.bard.davol.service.UserService;
import com.bard.davol.util.CommonUtil;
import com.bard.davol.util.DateUtils;
import com.bard.davol.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService
{
  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  public List<UserToken> getUserTokenList()
  {
    List<UserToken> usertokenList = new ArrayList<UserToken>();
    Session session = null;
    try {
      session = HibernateUtil.getSession();
      ManagedSessionContext.bind(session);

      logger.error("session=" + session);
      Query query = session.createSQLQuery("select tid,uname,udid,utoken,status,level,timestamp,modifytime,region,rank from t_token order by status");
      query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

      List<Map<String,Object>> list = query.list();
      if ((list != null) && (list.size() > 0))
        for (Map<String, Object> map : list) {
          UserToken userToken = new UserToken();
          userToken.setTid(CommonUtil.parseInt(map.get("tid"), 0));
          userToken.setUname(map.get("uname").toString());
          userToken.setUdid(map.get("udid").toString());
          userToken.setUtoken(map.get("utoken").toString());
          userToken.setStatus(map.get("status").toString());
          userToken.setUserType(map.get("level").toString());
          String timestamp = map.get("timestamp").toString();
          if (StringUtils.isNotEmpty(timestamp)) {
            String date = DateUtils.date24ToString(new Date(Long.parseLong(timestamp + "000")));
            userToken.setTimestamp(date);
          }
          String modifytime = map.get("modifytime").toString();
          if (StringUtils.isNotBlank(modifytime)) {
            String modify = DateUtils.date24ToString(new Date(Long.parseLong(modifytime + "000")));
            userToken.setModifytime(modify);
          }
          userToken.setRegion(map.get("region").toString());
          userToken.setRank(map.get("rank").toString());
          usertokenList.add(userToken);
        }
    }
    catch (Exception e) {
      logger.error("get user token failed!", e);
    } finally {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      HibernateUtil.closeSession();
    }
    return usertokenList;
  }

  public void addUsertoken(UserToken userToken)
  {
    if (userToken != null) {
      Session session = null;
      try {
        session = HibernateUtil.getSession();
        ManagedSessionContext.bind(session);

        String uname = userToken.getUname();
        String udid = userToken.getUdid();
        String utoken = userToken.getUtoken();
        String status = userToken.getStatus();
        String userType = userToken.getUserType();
        String region = userToken.getRegion();
        String rank = userToken.getRank();
        String sql = "insert into t_token (uname,udid,utoken,status,timestamp,level,region,rank) values(:uname,:udid,:utoken,:status,unix_timestamp(),:level,:region,:rank)";
        Query query = session.createSQLQuery(sql);
        query.setString("uname", uname);
        query.setString("udid", udid);
        query.setString("utoken", utoken);
        query.setString("status", status);
        query.setString("level", userType);
        query.setString("region", region);
        query.setString("rank", rank);
        int cnt = query.executeUpdate();
        logger.error("========add user token======" + userToken + " ,cnt=" + cnt);
      } catch (Exception e) {
        logger.error("get user token failed!", e);
      } finally {
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
        HibernateUtil.closeSession();
      }
    }
  }

  public UserToken getUserToken(int tid)
  {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      ManagedSessionContext.bind(session);

      UserToken userToken = new UserToken();
      String sql = "select tid,uname,udid,utoken,status,level,region,rank from t_token where tid=:tid";
      Query query = session.createSQLQuery(sql);
      query.setInteger("tid", tid);
      query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

      List list = query.list();
      if ((list != null) && (list.size() > 0)) {
        Map map = (Map)list.get(0);
        if ((map != null) && (!map.isEmpty())) {
          int t_id = CommonUtil.parseInt(map.get("tid"), 0);
          userToken.setTid(t_id);
          userToken.setUname(map.get("uname").toString());
          userToken.setUdid(map.get("udid").toString());
          userToken.setUtoken(map.get("utoken").toString());
          userToken.setStatus(map.get("status").toString());
          userToken.setUserType(map.get("level").toString());
          userToken.setRegion(map.get("region").toString());
          userToken.setRank(map.get("rank").toString());
        }
      }

      return userToken;
    }
    catch (Exception e)
    {
      logger.error("get user token failed!", e);
    } finally {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      HibernateUtil.closeSession();
    }
    return null;
  }

  public int checkUdid(String udid)
  {
    int tid = 0;
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      ManagedSessionContext.bind(session);

      String sql = "select tid from t_token where udid=:udid and status = '0'";
      Query query = session.createSQLQuery(sql);
      query.setString("udid", udid);
      query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

      List list = query.list();
      if ((list != null) && (list.size() > 0)) {
        Map map = (Map)list.get(0);
        if ((map != null) && (!map.isEmpty()))
          tid = CommonUtil.parseInt(map.get("tid"), 0);
      }
    }
    catch (Exception e) {
      logger.error("check user token failed!", e);
    } finally {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      HibernateUtil.closeSession();
    }
    return tid;
  }

  public void deleteUsertoken(int tid)
  {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      ManagedSessionContext.bind(session);

      String sql = "delete from t_token where tid=:tid";
      Query query = session.createSQLQuery(sql);
      query.setInteger("tid", tid);
      int updCount = query.executeUpdate();
      logger.error("delete user token ok. tid=" + tid + " ,updCount=" + updCount);
    } catch (HibernateException e) {
      logger.error("delete user token error.", e);
    } finally {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      HibernateUtil.closeSession();
    }
  }

  public void invalidUsertoken(int tid)
  {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      ManagedSessionContext.bind(session);

      String sql = "update t_token set status = '1',modifytime=unix_timestamp() where tid=:tid";
      Query query = session.createSQLQuery(sql);
      query.setInteger("tid", tid);
      int updCount = query.executeUpdate();
      logger.error("update user token ok. tid=" + tid + " ,updCount=" + updCount);
    } catch (HibernateException e) {
      logger.error("update user token error.", e);
    } finally {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      HibernateUtil.closeSession();
    }
  }

  public void updateUsertoken(UserToken userToken)
  {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      ManagedSessionContext.bind(session);

      String sql = "update t_token set uname=:uname, udid=:udid,level=:level,region=:region,rank=:rank where tid=:tid";
      Query query = session.createSQLQuery(sql);
      query.setInteger("tid", userToken.getTid());
      query.setString("uname", userToken.getUname());
      query.setString("udid", userToken.getUdid());
      query.setString("level", userToken.getUserType());
      query.setString("region", userToken.getRegion());
      query.setString("rank", userToken.getRank());
      int cnt = query.executeUpdate();
      logger.error("=========update user token, cnt=" + cnt + " ,userToken=" + userToken);
    } catch (HibernateException e) {
      logger.error("update t_token failed. userToken=" + userToken, e);
    } finally {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      HibernateUtil.closeSession();
    }
  }
}
