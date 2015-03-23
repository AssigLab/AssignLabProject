package Pojo;
// Generated Mar 23, 2015 5:14:14 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * UserDelivery generated by hbm2java
 */
public class UserDelivery  implements java.io.Serializable {


     private UserDeliveryId id;
     private User user;
     private Lab lab;
     private int served;
     private int countServed;
     private Date toWhenDate;
     private String comment;

    public UserDelivery() {
    }

    public UserDelivery(UserDeliveryId id, User user, Lab lab, int served, int countServed, Date toWhenDate, String comment) {
       this.id = id;
       this.user = user;
       this.lab = lab;
       this.served = served;
       this.countServed = countServed;
       this.toWhenDate = toWhenDate;
       this.comment = comment;
    }
   
    public UserDeliveryId getId() {
        return this.id;
    }
    
    public void setId(UserDeliveryId id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Lab getLab() {
        return this.lab;
    }
    
    public void setLab(Lab lab) {
        this.lab = lab;
    }
    public int getServed() {
        return this.served;
    }
    
    public void setServed(int served) {
        this.served = served;
    }
    public int getCountServed() {
        return this.countServed;
    }
    
    public void setCountServed(int countServed) {
        this.countServed = countServed;
    }
    public Date getToWhenDate() {
        return this.toWhenDate;
    }
    
    public void setToWhenDate(Date toWhenDate) {
        this.toWhenDate = toWhenDate;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }




}


