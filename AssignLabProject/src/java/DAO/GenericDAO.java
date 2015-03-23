package DAO;

/**
 *
 */
import DAO.HibernateUtil;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author rania
 *
 */
public class GenericDAO {

    private Session session;

    public GenericDAO() {
        session = new HibernateUtil().getSessionFactory().openSession();
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void close() {
        getSession().close();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public void evict(Object e) {
        getSession().evict(e);
    }

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return getSession().getTransaction();
    }

    public void rollBack() {
        getSession().getTransaction().rollback();
    }

    public Serializable save(Object obj) {
        return getSession().save(obj);
    }

    public void saveOrUpdate(Object obj) {
        getSession().saveOrUpdate(obj);
    }

    /* (non-Javadoc)
     * @see com.ibm.event.daos.interfaces.IGenericDAO#update(java.lang.Object)
     */
    public void update(Object obj) {
        getSession().update(obj);
    }

    public void merge(Object obj) {
        getSession().merge(obj);

    }

    public void delete(Object obj) {
        getSession().delete(obj);

    }

    public void persist(Object obj) {
        getSession().persist(obj);

    }

}
