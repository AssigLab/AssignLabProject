/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.QueueInt;
import Pojo.*;
import beanspkg.UserQueueDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rania
 */
public class QueueDAO extends GenericDAO {

    /*  public void shiftDeliveryQueue(Lab lab, Date date) {
     beginTransaction();
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

     getTransaction().commit();
     }
     */
    public int insertTraineeInDeliveryQueue(User user, Lab lab, String comment) {

        int flag = 0;
        beginTransaction();

        lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
        user = (User) getSession().load(User.class, user.getIdUser());

        if (lab.getDescription().equals("close")) {
            return 1;
        }
        UserDeliveryId userDeliveryId = new UserDeliveryId();
        userDeliveryId.setLabId(lab.getIdLab());
        userDeliveryId.setUserId(user.getIdUser());

        List<UserDelivery> deliveryQueue = getSession()
                .createCriteria(UserDelivery.class)
                .add(Restrictions.eq("lab.idLab", lab.getIdLab())).list();

        Iterator it = deliveryQueue.iterator();

        while (it.hasNext()) {

            System.out.println("in while");
            UserDelivery user1 = (UserDelivery) it.next();

            if ((user.getIdUser()) == (user1.getUser().getIdUser())) {
                System.out.println("in wfirst if");
                flag++;
                if (user1.getServed() == 1) {

                    user1.setServed(0);
                    user1.setComment(comment);
                    update(user1);
                    getTransaction().commit();
                    break;

                } else {
                    System.out.println("in else");
                    return 3;
                }

            }

        }

        if (flag == 0) {
            System.out.println("in second f");
            UserDelivery userDelivery = new UserDelivery();

            userDelivery.setId(userDeliveryId);
            userDelivery.setServed(0);
            userDelivery.setToWhenDate(new Date());
            userDelivery.setComment(comment);
            persist(userDelivery);

            getTransaction().commit();

            //   break ;
            return 2;

        }

        return 2;

    }

    public List<User> getTraineeInDeliveryQueue(Lab lab) {

        beginTransaction();
        int labId = lab.getIdLab();
        List<User> users = new ArrayList();
        List<UserDelivery> deliveryQueue = getSession()
                .createCriteria(UserDelivery.class)
                .add(Restrictions.eq("lab.idLab", labId)).list();

        Iterator it = deliveryQueue.iterator();

        while (it.hasNext()) {
            UserDelivery user1 = (UserDelivery) it.next();

            users.add(user1.getUser());
            System.out.println(user1.getUser().getName());
        }

        getTransaction().commit();

        return users;

    }

    public int cancelRequestIndeliveryQueue(User user, Lab lab) {
        int flag = 0;
        beginTransaction();

        lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
        user = (User) getSession().load(User.class, user.getIdUser());

        if (lab.getDescription().equals("close")) {
            return 1;
        }
        UserDeliveryId userDeliveryId = new UserDeliveryId();
        userDeliveryId.setLabId(lab.getIdLab());
        userDeliveryId.setUserId(user.getIdUser());

        List<UserDelivery> deliveryQueue = getSession()
                .createCriteria(UserDelivery.class)
                .add(Restrictions.eq("lab.idLab", lab.getIdLab())).list();

        Iterator it = deliveryQueue.iterator();

        while (it.hasNext()) {

            System.out.println("in while");
            UserDelivery user1 = (UserDelivery) it.next();

            if ((user.getIdUser()) == (user1.getUser().getIdUser())) {
                System.out.println("in first if");
                flag++;
                if (user1.getServed() == 1) {

                    break;

                } else {
                    System.out.println("in else");

                    user1.setServed(1);
                    update(user1);
                    getTransaction().commit();
                    return 2;
                }

            }

        }

        if (flag == 0) {

            //   break ;
            return 3;

        }

        return 3;

    }
   //////////////////////////////////////////////////////////////////////////////////// 

