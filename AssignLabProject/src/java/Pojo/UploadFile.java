package Pojo;
// Generated Mar 23, 2015 5:14:14 PM by Hibernate Tools 3.6.0



/**
 * UploadFile generated by hbm2java
 */
public class UploadFile  implements java.io.Serializable {


     private UploadFileId id;
     private byte[] file;

    public UploadFile() {
    }

    public UploadFile(UploadFileId id, byte[] file) {
       this.id = id;
       this.file = file;
    }
   
    public UploadFileId getId() {
        return this.id;
    }
    
    public void setId(UploadFileId id) {
        this.id = id;
    }
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }




}


