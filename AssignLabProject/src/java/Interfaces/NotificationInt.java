/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Pojo.Notification;
import Pojo.User;

/**
 *
 * @author rania
 */
public interface NotificationInt {
    
      public Notification getNotification(User user);
        public boolean SendNotification(User user, Notification notify);
    
    
}
