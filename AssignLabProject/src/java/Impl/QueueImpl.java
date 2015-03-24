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
        
        
        Obj.shiftDeliveryQueue(lab, date);
    }

    @Override
    public void insertTraineeInDeliveryQueue(User user, Lab lab) {
           
        Obj.insertTraineeInDeliveryQueue(user, lab);
    }

    @Override
    public List<User> getTraineeInDeliveryQueue(Lab lab) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    return Obj.getTraineeInDeliveryQueue(lab);
    
    
    }
    
    
    
    
    
}
