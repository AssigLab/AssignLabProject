package Impl;


import DAO.CourseDAO;
import DAO.GenericDAO;
import DAO.TraineeDAO;
import Interfaces.UserInt;
import Pojo.Department;
import Pojo.User;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:49 AM
 */
public class TraineeImpl implements UserInt {

    private TraineeDAO Obj;

    public TraineeImpl() {
        this.Obj = new TraineeDAO();
    }

    @Override
    public void create(User userObj) {
        Obj.Insert(userObj);
    }

    @Override
    public void deactivate(User userObj) {
        Obj.Update(userObj);
    }

    @Override
    public void delete(User userObj) {
        Obj.Delete(userObj);
    }

    @Override
    public List GetAllUserDepartActive(Department deptObj) {
        return Obj.SelectAllActive(deptObj);
    }

    @Override
    public List GetAllUserDepartDeactive(Department deptObj) {
        return Obj.SelectAllDeactive(deptObj);
    }

    @Override
    public List GetOneUser(User userObj) {
        return Obj.SelectOne(userObj);
    }

    @Override
    public List GetUserByName(User userObj) {
        return Obj.SelectbyName(userObj);
    }

    @Override
    public void update(User userObj) {
        Obj.Update(userObj);
    }

  @Override
    public User getUserByName(User user) {
        GenericDAO aO = new CourseDAO();
        aO.beginTransaction();

        TraineeDAO tdao = new TraineeDAO();
        User userRet = tdao.getUserByName(user);

        return userRet;
    }
}