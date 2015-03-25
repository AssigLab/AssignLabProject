/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author rania
 */
import Pojo.Lab;
import Pojo.Notification;
import Pojo.User;
import Pojo.UserDelivery;
import java.util.Iterator;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class NotificationDAO extends GenericDAO {

    public boolean SendNotification(User user, Notification notify) {

        beginTransaction();

        User user1 = (User) getSession().load(User.class, user.getIdUser());
        if (user1.getOnline() == 1) {
            notify = (Notification) getSession().load(Notification.class, notify.getIdNotification());
            notify.getUsers().add(user);
            notify.setIdNotification(notify.getIdNotification());

            saveOrUpdate(notify);
            getTransaction().commit();
            return true;

        } else {

            return false;
        }
    }

    public Notification getNotification(User user) {

        beginTransaction();

        List<Notification> notify = getSession().createCriteria(Notification.class).createAlias("users", "u").add(Restrictions.eq("u.idUser", user.getIdUser())).list();

        Iterator it = notify.iterator();
        if (notify.size() > 0) {
            Notification notification = notify.get(notify.size() - 1);
            System.out.println("hibernate notify");
            return notification;
        }
        return null;
    }

}
