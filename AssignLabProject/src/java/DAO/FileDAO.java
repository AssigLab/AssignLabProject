/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Lab;
import Pojo.UploadFile;
import Pojo.UploadFileId;
import Pojo.User;
import Pojo.UserDelivery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rania
 */
public class FileDAO  extends GenericDAO{
    
    
    public boolean uploadfile (InputStream  inputStream,User user,Lab lab)
    {
        beginTransaction();
        
     
            lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
            user = (User) getSession().load(User.class, user.getIdUser());
           
             List<UploadFile> uploadFileList = getSession()
                .createCriteria(UploadFile.class)
                .add(Restrictions.eq("id.labId", lab.getIdLab())).list();
             

        Iterator it = uploadFileList.iterator();

        while (it.hasNext()) 
            
            {
                UploadFile upload = (UploadFile) it.next();
                if(upload.getId().getUserId()==user.getIdUser())
                {
                   return false;
                }
                
            }
        
            try {
                UploadFile upload=new UploadFile();
                UploadFileId uploadId=new UploadFileId();
                uploadId.setLabId(lab.getIdLab());
                uploadId.setUserId(user.getIdUser());
                byte[] bufferData = new byte[1024];
                int read=0;
                
                
                while((read = inputStream.read(bufferData))!= -1){
                    //   os.write(bufferData, 0, read);
                }
                // os.flush();
                // os.close();
                inputStream.close();
                System.out.println("File downloaded at client successfully");
                upload.setId(uploadId);
                upload.setFile(bufferData);
                save(upload);
                
                
                getTransaction().commit();
            } catch (IOException ex) {
                Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
         
        
 

    
     return true;
        
    }
    
  /*  public void uplaodFile(File file ,User user,Lab lab)
            
    {
        
        System.out.println("in file Dao");
        lab = (Lab) getSession().load(Lab.class, lab.getIdLab());
        user = (User) getSession().load(User.class, user.getIdUser());
        UploadFile upload=new UploadFile();
        UploadFileId uploadId=new UploadFileId();
        uploadId.setLabId(lab.getIdLab());
        uploadId.setUserId(user.getIdUser());
         byte[] bFile = new byte[(int) file.length()];
 
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        upload.setId(uploadId);
 upload.setFile(bFile);
 save(upload);
         
       
   getTransaction().commit();     
 

    
    
        
      //  session.beginTransaction();
//session.persist(account);
//session.getTransaction().commit();
        
        
        
        
        
        
        
    }*/
}
