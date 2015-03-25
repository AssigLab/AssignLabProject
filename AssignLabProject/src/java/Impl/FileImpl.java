/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import DAO.FileDAO;
import DAO.QueueDAO;
import Interfaces.FileInt;
import Pojo.Lab;
import Pojo.User;
import java.io.File;
import java.io.InputStream;

/**
 *
 * @author rania
 */
public class FileImpl  implements FileInt{

    
      
     private static FileDAO Obj;
    static {
        Obj = new FileDAO();
    }
    
   

    @Override
    public boolean uplaodFile(InputStream inputStream, User user, Lab lab) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        return Obj.uploadfile(inputStream, user, lab);
        
    
    }
    
}