    public int insertTraineeInAssistantQueue(User user, Lab lab, String comment) {

        int flag = 0;
        beginTransaction();

        lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
        user = (User) getSession().load(User.class, user.getIdUser());

        if (lab.getDescription().equals("close")) {
            return 1;
        }
        UserAssistanceId userAssistanceId = new UserAssistanceId();
        userAssistanceId.setLabId(lab.getIdLab());
        userAssistanceId.setUserId(user.getIdUser());

        List<UserAssistance> assistanceQueue = getSession()
                .createCriteria(UserAssistance.class)
                .add(Restrictions.eq("lab.idLab", lab.getIdLab())).list();

        Iterator it = assistanceQueue.iterator();

        while (it.hasNext()) {

            System.out.println("in while");
            UserAssistance user1 = (UserAssistance) it.next();

            if ((user.getIdUser()) == (user1.getUser().getIdUser())) {
                System.out.println("in wfirst if");
                flag++;
                if (user1.getServerd() == 1) {

                    user1.setServerd(0);
                    user1.setComment(comment);
                    update(user1);
                    getTransaction().commit();
                    break;

                } else {
                    System.out.println("in else");
                    return 3;
                }

            }

        }

        if (flag == 0) {
            System.out.println("in second f");
            UserAssistance userAssistance = new UserAssistance();

            userAssistance.setId(userAssistanceId);
            userAssistance.setServerd(0);

            userAssistance.setComment(comment);
            persist(userAssistance);

            getTransaction().commit();

            //   break ;
            return 2;

        }

        return 2;

    }
    /////////////////////////////////////////////////////////////////////////////////////

    public List<User> getTraineeInAssistanceQueue(Lab lab) {

        beginTransaction();
        int labId = lab.getIdLab();
        List<User> users = new ArrayList();
        List<UserAssistance> assistanceQueue = getSession()
                .createCriteria(UserAssistance.class)
                .add(Restrictions.eq("lab.idLab", labId)).list();

        Iterator it = assistanceQueue.iterator();

        while (it.hasNext()) {
            UserAssistance user1 = (UserAssistance) it.next();

            users.add(user1.getUser());
            System.out.println(user1.getUser().getName());
        }

        getTransaction().commit();

        return users;

    }

    public int cancelRequestInAssistanceQueue(User user, Lab lab) {
        int flag = 0;
        beginTransaction();

        lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
        user = (User) getSession().load(User.class, user.getIdUser());
        if (lab.getDescription().equals("close")) {
            return 1;
        }
        UserAssistanceId userAssistanceId = new UserAssistanceId();
        userAssistanceId.setLabId(lab.getIdLab());
        userAssistanceId.setUserId(user.getIdUser());

        List<UserAssistance> assistanceQueue = getSession()
                .createCriteria(UserAssistance.class)
                .add(Restrictions.eq("lab.idLab", lab.getIdLab())).list();

        Iterator it = assistanceQueue.iterator();

        while (it.hasNext()) {

            System.out.println("in while");
            UserAssistance user1 = (UserAssistance) it.next();

            if ((user.getIdUser()) == (user1.getUser().getIdUser())) {
                System.out.println("in first if");
                flag++;
                if (user1.getServerd() == 1) {

                    break;

                } else {
                    System.out.println("in else");

                    user1.setServerd(1);
                    update(user1);
                    getTransaction().commit();
                    return 2;
                }

            }

        }

        if (flag == 0) {

            //   break ;
            return 3;

        }

        return 3;

    }

    public List<Group> getUserGroups(User user) {

        user = (User) getSession().load(User.class, user.getIdUser());
        Iterator it = user.getGroups().iterator();
        List<Group> groupList = new ArrayList<Group>();

        while (it.hasNext()) {
            Group group = (Group) it.next();
            groupList.add(group);

        }

        return groupList;

    }

    //Nasser

