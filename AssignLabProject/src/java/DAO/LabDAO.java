package DAO;

import Pojo.Course;
import Pojo.Lab;
import java.util.List;
import org.hibernate.Query;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:48 AM
 */
public class LabDAO  extends GenericDAO{

	
    public LabDAO() {
        super();
    }

    /**
     *
     * @param labobj
     */
    public void delete(Lab labobj) {
        // begin transaction
        beginTransaction();
        delete(labobj);
        getTransaction().commit();
    }

    /**
     *
     * @param labobj
     */
    public void insert(Lab labobj) {
        // begin transaction
        beginTransaction();
        insert(labobj);
        getTransaction().commit();
    }

    /**
     *
     * @param courseobj
     */
    public List selectAllLabActive(Course courseobj) {
        String hql = "FROM Lab p where p.description='close' and p.course.idCourse=" + courseobj.getIdCourse();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param courseobj
     */
    public List selectAllLabDeact(Course courseobj) {
        String hql = "FROM Lab p where p.description='close' and p.course.idCourse=" + courseobj.getIdCourse();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param labobj
     */
    public List selectOneLab(Lab labobj) {
        String hql = "FROM Lab p where p.idLab=" + labobj.getIdLab();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     *
     * @param labobj
     */
    public void update(Lab labobj) {
        // begin transaction
        beginTransaction();
        merge(labobj);
        getTransaction().commit();
    }

    public List selectAllLab(Course obj) {

        String hql = "from Course c where c.name = ?";
        Query query1 = getSession().createQuery(hql).setString(0, obj.getName());
        List<Course> result = query1.list();

        String hqlOne = "select l.name FROM Lab l where :given = l.course";
        Query query = getSession().createQuery(hqlOne).setEntity("given", result.get(0));

        return query.list();
    }
      public Lab getLabByName(Lab name) {
        /*
         String hql = "from Course c where c.name = ?";
         Query query1 = getSession().createQuery(hql).setString(0, obj.getName());
         List<Course> result = query1.list();
         */

        String hql = "from Lab l where l.name = ?";
        Query query1 = getSession().createQuery(hql).setString(0, name.getName());
        List<Lab> result = query1.list();
        System.out.println(result.get(0).getName());
        return result.get(0);
    }

    
  
    public void update_staff(Lab obj) {

        String hql = "from Lab l where l.idLab = :given";
        Query query = getSession().createQuery(hql).setInteger("given", obj.getIdLab());
        List<Lab> labs = query.list();

        Lab lab = labs.get(0);

        String hqlupdate = "UPDATE Lab set description = 'close'"
                + "WHERE idLab = :lab_id";

        beginTransaction();
        Query queryUpdate = getSession().createQuery(hqlupdate);
        queryUpdate.setParameter("lab_id", lab.getIdLab());
        int result = queryUpdate.executeUpdate();
        System.out.println("Rows affected: " + result);

        getTransaction().commit();
    }

    public void updateEnabled_staff(Lab obj) {

        String hql = "from Lab l where l.idLab = :given";
        Query query = getSession().createQuery(hql).setInteger("given", obj.getIdLab());
        List<Lab> labs = query.list();

        Lab lab = labs.get(0);

        String hqlupdate = "UPDATE Lab set description = 'close' and enableUpload = 1"
                + "WHERE idLab = :lab_id";

        beginTransaction();
        Query queryUpdate = getSession().createQuery(hqlupdate);
        queryUpdate.setParameter("lab_id", lab.getIdLab());
        int result = queryUpdate.executeUpdate();
        System.out.println("Rows affected: " + result);

        getTransaction().commit();
    }

    public void shiftqueue(Lab current, Lab next) {
//        String hql = "from UserDelivery ud where served = 0 and :given = lab";
//        Query quer = getSession().createQuery(hql).setEntity("given", current);
//        List<UserDelivery> deliverys = quer.list();
//
//        for (Iterator<UserDelivery> iterator = deliverys.iterator(); iterator.hasNext();) {
//            UserDelivery next1 = iterator.next();

        String hqlUpdate = "UPDATE UserDelivery set lab = :lab"
                + "WHERE lab = :current_lab and served = 0";

        beginTransaction();
        Query query = getSession().createQuery(hqlUpdate);
        query.setParameter("lab", next);
        query.setParameter("current_lab", current);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        getTransaction().commit();

//            next1.setLab(next);
//
//            beginTransaction();
//            saveOrUpdate(next1);
//            getTransaction().commit();
    }

}