/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Pojo.Lab;
import Pojo.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rania
 */
public interface QueueInt {
     
             public void shiftDeliveryQueue(Lab lab, Date date);
        
           public void insertTraineeInDeliveryQueue(User user, Lab lab);
             public List<User>  getTraineeInDeliveryQueue(Lab lab);
}
