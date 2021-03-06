package Impl;

import DAO.CourseDAO;
import DAO.GenericDAO;
import DAO.GroupDAO;
import Interfaces.GroupInt;
import Pojo.Group;
import Pojo.User;
import java.util.List;

/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public class GroupImpl implements GroupInt {

    private GroupDAO groupDAO;

    public GroupImpl() {
        System.out.println("groupImpl");
        groupDAO = new GroupDAO();
    }

    @Override
    public int create(Group obj) {
        groupDAO.insert(obj);
        return 1;
    }

    @Override
    public int deactivate(Group obj) {
        groupDAO.update(obj);
        return 1;
    }

    @Override
    public int delete(Group obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Group> getAllGroupActive() {
        return groupDAO.selectAllActiveGroup();
    }

    @Override
    public List<Group> getAllGroupDeactive() {
        return groupDAO.selectAllActiveGroup();
    }

    @Override
    public Group getOneGroupActive(Group obj) {
        
       return null;
    }

    @Override
    public Group getOneGroupDeactive(Group obj) {
       
        return null;
    }

    @Override
    public List getUserGroup(User obj) {
        GenericDAO gdao = new CourseDAO();
        gdao.beginTransaction();

        GroupDAO group = new GroupDAO();

        return group.selectUserGroups(obj);

    }

    @Override
    public int update(Group obj) {
        groupDAO.update(obj);
        return 1;
    }

    @Override
    public List getGroupByName(Group Obj) {
        return groupDAO.selectOneGroup(Obj);
    }

}
