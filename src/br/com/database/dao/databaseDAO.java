package br.com.database.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.database.model.Usuarios;

public class databaseDAO implements databaseDAOInterface<Usuarios, String>{
	 private Session currentSession;
     
	    private Transaction currentTransaction;
	 
	    public databaseDAO() {}
	 
	    public Session openCurrentSession() {
	        currentSession = getSessionFactory().openSession();
	        return currentSession;
	    }
	 
	    public Session openCurrentSessionwithTransaction() {
	        currentSession = getSessionFactory().openSession();
	        currentTransaction = currentSession.beginTransaction();
	        return currentSession;
	    }
	     
	    public void closeCurrentSession() {
	        currentSession.close();
	    }
	     
	    public void closeCurrentSessionwithTransaction() {
	        currentTransaction.commit();
	        currentSession.close();
	    }
	     
	    private static SessionFactory getSessionFactory() {
	        Configuration configuration = new Configuration().configure();
	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
	        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
	        return sessionFactory;
	    }
	 
	    public Session getCurrentSession() {
	        return currentSession;
	    }
	 
	    public void setCurrentSession(Session currentSession) {
	        this.currentSession = currentSession;
	    }
	 
	    public Transaction getCurrentTransaction() {
	        return currentTransaction;
	    }
	 
	    public void setCurrentTransaction(Transaction currentTransaction) {
	        this.currentTransaction = currentTransaction;
	    }
	 
	    public void persist(Usuarios entity) {
	        getCurrentSession().save(entity);
	    }
	 
	    public void update(Usuarios entity) {
	        getCurrentSession().update(entity);
	    }
	 
	    public Usuarios findById(String id) {
	    	Usuarios book = (Usuarios) getCurrentSession().get(Usuarios.class, id);
	        return book; 
	    }
	 
	    public void delete(Usuarios entity) {
	        getCurrentSession().delete(entity);
	    }
	 
	    @SuppressWarnings("unchecked")
	    public List<Usuarios> findAll() {
	        List<Usuarios> books = (List<Usuarios>) getCurrentSession().createQuery("from Book").list();
	        return books;
	    }
	 
	    public void deleteAll() {
	        List<Usuarios> entityList = findAll();
	        for (Usuarios entity : entityList) {
	            delete(entity);
	        }
	    }
}
