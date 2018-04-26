/**
 * 
 */
package com.dipta.project.dao.base.orm;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQueryCreator;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.service.ServiceRegistry;

import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;

/**
 * Implementing class of {@link PersistenceManager}. This class interacts with the database using hibernate. This is the singleton class so that only
 * single object would be created for the application.
 */
public class HibernatePersistenceManager implements PersistenceManager {

	//	public static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	public static SessionFactory sessionFactory;
	private  AuditReader auditReader ;
	private Session session = null;
	private String tenantIdentifier;

	public HibernatePersistenceManager() {
		this.tenantIdentifier = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "SUPERTENANTSCHEMA","ondemand_1");;
		init();
	}
	
	HibernatePersistenceManager(String tenantId) {
		this.tenantIdentifier = tenantId;
		init();
	}

	private final static int batchSize = 50;
	@Override
	public void batchSave(Object object, int count, int size) {
		Session currentSession = currentSession();
		currentSession.save(object);
		if (size < batchSize && count == size) {
			flushAndClear(currentSession);
		} else if (count % batchSize == 0) {
			flushAndClear(currentSession);
		} else if (size > batchSize && count == size) {
			flushAndClear(currentSession);
		}
	}


	/**
	 * Start a transaction.
	 */
	public void beginTransaction() {
		//		this.tenantIdentifier = tenantIdentifier;
		currentSession().beginTransaction();
	}

	/**
	 * Commit the current transaction.
	 */
	public void commit() {
		// In case of batch update the explicitly flush required.
		// Session currentSession = currentSession();
		// currentSession.flush();
		final Transaction currentTransaction = getCurrentTransaction();
		if (currentTransaction != null && currentTransaction.isActive()) { // must check whether tx is active or not before taking an action
			currentTransaction.commit();
			closeSession();
		} else {
			throw new RuntimeException("Commit outside a transaction");
		}
	}
	@Override
	public AuditQueryCreator createAuditQuery() {
		return currentReader().createQuery();
	}
	
	
	@Override
	public Criteria createCriteria(Class clazz) {
		return currentSession().createCriteria(clazz);
	}

	@Override
	public Criteria createCriteria(Class clazz, String arg) {
		return currentSession().createCriteria(clazz, arg);
	}

	@Override
	public Query createQuery(String query) {
		return currentSession().createQuery(query);
	}


	@Override
	public SQLQuery createSQLQuery(String query) {
		return currentSession().createSQLQuery(query);
	}

	private Session currentSession() throws HibernateException {
		if (session == null || !session.isOpen()) {
			session = (sessionFactory != null) ? sessionFactory.withOptions().tenantIdentifier(tenantIdentifier).openSession() : null;
		}
		return session;
	}
		private AuditReader currentReader() {
		if(auditReader==null ){
		auditReader= AuditReaderFactory.get(currentSession());
		}
		return auditReader;
	}

	public void closeSession() throws HibernateException {
		/*Session session = (Session) threadLocal.get();
	    threadLocal.set(null);*/

		if (session != null) {
			session.close();
			session=null;
		}
	}


	/* (non-Javadoc)
	 * @see com.lei.dao.base.PersistenceManager#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object object) {
		final Session currentSession = currentSession();
		currentSession.delete(object);
		currentSession.flush();
	}

	@Override
	public void evict(Object object) {
		Session currentSession = currentSession();
		currentSession.evict(object);
	}

	/**
	 * Explicit
	 * @param currentSession
	 */
	private void flushAndClear(Session currentSession) {
		currentSession.flush();
		currentSession.clear();
	}


	/* (non-Javadoc)
	 * @see com.lei.dao.base.PersistenceManager#get(java.lang.Class, java.lang.Long)
	 */
	@Override
	public List<Object> get(Class clazz, Long id) {
		List<Object> list = new ArrayList<Object>();
		Object object = currentSession().get(clazz, id);
		list.add(object);
		return list;
		// TODO Validate the return type for this.
	}



	/* (non-Javadoc)
	 * @see com.lei.dao.base.PersistenceManager#get(java.lang.Class, java.lang.Long)
	 */
	public <T> T load(Class<T> type, Serializable id) {
		//List<Object> list = new ArrayList<Object>();
		Object object = currentSession().load(type, id);
		//list.add(object);
		return type.cast(object);
		// TODO Validate the return type for this.
	}



	@Override
	public <T> T getPersistentObject(Class<T> type, Long id) {

		return type.cast(currentSession().get(type, id));
		// TODO Validate the return type for this.
	}

	@Override
	public <T> T getPersistentObject(Class<T> type, String id){
		return type.cast(currentSession().get(type, id));
	}


	/**
	 * @return The transaction associated with current session, else <code>null</code>.
	 */
	private Transaction getCurrentTransaction() {
		return currentSession().getTransaction();
	}

	/* (non-Javadoc)
	 * @see com.lei.dao.base.PersistenceManager#init()
	 */
	@Override
	public void init() {
		try {
			if (sessionFactory == null) {
				// Create the SessionFactory from hibernate.cfg.xml
				/*	Configuration config = new Configuration().configure();
				// config.setInterceptor(new EntityNameResolverInterceptor());
				sessionFactory = config.buildSessionFactory();*/



				Configuration configuration = new Configuration().configure();
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
				sessionFactory =  configuration.buildSessionFactory(serviceRegistry);


			}
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			ex.printStackTrace();
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Rollbacks the current transaction.
	 */
	public void rollback() {
		final Transaction currentTransaction = getCurrentTransaction();
		if (currentTransaction != null && currentTransaction.isActive()) { // must check whether tx is active or not before taking an action
			currentTransaction.rollback();
		} else {
			throw new RuntimeException("Rollback outside a transaction");
		}
	}

	/* (non-Javadoc)
	 * @see com.lei.dao.base.PersistenceManager#save(java.lang.Object)
	 */
	@Override
	public Object save(Object object) {
		Session currentSession = currentSession();
		currentSession.save(object);
		currentSession.flush();
		currentSession.clear();
		return object;
	}


	/* (non-Javadoc)
	 * @see com.lei.dao.base.PersistenceManager#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public Object saveOrUpdate(Object object) {
		Session currentSession = currentSession();
		currentSession.saveOrUpdate(object);
		currentSession.flush();
		currentSession.clear();
		return object;
	}

	public <T>T getFromSession(Class<T> returnType,int id) {
		return (T) currentSession().get(returnType, id);
	}

	public Criteria getExecutableCriteria(DetachedCriteria dc){
		return dc.getExecutableCriteria(currentSession());
	}

	public ProcedureCall getProcedureCall(String statementQuery,Class<?>... argsType) throws HibernateException, SQLException{
		//		currentSession().connection().prepareStatement(statementQuery);
		return currentSession().createStoredProcedureCall(ApplicationConstants.SUPERUSERSCHEMA.getValue()+"."+statementQuery,argsType)/*().prepareStatement(statementQuery)*/; 
	}
	
	public ProcedureCall getTenantProcedureCall(String statementQuery,Class<?>... argsType) throws HibernateException, SQLException{
		//		currentSession().connection().prepareStatement(statementQuery);
		return currentSession().createStoredProcedureCall(statementQuery,argsType)/*().prepareStatement(statementQuery)*/; 
	}
	
	
	public Integer executeSQL(String sqlStatementQuery) throws HibernateException, SQLException{
		//		currentSession().connection().prepareStatement(statementQuery);
		return currentSession().createSQLQuery(sqlStatementQuery).executeUpdate()/*().prepareStatement(statementQuery)*/; 
	}

	public void refresh(Object objectToRefresh){
		currentSession().refresh(objectToRefresh);
	}
	
	public <T>AbstractEntityPersister getAbstractEntityPersister(Class<T> type){
		AbstractEntityPersister aep = (AbstractEntityPersister) sessionFactory.getClassMetadata(type);
		return aep;
	}
}
