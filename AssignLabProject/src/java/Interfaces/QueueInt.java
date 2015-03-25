/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Pojo.Group;
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

    public int insertTraineeInDeliveryQueue(User user, Lab lab, String comment);

    public List<User> getTraineeInDeliveryQueue(Lab lab);

    public int cancelRequestIndeliveryQueue(User user, Lab lab);

    public int cancelRequestInAssistanceQueue(User user, Lab lab);

    public int insertTraineeInAssistantQueue(User user, Lab lab, String comment);

    public List<User> getTraineeInAssistanceQueue(Lab lab);

    public List<Group> getUserGroups(User user);

    
    public void updateDeliveryQueue(User id);

    public void updateDeliveryQueue_dequeue(User id);

    public void updateAssisQueue(User id);

    public void updateAssisQueue_dequeue(User id);

}
