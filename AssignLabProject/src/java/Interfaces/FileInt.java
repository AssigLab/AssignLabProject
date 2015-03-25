/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Pojo.Lab;
import Pojo.User;
import java.io.File;
import java.io.InputStream;

/**
 *
 * @author rania
 */
public interface FileInt {
    
    
    
      public boolean uplaodFile(InputStream  inputStream ,User user,Lab lab);
}
