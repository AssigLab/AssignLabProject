/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import DAO.QueueDAO;
import Interfaces.QueueInt;
import Pojo.Group;
import Pojo.Lab;
import Pojo.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rania
 */
public class QueueImpl implements QueueInt{

    
     private static QueueDAO obj;
    static {
        obj = new QueueDAO();
    }
    
    @Override
    public void shiftDeliveryQueue(Lab lab, Date date) {
        
        
       // Obj.shiftDeliveryQueue(lab, date);
    }

    @Override
    public int insertTraineeInDeliveryQueue(User user, Lab lab,String comment) {
           
        return obj.insertTraineeInDeliveryQueue(user, lab,comment);
    }

    @Override
    public List<User> getTraineeInDeliveryQueue(Lab lab) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return obj.getTraineeInDeliveryQueue(lab);
    
    
    }

    @Override
    public int cancelRequestIndeliveryQueue(User user, Lab lab) {
       return obj.cancelRequestIndeliveryQueue(user, lab);
    }

    @Override
    public int insertTraineeInAssistantQueue(User user, Lab lab,String comment) {
            
        
        return obj.insertTraineeInAssistantQueue(user, lab,comment);
    }

    @Override
    public List<User> getTraineeInAssistanceQueue(Lab lab) {
        
        
        return obj.getTraineeInAssistanceQueue(lab);
    }

    @Override
    public int cancelRequestInAssistanceQueue(User user, Lab lab) {
       
        return obj.cancelRequestInAssistanceQueue(user, lab);
    }

    @Override
    public List<Group> getUserGroups(User user) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return obj.getUserGroups(user);
    }

        @Override
    public void updateDeliveryQueue(User id) {
        obj.updateDeliveryQueue(id);

    }

    @Override
    public void updateDeliveryQueue_dequeue(User id) {
        obj.updateDeliveryQueue_dequeue(id);

    }

    @Override
    public void updateAssisQueue(User id) {
        obj.updateAssisQueue(id);

    }

    @Override
    public void updateAssisQueue_dequeue(User id) {
        obj.updateAssisQueue_dequeue(id);

    }

    
    
    
    
    
    
    
    
}
