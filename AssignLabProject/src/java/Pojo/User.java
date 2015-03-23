package Pojo;
// Generated Mar 23, 2015 5:14:14 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer idUser;
     private Department department;
     private String email;
     private String pass;
     private String name;
     private int isActive;
     private int online;
     private int type;
     private String position;
     private Integer intake;
     private int isAdmin;
     private Set groups = new HashSet(0);
     private Set userAssistances = new HashSet(0);
     private Set staffCourseGroups = new HashSet(0);
     private Set notifications = new HashSet(0);
     private Set userDeliveries = new HashSet(0);
     private Set notifications_1 = new HashSet(0);

    public User() {
    }

	
    public User(Department department, String email, String pass, String name, int isActive, int online, int type, int isAdmin) {
        this.department = department;
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.isActive = isActive;
        this.online = online;
        this.type = type;
        this.isAdmin = isAdmin;
    }
    public User(Department department, String email, String pass, String name, int isActive, int online, int type, String position, Integer intake, int isAdmin, Set groups, Set userAssistances, Set staffCourseGroups, Set notifications, Set userDeliveries, Set notifications_1) {
       this.department = department;
       this.email = email;
       this.pass = pass;
       this.name = name;
       this.isActive = isActive;
       this.online = online;
       this.type = type;
       this.position = position;
       this.intake = intake;
       this.isAdmin = isAdmin;
       this.groups = groups;
       this.userAssistances = userAssistances;
       this.staffCourseGroups = staffCourseGroups;
       this.notifications = notifications;
       this.userDeliveries = userDeliveries;
       this.notifications_1 = notifications_1;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    public int getOnline() {
        return this.online;
    }
    
    public void setOnline(int online) {
        this.online = online;
    }
    public int getType() {
        return this.type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    public Integer getIntake() {
        return this.intake;
    }
    
    public void setIntake(Integer intake) {
        this.intake = intake;
    }
    public int getIsAdmin() {
        return this.isAdmin;
    }
    
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }
    public Set getUserAssistances() {
        return this.userAssistances;
    }
    
    public void setUserAssistances(Set userAssistances) {
        this.userAssistances = userAssistances;
    }
    public Set getStaffCourseGroups() {
        return this.staffCourseGroups;
    }
    
    public void setStaffCourseGroups(Set staffCourseGroups) {
        this.staffCourseGroups = staffCourseGroups;
    }
    public Set getNotifications() {
        return this.notifications;
    }
    
    public void setNotifications(Set notifications) {
        this.notifications = notifications;
    }
    public Set getUserDeliveries() {
        return this.userDeliveries;
    }
    
    public void setUserDeliveries(Set userDeliveries) {
        this.userDeliveries = userDeliveries;
    }
    public Set getNotifications_1() {
        return this.notifications_1;
    }
    
    public void setNotifications_1(Set notifications_1) {
        this.notifications_1 = notifications_1;
    }




}


