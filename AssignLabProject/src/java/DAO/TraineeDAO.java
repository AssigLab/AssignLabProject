package DAO;

import Pojo.Department;
import Pojo.Group;
import Pojo.Lab;
import Pojo.User;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:49 AM
 */
public class TraineeDAO extends GenericDAO {

    public TraineeDAO() {
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
        String hql = "FROM User p where p.isActive=0 and p.type=1 and p.department.idDepartment=" + deptObj.getIdDepartment();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param Obj
     */
    public List SelectAllDeactive(Department deptObj) {
        String hql = "FROM User p where p.isActive=1 and p.type=1 and p.department.idDepartment=" + deptObj.getIdDepartment();
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
                System.out.println("trainee dao " + u.getPass());
                //update to online
                u.setOnline(1);
                update(u);
                getTransaction().commit();
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @param Obj
     */
    public List SelectOneDeactive(User Obj) {
        return null;
    }

    /**
     *
     * @param Obj
     */
    public Lab getAlllInitDataForTrinee(User us, HttpSession session) {
        //put all trainee needed data as attribute on session 
        //get cutrrent queue 
        Lab activeLab = new Lab();
        beginTransaction();
        Criteria crBid = getSession().createCriteria(Group.class).createAlias("users", "u")
                .add(Restrictions.eq("u.idUser", us.getIdUser()));
        List pairs = crBid.list();
        System.out.println("category  " + pairs.size());
        for (Object p : pairs) {
            System.out.println("  " + ((Group) p).getName());
            Group gr = (Group) p;
            Criteria crLabs = getSession().createCriteria(Lab.class, "l")
                    .createAlias("course", "c")
                    .createAlias("c.groups", "g")
                    .add(Restrictions.eq("c.isActive", 1))
                    .add(Restrictions.eq("l.description", "open"))
                    .add(Restrictions.eq("g.idGroup", gr.getIdGroup()));
            List labs = crLabs.list();
            System.out.println("labs size" + labs.size());
            for (Object l : labs) {
                Lab lab = ((Lab) l);
                System.out.println("lab dao " + lab.getName());
                if (lab != null) {
                    // close();
                    getTransaction().commit();
                    return lab;
                     //session.setAttribute("lab", lab);

                }
            }
        }
        getTransaction().commit();
        //close();
        return null;
//           Criteria crLabs =getSession().createCriteria(Lab.class,"l")
//                   .createAlias("course","c")
//                   .createAlias("c.groups","g")
//                   .add(Restrictions.eq("c.isActive",1))
//                   .add(Restrictions.eq("l.description","open"))
//                   .createAlias("users","u")
//                   .add(Restrictions.eq("u.idUser",u.getIdUser()))
//                   ;

    }

    public User getUserByName(User user) {
        String hql = "from User u where :given = u.name";

        Query query = getSession().createQuery(hql).setString("given", user.getName());
        List<User> list = query.list();
        System.out.println(list.get(0).getIdUser());
        return list.get(0);
    
    }
}
