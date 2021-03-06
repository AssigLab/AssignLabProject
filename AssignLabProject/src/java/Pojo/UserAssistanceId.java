package Pojo;
// Generated Mar 23, 2015 5:14:14 PM by Hibernate Tools 3.6.0



/**
 * UserAssistanceId generated by hbm2java
 */
public class UserAssistanceId  implements java.io.Serializable {


     private int userId;
     private int labId;

    public UserAssistanceId() {
    }

    public UserAssistanceId(int userId, int labId) {
       this.userId = userId;
       this.labId = labId;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getLabId() {
        return this.labId;
    }
    
    public void setLabId(int labId) {
        this.labId = labId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserAssistanceId) ) return false;
		 UserAssistanceId castOther = ( UserAssistanceId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && (this.getLabId()==castOther.getLabId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + this.getLabId();
         return result;
   }   


}


