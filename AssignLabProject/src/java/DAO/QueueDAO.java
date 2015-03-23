/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.QueueInt;
import Pojo.Course;
import Pojo.Department;
import Pojo.Lab;
import Pojo.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rania
 */
public class QueueDAO extends GenericDAO {

    public void shiftDeliveryQueue(Lab lab, Date date) {
      /*  beginTransaction();
        int labId = lab.getIdLab();

        List<UsersDelivery> deliveryQueue = getSession()
                .createCriteria(UsersDelivery.class)
                .add(Restrictions.eq("lab.idLab", labId)).list();
        Iterator it = deliveryQueue.iterator();

        while (it.hasNext()) {
            UsersDelivery user1 = (UsersDelivery) it.next();

            user1.setToWhenDate(date);
            update(user1);
        }

        getTransaction().commit();*/
    }

    public void insertTraineeInDeliveryQueue(User user, Lab lab) {
        beginTransaction();

//        lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
//        user = (User) getSession().load(User.class, user.getIdUser());
//        UsersDeliveryId userDeliveryId = new UsersDeliveryId();
//        userDeliveryId.setLabId(lab.getIdLab());
//        userDeliveryId.setUserId(user.getIdUser());
//        UsersDelivery usersDelivery = new UsersDelivery();
//        usersDelivery.setId(userDeliveryId);
//        usersDelivery.setLab(lab);
//        usersDelivery.setUser(user);
//        user.getUsersDeliveries().add(usersDelivery);
//        saveOrUpdate(user);
//
//        persist(usersDelivery);
//
//        getTransaction().commit();

    }

    /* public void insert() {
     beginTransaction();

     //   openSession();
     Department dept = new Department();

     dept.setName("GIS");
     dept.setDescription("java");
     dept.setIsActive(1);

     save(dept);
     User user = new User();

     user.setEmail("ahmed");
     user.setIsActive(1);
     user.setName("ahmed");
     user.setPass("123456");
     user.setDepartment(dept);
     save(user);
     Course course = new Course();
     course.setIsActive(1);
     course.setDepartment(dept);
     course.setDescription("java");
     course.setName("java");
     save(course);
     Lab lab = new Lab();
     lab.setName("lab1");
     lab.setDescription("java lab");
     lab.setEndDate(new Date());
     lab.setStartDate(new Date());
     lab.setCourse(course);
     save(lab);

     getTransaction().commit();    //commit();
     }*/
    public List<User> getTraineeInDeliveryQueue(Lab lab) {

         List<User> users=new ArrayList();
       /* beginTransaction();
        int labId = lab.getIdLab();
       
        List<UsersDelivery> deliveryQueue = getSession()
                .createCriteria(UsersDelivery.class)
                .add(Restrictions.eq("lab.idLab", labId)).list();

        Iterator it = deliveryQueue.iterator();

        while (it.hasNext()) {
            UsersDelivery user1 = (UsersDelivery) it.next();

          
//            users.add(user1.getUser());
//            System.out.println(user1.getUser().getName());
        
        }

        getTransaction().commit();*/
        
       return users ;
        
    }
    
     
    

}
