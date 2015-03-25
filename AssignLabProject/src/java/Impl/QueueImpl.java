/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import DAO.QueueDAO;
import Interfaces.QueueInt;
import Pojo.Lab;
import Pojo.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rania
 */
public class QueueImpl implements QueueInt{

    
     private static QueueDAO Obj;
    static {
        Obj = new QueueDAO();
    }
    
    @Override
    public void shiftDeliveryQueue(Lab lab, Date date) {
        
        
       // Obj.shiftDeliveryQueue(lab, date);
    }

    @Override
    public boolean insertTraineeInDeliveryQueue(User user, Lab lab,String comment) {
           
        return Obj.insertTraineeInDeliveryQueue(user, lab,comment);
    }

    @Override
    public List<User> getTraineeInDeliveryQueue(Lab lab) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return Obj.getTraineeInDeliveryQueue(lab);
    
    
    }

    @Override
    public boolean cancelRequestIndeliveryQueue(User user, Lab lab) {
       return Obj.cancelRequestIndeliveryQueue(user, lab);
    }

    @Override
    public boolean insertTraineeInAssistantQueue(User user, Lab lab,String comment) {
            
        
        return Obj.insertTraineeInAssistantQueue(user, lab,comment);
    }

    @Override
    public List<User> getTraineeInAssistanceQueue(Lab lab) {
        
        
        return Obj.getTraineeInAssistanceQueue(lab);
    }

    @Override
    public boolean cancelRequestInAssistanceQueue(User user, Lab lab) {
       
        return Obj.cancelRequestInAssistanceQueue(user, lab);
    }
    
    
    
    
    
    
    
    
}
