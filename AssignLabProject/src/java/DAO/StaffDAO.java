package DAO;

import Pojo.Department;
import Pojo.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:49 AM
 */
public class StaffDAO extends GenericDAO {

    public StaffDAO() {
        super();
    }

    /**
     *
     * @param userObj
     */
    public void Deactivate(User userObj) {
        // begin transaction
        beginTransaction();
        update(userObj);
        getTransaction().commit();
    }

    /**
     *
     * @param userObj
     */
    public void Delete(User userObj) {
        // begin transaction
        beginTransaction();
        delete(userObj);
        getTransaction().commit();
    }

    /**
     *
     * @param userObj
     */
    public void Insert(User userObj) {
        // begin transaction
        beginTransaction();
        persist(userObj);
        getTransaction().commit();
    }

    /**
     *
     * @param Obj
     */
    public List SelectAllActive(Department deptObj) {
        String hql = "FROM User p where p.isActive=0 and p.type=2 and p.department.idDepartment=" + deptObj.getIdDepartment();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public List SelectAllDeactive(Department deptObj) {
        String hql = "FROM User p where p.isActive=1 and p.type=2 and p.department.idDepartment=" + deptObj.getIdDepartment();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public List SelectOne(User userObj) {
        String hql = "FROM User p where p.idUser=" + userObj.getIdUser();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public List SelectbyName(User userObj) {
        Query query = null;
        String hql = null;
        if (userObj.getIdUser() == null) {
            hql = "FROM User p where p.email='" + userObj.getEmail() + "'";
            query = getSession().createQuery(hql);
        } else {
            hql = "FROM User p where p.idUser <> " + userObj.getIdUser() + " and p.email='" + userObj.getEmail() + "'";
            query = getSession().createQuery(hql);
        }
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public void Update(User Obj) {
        // begin transaction
        beginTransaction();
        merge(Obj);
        getTransaction().commit();
    }

    /**
     *
     * @param Obj
     */
    public User SelectOneActive(User Obj) {
        beginTransaction();
        Criteria crTrainee = getSession().createCriteria(User.class).add(Restrictions.eq("name", Obj.getName()));
        List<User> trainees = (List<User>) crTrainee.list();
        for (User u : trainees) {
            if (u.getPass().equals(Obj.getPass())) {
                System.out.println("staff dao " + u.getPass());
                return u;
            }
        }
        return null;

    }

}
