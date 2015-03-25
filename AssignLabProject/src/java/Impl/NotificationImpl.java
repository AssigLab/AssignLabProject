/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import DAO.NotificationDAO;
import DAO.QueueDAO;
import Interfaces.NotificationInt;
import Pojo.Notification;
import Pojo.User;

/**
 *
 * @author rania
 */
public class NotificationImpl  implements  NotificationInt{

        private static NotificationDAO Obj;
    static {
        Obj = new NotificationDAO();
    }
    
    @Override
    public Notification getNotification(User user) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Obj.getNotification(user);
    
    }

    @Override
    public boolean SendNotification(User user, Notification notify) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
           return Obj.SendNotification(user, notify);
    }
    
    
    
    
}
