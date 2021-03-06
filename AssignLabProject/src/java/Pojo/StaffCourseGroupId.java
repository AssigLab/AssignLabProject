package Pojo;
// Generated Mar 23, 2015 5:14:14 PM by Hibernate Tools 3.6.0



/**
 * StaffCourseGroupId generated by hbm2java
 */
public class StaffCourseGroupId  implements java.io.Serializable {


     private int userId;
     private int courseId;
     private int groupId;

    public StaffCourseGroupId() {
    }

    public StaffCourseGroupId(int userId, int courseId, int groupId) {
       this.userId = userId;
       this.courseId = courseId;
       this.groupId = groupId;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StaffCourseGroupId) ) return false;
		 StaffCourseGroupId castOther = ( StaffCourseGroupId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && (this.getCourseId()==castOther.getCourseId())
 && (this.getGroupId()==castOther.getGroupId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + this.getCourseId();
         result = 37 * result + this.getGroupId();
         return result;
   }   


}


