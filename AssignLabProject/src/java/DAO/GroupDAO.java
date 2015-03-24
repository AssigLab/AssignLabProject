package DAO;

import Pojo.Group;
import Pojo.User;
import java.util.List;
import org.hibernate.Query;

/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public class GroupDAO extends GenericDAO {

    public GroupDAO() {

    }

    public void finalize() throws Throwable {

    }

    /**
     *
     * @param u
     */
    public int update(Group group) {
        // begin transaction
        beginTransaction();
        merge(group);
        getTransaction().commit();
        return 1;
    }

    /**
     *
     * @param u
     */
    public int delete(Group group) {
        // begin transaction
        beginTransaction();
        delete(group);
        getTransaction().commit();
        return 1;
    }

    /**
     *
     * @param u
     */
    public int insert(Group group) {
        // begin transaction
        beginTransaction();
        persist(group);
        getTransaction().commit();
        return 0;
    }

    public List selectAllActiveGroup() {
        String hql = "FROM group g where g.isActive=0";
        Query query = getSession().createQuery(hql);
        return query.list();

    }

    public List selectAllDeactiveGroup() {
        String hql = "FROM group g where g.isActive=1";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public List selectOneGroup(Group group) {
        String hql = "FROM group where g.idDepartment=" + group.getIdGroup();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public List selectOneDeactiveGroup(Group Obj) {
        return null;
    }

    /**
     *
     * @param Obj
     */
    public List selectUserGroups(User Obj) {
        return null;
    }

    /**
     *
     * @param u
     */
//    public int update(User u) {
//        return 0;
//    }

}
