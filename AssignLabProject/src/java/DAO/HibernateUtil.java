package DAO;

/**
 * 
 */


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author rania
 * 
 */
public class HibernateUtil {

	private SessionFactory sessionFactory;

	public HibernateUtil() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	

}
