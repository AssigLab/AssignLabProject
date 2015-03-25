package Impl;

import DAO.GenericDAO;
import DAO.LabDAO;
import Interfaces.LabInt;
import Pojo.Course;
import Pojo.Lab;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:48 AM
 */
public class LabImpl implements LabInt {
    
    public LabDAO Obj;

    public LabImpl() {
        this.Obj = new LabDAO();
    }

    @Override
    public void create(Lab labobj) {
        Obj.insert(labobj);
    }

    @Override
    public void delete(Lab labobj) {
        Obj.delete(labobj);
    }

    @Override
    public List getAllLabActive(Course courseObj) {
        return Obj.selectAllLabActive(courseObj);
    }

    @Override
    public List getAllLabDeact(Course courseObj) {
        return Obj.selectAllLabDeact(courseObj);
    }

    @Override
    public List getOneLab(Lab labobj) {
        return Obj.selectOneLab(labobj);
    }

    @Override
    public void update(Lab labobj) {
        Obj.update(labobj);
    }

    //Nasser
    @Override
    public List getAllLab(Course obj) {
        
        GenericDAO gdao = new GenericDAO();
        gdao.beginTransaction();
        
        LabDAO lab = new LabDAO();
        
        return lab.selectAllLab(obj);
    }
    
    
    public void update_staff(Lab obj) {
        LabDAO lab = new LabDAO();
        lab.update_staff(obj);
    }
    
    public void updateEnabled_staff(Lab obj) {
        LabDAO lab = new LabDAO();
        lab.updateEnabled_staff(obj);
    }
    
    public void shiftqueue(Lab current, Lab next) {
        LabDAO lab = new LabDAO();
        lab.shiftqueue(current, next);
    }
    
}