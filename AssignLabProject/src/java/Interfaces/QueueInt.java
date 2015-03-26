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

    public boolean insertTraineeInDeliveryQueue(User user, Lab lab, String comment);

    public List<User> getTraineeInDeliveryQueue(Lab lab);

    public boolean cancelRequestIndeliveryQueue(User user, Lab lab);

    public boolean cancelRequestInAssistanceQueue(User user, Lab lab);

    public boolean insertTraineeInAssistantQueue(User user, Lab lab, String comment);

    public List<User> getTraineeInAssistanceQueue(Lab lab);
    
}
