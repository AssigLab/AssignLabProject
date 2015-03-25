package DAO;

import Pojo.Group;
import Pojo.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

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
        String hql = "FROM Group g where g.isActive=0";
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
        /* String hql = "FROM group where g.idGroup=" + group.getIdGroup();
         Query query = getSession().createQuery(hql);
         return query.list();*/
        Query query = null;
        String hql = null;
        if (group.getIdGroup() == null) {
            System.out.println("group id null");
            hql = "FROM Group g where g.name='" + group.getName() + "'";
            query = getSession().createQuery(hql);
        } else {
            hql = "FROM Group g where g.idGroup <> " + group.getIdGroup() + " and g.name='" + group.getName() + "'";
            query = getSession().createQuery(hql);
        }
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
     * @return
     */
    public List selectUserGroups(User Obj) {

        Obj = (User) getSession().load(User.class, Obj.getIdUser());
        Iterator it = Obj.getGroups().iterator();
        List<Group> groupList = new ArrayList<Group>();
        System.out.println("user of groups :"+groupList.size());
        while (it.hasNext()) {
            Group group = (Group) it.next();
            groupList.add(group);

        }

        return groupList;
    }

    /**
     *
     * @param u
     */
//    public int update(User u) {
//        return 0;
//    }
}