    public List<UserQueueDTO> getTraineeInAssistanceQueue_Staff(Lab lab) {

        beginTransaction();

        String check = "from Lab l where :given = l.idLab";
        Query checkQuery = getSession().createQuery(check).setInteger("given", lab.getIdLab());
        System.out.println(lab.getIdLab());
        List<Lab> result = checkQuery.list();
        String desc = result.get(0).getDescription();
        System.out.println(result);

        List<UserQueueDTO> users = new ArrayList<>();

        if (desc.equals("open")) {
            System.out.println("inside OPEN");

            //get lab id
            String hqlOne = "FROM UserAssistance ua where :given = ua.lab and ua.serverd = 0";
            Query query = getSession().createQuery(hqlOne).setEntity("given", lab);

            List<UserAssistance> list = query.list();

            System.out.println("ASSISTANCE: " + list);

            String userQuery = "from User u where :given = u.idUser";

            for (UserAssistance userAssis : list) {
                Query query1 = getSession().createQuery(userQuery).setInteger("given", userAssis.getUser().getIdUser());

                List<User> us = query1.list();
                System.out.println(us.get(0).getName());
                System.out.println(userAssis.getComment());
                UserQueueDTO queueDTO = new UserQueueDTO();
                queueDTO.setUserName(us.get(0).getName());
                queueDTO.setComment(userAssis.getComment());
                users.add(queueDTO);
            }

        } else if (desc.equals("close")) {
            System.out.println("inside CLOSE");
            UserQueueDTO userError = new UserQueueDTO();
            userError.setUserName("Lab CLosed");
            userError.setComment("Go download files");
            users.add(userError);
        }

        for (UserQueueDTO user : users) {
            System.out.println(user.getUserName() + " : " + user.getComment());
        }
        return users;
    }

    public void updateDeliveryQueue(User id) {
        String hql = "from UserDelivery ud where ud.user = :given";
        Query checkQuery = getSession().createQuery(hql).setInteger("given", id.getIdUser());
        List<UserDelivery> deliverys = checkQuery.list();

        System.out.println("updateDeliveyQueue: " + deliverys.get(0).getServed());

        UserDelivery user = deliverys.get(0);
        user.setServed(1);
        user.setCountServed(user.getCountServed() + 1);

        sendNotification(id, "You have been PICKED from the delivery Queue");

        beginTransaction();
        saveOrUpdate(user);
        getTransaction().commit();
    }

    public void updateDeliveryQueue_dequeue(User id) {
        String hql = "from UserDelivery ud where ud.user = :given";
        Query checkQuery = getSession().createQuery(hql).setInteger("given", id.getIdUser());
        List<UserDelivery> deliverys = checkQuery.list();

        System.out.println("updateDeliveyQueue: " + deliverys.get(0).getServed());

        UserDelivery user = deliverys.get(0);
        user.setServed(1);

        sendNotification(id, "You have been DEQUEUED from the delivery Queue");

        beginTransaction();
        saveOrUpdate(user);
        getTransaction().commit();
    }

    public void updateAssisQueue(User id) {
        String hql = "from UserAssistance ud where ud.user = :given";
        Query checkQuery = getSession().createQuery(hql).setInteger("given", id.getIdUser());
        List<UserAssistance> deliverys = checkQuery.list();

        System.out.println("updateDeliveyQueue: " + deliverys.get(0).getServerd());

        UserAssistance user = deliverys.get(0);
        user.setServerd(1);
        user.setCountServed(user.getCountServed() + 1);

        sendNotification(id, "You have been PICKED from the Assistance Queue");

        beginTransaction();
        saveOrUpdate(user);
        getTransaction().commit();
    }

    public void updateAssisQueue_dequeue(User id) {
        String hql = "from UserAssistance ud where ud.user = :given";
        Query checkQuery = getSession().createQuery(hql).setInteger("given", id.getIdUser());
        List<UserAssistance> deliverys = checkQuery.list();

        System.out.println("updateDeliveyQueue: " + deliverys.get(0).getServerd());

        UserAssistance user = deliverys.get(0);
        user.setServerd(1);

        //create and send Notification
        sendNotification(id, "You have been DEQUEUED from the Assistance Queue");

        beginTransaction();
        saveOrUpdate(user);
        getTransaction().commit();
    }

    private void sendNotification(User id, String message) {
        Notification notification = new Notification(message);

        String hql = "from Notification n where n.message = :given";

        Query query = getSession().createQuery(hql).setString("given", notification.getMessage());

        List<Notification> notifications = query.list();

        NotificationDAO notificationDAO = new NotificationDAO();
        notificationDAO.SendNotification(id, notifications.get(0));
    }

}
