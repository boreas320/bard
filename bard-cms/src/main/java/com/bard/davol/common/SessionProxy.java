/*     */ package com.bard.davol.common;
/*     */ 
/*     */ import com.bard.davol.util.HibernateUtil;
/*     */ import java.io.Serializable;
/*     */ import java.sql.Connection;
/*     */ import org.hibernate.CacheMode;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.Filter;
/*     */ import org.hibernate.FlushMode;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.IdentifierLoadAccess;
/*     */ import org.hibernate.LobHelper;
/*     */ import org.hibernate.LockMode;
/*     */ import org.hibernate.LockOptions;
/*     */ import org.hibernate.NaturalIdLoadAccess;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.ReplicationMode;
/*     */ import org.hibernate.SQLQuery;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.Session.LockRequest;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.SharedSessionBuilder;
/*     */ import org.hibernate.SimpleNaturalIdLoadAccess;
/*     */ import org.hibernate.Transaction;
/*     */ import org.hibernate.TypeHelper;
/*     */ import org.hibernate.UnknownProfileException;
/*     */ import org.hibernate.jdbc.ReturningWork;
/*     */ import org.hibernate.jdbc.Work;
/*     */ import org.hibernate.stat.SessionStatistics;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class SessionProxy
/*     */   implements Session
/*     */ {
/*     */   private static final long serialVersionUID = 4261082830261322668L;
/*  40 */   private static final Logger logger = LoggerFactory.getLogger(SessionProxy.class);
/*     */   private Session session;
/*     */ 
/*     */   public String getTenantIdentifier()
/*     */   {
/*  46 */     return getSession().getTenantIdentifier();
/*     */   }
/*     */ 
/*     */   public Transaction beginTransaction()
/*     */   {
/*  51 */     if (this.session == null) {
/*  52 */       return null;
/*     */     }
/*     */ 
/*  55 */     return this.session.beginTransaction();
/*     */   }
/*     */ 
/*     */   public Transaction getTransaction()
/*     */   {
/*  60 */     if (this.session == null) {
/*  61 */       return null;
/*     */     }
/*  63 */     return this.session.getTransaction();
/*     */   }
/*     */ 
/*     */   public Query getNamedQuery(String queryName)
/*     */   {
/*  68 */     return getSession().getNamedQuery(queryName);
/*     */   }
/*     */ 
/*     */   public Query createQuery(String queryString)
/*     */   {
/*  73 */     return getSession().createQuery(queryString);
/*     */   }
/*     */ 
/*     */   public SQLQuery createSQLQuery(String queryString)
/*     */   {
/*  78 */     return getSession().createSQLQuery(queryString);
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria(Class persistentClass)
/*     */   {
/*  83 */     return getSession().createCriteria(persistentClass);
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria(Class persistentClass, String alias)
/*     */   {
/*  88 */     return getSession().createCriteria(persistentClass, alias);
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria(String entityName)
/*     */   {
/*  93 */     return getSession().createCriteria(entityName);
/*     */   }
/*     */ 
/*     */   public Criteria createCriteria(String entityName, String alias)
/*     */   {
/*  98 */     return getSession().createCriteria(entityName, alias);
/*     */   }
/*     */ 
/*     */   public SharedSessionBuilder sessionWithOptions()
/*     */   {
/* 103 */     return getSession().sessionWithOptions();
/*     */   }
/*     */ 
/*     */   public void flush() throws HibernateException
/*     */   {
/* 108 */     if (this.session == null) {
/* 109 */       return;
/*     */     }
/* 111 */     this.session.flush();
/*     */   }
/*     */ 
/*     */   public void setFlushMode(FlushMode flushMode)
/*     */   {
/* 116 */     if (this.session == null) {
/* 117 */       return;
/*     */     }
/* 119 */     this.session.setFlushMode(flushMode);
/*     */   }
/*     */ 
/*     */   public FlushMode getFlushMode()
/*     */   {
/* 124 */     if (this.session == null) {
/* 125 */       return null;
/*     */     }
/* 127 */     return this.session.getFlushMode();
/*     */   }
/*     */ 
/*     */   public void setCacheMode(CacheMode cacheMode)
/*     */   {
/* 132 */     getSession().setCacheMode(cacheMode);
/*     */   }
/*     */ 
/*     */   public CacheMode getCacheMode()
/*     */   {
/* 137 */     return getSession().getCacheMode();
/*     */   }
/*     */ 
/*     */   public SessionFactory getSessionFactory()
/*     */   {
/* 142 */     if (this.session == null) {
/* 143 */       return null;
/*     */     }
/*     */ 
/* 146 */     return this.session.getSessionFactory();
/*     */   }
/*     */ 
/*     */   public Connection close() throws HibernateException
/*     */   {
/* 151 */     if (this.session == null) {
/* 152 */       return null;
/*     */     }
/* 154 */     return this.session.close();
/*     */   }
/*     */ 
/*     */   public void cancelQuery() throws HibernateException
/*     */   {
/* 159 */     getSession().cancelQuery();
/*     */   }
/*     */ 
/*     */   public boolean isOpen()
/*     */   {
/* 164 */     if (this.session == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     return this.session.isOpen();
/*     */   }
/*     */ 
/*     */   public boolean isConnected()
/*     */   {
/* 172 */     return getSession().isConnected();
/*     */   }
/*     */ 
/*     */   public boolean isDirty() throws HibernateException
/*     */   {
/* 177 */     return getSession().isDirty();
/*     */   }
/*     */ 
/*     */   public boolean isDefaultReadOnly()
/*     */   {
/* 182 */     return getSession().isDefaultReadOnly();
/*     */   }
/*     */ 
/*     */   public void setDefaultReadOnly(boolean readOnly)
/*     */   {
/* 187 */     getSession().setDefaultReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */   public Serializable getIdentifier(Object object)
/*     */   {
/* 192 */     return getSession().getIdentifier(object);
/*     */   }
/*     */ 
/*     */   public boolean contains(Object object)
/*     */   {
/* 197 */     return getSession().contains(object);
/*     */   }
/*     */ 
/*     */   public void evict(Object object)
/*     */   {
/* 202 */     getSession().evict(object);
/*     */   }
/*     */ 
/*     */   public Object load(Class theClass, Serializable id, LockMode lockMode)
/*     */   {
/* 207 */     return getSession().load(theClass, id, lockMode);
/*     */   }
/*     */ 
/*     */   public Object load(Class theClass, Serializable id, LockOptions lockOptions)
/*     */   {
/* 212 */     return getSession().load(theClass, id, lockOptions);
/*     */   }
/*     */ 
/*     */   public Object load(String entityName, Serializable id, LockMode lockMode)
/*     */   {
/* 217 */     return getSession().load(entityName, id, lockMode);
/*     */   }
/*     */ 
/*     */   public Object load(String entityName, Serializable id, LockOptions lockOptions)
/*     */   {
/* 222 */     return getSession().load(entityName, id, lockOptions);
/*     */   }
/*     */ 
/*     */   public Object load(Class theClass, Serializable id)
/*     */   {
/* 227 */     return getSession().load(theClass, id);
/*     */   }
/*     */ 
/*     */   public Object load(String entityName, Serializable id)
/*     */   {
/* 232 */     return getSession().load(entityName, id);
/*     */   }
/*     */ 
/*     */   public void load(Object object, Serializable id)
/*     */   {
/* 237 */     getSession().load(object, id);
/*     */   }
/*     */ 
/*     */   public void replicate(Object object, ReplicationMode replicationMode)
/*     */   {
/* 242 */     getSession().replicate(object, replicationMode);
/*     */   }
/*     */ 
/*     */   public void replicate(String entityName, Object object, ReplicationMode replicationMode)
/*     */   {
/* 247 */     getSession().replicate(entityName, object, replicationMode);
/*     */   }
/*     */ 
/*     */   public Serializable save(Object object)
/*     */   {
/* 252 */     return getSession().save(object);
/*     */   }
/*     */ 
/*     */   public Serializable save(String entityName, Object object)
/*     */   {
/* 257 */     return getSession().save(entityName, object);
/*     */   }
/*     */ 
/*     */   public void saveOrUpdate(Object object)
/*     */   {
/* 262 */     getSession().saveOrUpdate(object);
/*     */   }
/*     */ 
/*     */   public void saveOrUpdate(String entityName, Object object)
/*     */   {
/* 267 */     getSession().saveOrUpdate(entityName, object);
/*     */   }
/*     */ 
/*     */   public void update(Object object)
/*     */   {
/* 272 */     getSession().update(object);
/*     */   }
/*     */ 
/*     */   public void update(String entityName, Object object)
/*     */   {
/* 277 */     getSession().update(entityName, object);
/*     */   }
/*     */ 
/*     */   public Object merge(Object object)
/*     */   {
/* 282 */     return getSession().merge(object);
/*     */   }
/*     */ 
/*     */   public Object merge(String entityName, Object object)
/*     */   {
/* 287 */     return getSession().merge(entityName, object);
/*     */   }
/*     */ 
/*     */   public void persist(Object object)
/*     */   {
/* 292 */     getSession().persist(object);
/*     */   }
/*     */ 
/*     */   public void persist(String entityName, Object object)
/*     */   {
/* 297 */     getSession().persist(entityName, object);
/*     */   }
/*     */ 
/*     */   public void delete(Object object)
/*     */   {
/* 302 */     getSession().delete(object);
/*     */   }
/*     */ 
/*     */   public void delete(String entityName, Object object)
/*     */   {
/* 307 */     getSession().delete(entityName, object);
/*     */   }
/*     */ 
/*     */   public void lock(Object object, LockMode lockMode)
/*     */   {
/* 312 */     getSession().lock(object, lockMode);
/*     */   }
/*     */ 
/*     */   public void lock(String entityName, Object object, LockMode lockMode)
/*     */   {
/* 317 */     getSession().lock(entityName, object, lockMode);
/*     */   }
/*     */ 
/*     */   public Session.LockRequest buildLockRequest(LockOptions lockOptions)
/*     */   {
/* 322 */     return getSession().buildLockRequest(lockOptions);
/*     */   }
/*     */ 
/*     */   public void refresh(Object object)
/*     */   {
/* 327 */     getSession().refresh(object);
/*     */   }
/*     */ 
/*     */   public void refresh(String entityName, Object object)
/*     */   {
/* 332 */     getSession().refresh(entityName, object);
/*     */   }
/*     */ 
/*     */   public void refresh(Object object, LockMode lockMode)
/*     */   {
/* 337 */     getSession().refresh(object, lockMode);
/*     */   }
/*     */ 
/*     */   public void refresh(Object object, LockOptions lockOptions)
/*     */   {
/* 342 */     getSession().refresh(object, lockOptions);
/*     */   }
/*     */ 
/*     */   public void refresh(String entityName, Object object, LockOptions lockOptions)
/*     */   {
/* 347 */     getSession().refresh(entityName, object, lockOptions);
/*     */   }
/*     */ 
/*     */   public LockMode getCurrentLockMode(Object object)
/*     */   {
/* 352 */     return getSession().getCurrentLockMode(object);
/*     */   }
/*     */ 
/*     */   public Query createFilter(Object collection, String queryString)
/*     */   {
/* 357 */     return getSession().createFilter(collection, queryString);
/*     */   }
/*     */ 
/*     */   public void clear()
/*     */   {
/* 362 */     if (this.session == null) {
/* 363 */       return;
/*     */     }
/* 365 */     getSession().clear();
/*     */   }
/*     */ 
/*     */   public Object get(Class clazz, Serializable id)
/*     */   {
/* 370 */     return getSession().get(clazz, id);
/*     */   }
/*     */ 
/*     */   public Object get(Class clazz, Serializable id, LockMode lockMode)
/*     */   {
/* 375 */     return getSession().get(clazz, id, lockMode);
/*     */   }
/*     */ 
/*     */   public Object get(Class clazz, Serializable id, LockOptions lockOptions)
/*     */   {
/* 380 */     return getSession().get(clazz, id, lockOptions);
/*     */   }
/*     */ 
/*     */   public Object get(String entityName, Serializable id)
/*     */   {
/* 385 */     return getSession().get(entityName, id);
/*     */   }
/*     */ 
/*     */   public Object get(String entityName, Serializable id, LockMode lockMode)
/*     */   {
/* 390 */     return getSession().get(entityName, id, lockMode);
/*     */   }
/*     */ 
/*     */   public Object get(String entityName, Serializable id, LockOptions lockOptions)
/*     */   {
/* 395 */     return getSession().get(entityName, id, lockOptions);
/*     */   }
/*     */ 
/*     */   public String getEntityName(Object object)
/*     */   {
/* 400 */     return getSession().getEntityName(object);
/*     */   }
/*     */ 
/*     */   public IdentifierLoadAccess byId(String entityName)
/*     */   {
/* 405 */     return getSession().byId(entityName);
/*     */   }
/*     */ 
/*     */   public IdentifierLoadAccess byId(Class entityClass)
/*     */   {
/* 410 */     return getSession().byId(entityClass);
/*     */   }
/*     */ 
/*     */   public NaturalIdLoadAccess byNaturalId(String entityName)
/*     */   {
/* 415 */     return getSession().byNaturalId(entityName);
/*     */   }
/*     */ 
/*     */   public NaturalIdLoadAccess byNaturalId(Class entityClass)
/*     */   {
/* 420 */     return getSession().byNaturalId(entityClass);
/*     */   }
/*     */ 
/*     */   public SimpleNaturalIdLoadAccess bySimpleNaturalId(String entityName)
/*     */   {
/* 425 */     return getSession().bySimpleNaturalId(entityName);
/*     */   }
/*     */ 
/*     */   public SimpleNaturalIdLoadAccess bySimpleNaturalId(Class entityClass)
/*     */   {
/* 430 */     return getSession().bySimpleNaturalId(entityClass);
/*     */   }
/*     */ 
/*     */   public Filter enableFilter(String filterName)
/*     */   {
/* 435 */     return getSession().enableFilter(filterName);
/*     */   }
/*     */ 
/*     */   public Filter getEnabledFilter(String filterName)
/*     */   {
/* 440 */     return getSession().getEnabledFilter(filterName);
/*     */   }
/*     */ 
/*     */   public void disableFilter(String filterName)
/*     */   {
/* 445 */     getSession().disableFilter(filterName);
/*     */   }
/*     */ 
/*     */   public SessionStatistics getStatistics()
/*     */   {
/* 450 */     return getSession().getStatistics();
/*     */   }
/*     */ 
/*     */   public boolean isReadOnly(Object entityOrProxy)
/*     */   {
/* 455 */     return getSession().isReadOnly(entityOrProxy);
/*     */   }
/*     */ 
/*     */   public void setReadOnly(Object entityOrProxy, boolean readOnly)
/*     */   {
/* 460 */     getSession().setReadOnly(entityOrProxy, readOnly);
/*     */   }
/*     */ 
/*     */   public void doWork(Work work) throws HibernateException
/*     */   {
/* 465 */     getSession().doWork(work);
/*     */   }
/*     */ 
/*     */   public <T> T doReturningWork(ReturningWork<T> work) throws HibernateException
/*     */   {
/* 470 */     return getSession().doReturningWork(work);
/*     */   }
/*     */ 
/*     */   public Connection disconnect()
/*     */   {
/* 475 */     if (this.session == null) {
/* 476 */       return null;
/*     */     }
/*     */ 
/* 479 */     return this.session.disconnect();
/*     */   }
/*     */ 
/*     */   public void reconnect(Connection connection)
/*     */   {
/* 484 */     if (this.session == null) {
/* 485 */       return;
/*     */     }
/* 487 */     this.session.reconnect(connection);
/*     */   }
/*     */ 
/*     */   public boolean isFetchProfileEnabled(String name) throws UnknownProfileException
/*     */   {
/* 492 */     return getSession().isFetchProfileEnabled(name);
/*     */   }
/*     */ 
/*     */   public void enableFetchProfile(String name) throws UnknownProfileException
/*     */   {
/* 497 */     getSession().enableFetchProfile(name);
/*     */   }
/*     */ 
/*     */   public void disableFetchProfile(String name) throws UnknownProfileException
/*     */   {
/* 502 */     getSession().disableFetchProfile(name);
/*     */   }
/*     */ 
/*     */   public TypeHelper getTypeHelper()
/*     */   {
/* 507 */     return getSession().getTypeHelper();
/*     */   }
/*     */ 
/*     */   public LobHelper getLobHelper()
/*     */   {
/* 512 */     return getSession().getLobHelper();
/*     */   }
/*     */ 
/*     */   public Session getSession() {
/* 516 */     if (this.session == null) {
/* 517 */       this.session = HibernateUtil.getSessionFactory().openSession();
/* 518 */       this.session.beginTransaction();
/* 519 */       this.session.setFlushMode(FlushMode.MANUAL);
/* 520 */       ContextManager.bindSession(this.session);
/* 521 */       logger.error("Session Proxy------session=" + this.session);
/*     */     }
/* 523 */     return this.session;
/*     */   }
/*     */ }

/* Location:           D:\新建文件夹\bard-cms-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.common.SessionProxy
 * JD-Core Version:    0.5.4
 */