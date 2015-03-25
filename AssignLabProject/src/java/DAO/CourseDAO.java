package DAO;

import Pojo.Course;
import Pojo.Department;
import Pojo.Group;
import java.util.List;
import org.hibernate.Query;

/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:45 AM
 */
public class CourseDAO extends GenericDAO {

    public CourseDAO() {
        super();
    }

    /**
     *
     * @param courseObj
     */
    public void Delete(Course courseObj) {
        // begin transaction
        beginTransaction();
        delete(courseObj);
        getTransaction().commit();
    }

    /**
     *
     * @param courseObj
     */
    public void insert(Course courseObj) {
        // begin transaction
        System.out.println("JIIIII");
        beginTransaction();
        persist(courseObj);
        getTransaction().commit();
        System.out.println("J22222");
    }

    /**
     *
     * @param deptObj
     */
    public List selectAllActiveCourse(Department deptObj) {
        String hql = "FROM Course p where p.isActive=0 and p.department.idDepartment=" + deptObj.getIdDepartment();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    public List<Course> selectAllActiveCourse(Group groupObj) {
//        GenericDAO gdao = new CourseDAO();

        String hql = "from Group g where g.name= ?";

        Query query1 = getSession().createQuery(hql).setString(0, groupObj.getName());

        List<Group> result = query1.list();

//        System.out.println(result.get(0).getName());
        String hqlOne = "select c.name FROM Course c where :given in elements (c.groups)";

        Query query = getSession().createQuery(hqlOne).setInteger("given", result.get(0).getIdGroup());

        return query.list();
    }
    /**
     *
     * @param d
     */
    public List selectAllDeactiveCourse(Department deptObj) {
        String hql = "FROM Course p where p.isActive=1 and p.department.idDepartment=" + deptObj.getIdDepartment();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param courseObj
     */
    public List selectOneCourse(Course courseObj) {
        String hql = "FROM Course p where p.idCourse=" + courseObj.getIdCourse();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param courseObj
     */
    public void Update(Course courseObj) {
        // begin transaction
        beginTransaction();
        merge(courseObj);
        getTransaction().commit();
    }

    /**
     *
     * @param courseObj
     */
    public List SelectOneByName(Course courseObj) {
        Query query = null;
        String hql = null;
        if (courseObj.getIdCourse() == null) {
            hql = "FROM Course p where p.name='" + courseObj.getName() + "'";
            query = getSession().createQuery(hql);
        } else {
            hql = "FROM Course p where p.idCourse <> " + courseObj.getIdCourse() + " and p.name='" + courseObj.getName() + "'";
            query = getSession().createQuery(hql);
        }
        return query.list();
    }
}
