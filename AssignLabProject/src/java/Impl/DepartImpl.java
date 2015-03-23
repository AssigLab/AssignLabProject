package Impl;
import DAO.DepartDAO;
import Interfaces.DepartInt;
import Pojo.Department;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public class DepartImpl implements DepartInt {
    
    private DepartDAO Obj;

    public DepartImpl() {
        Obj = new DepartDAO();
    }

    @Override
    public void create(Department departObj) {
        Obj.Insert(departObj);
    }

    @Override
    public void deactivate(Department departObj) {
        Obj.Update(departObj);
    }

    @Override
    public void delete(Department departObj) {
        Obj.Delete(departObj);
    }

    @Override
    public List GetAllDepartActive() {
        return Obj.SelectAllActive();
    }

    @Override
    public List GetAllDepartDeactive() {
        return Obj.SelectAllDeactive();
    }

    @Override
    public List GetOneDepartActive(Department departObj) {
        return Obj.SelectOne(departObj);
    }

    @Override
    public List GetOneDepartDeactive(Department departObj) {
        return Obj.SelectOne(departObj);
    }

    @Override
    public void update(Department departObj) {
        Obj.Update(departObj);
    }

    @Override
    public List getDepartByName(Department departObj) {
        return Obj.SelectOneByName(departObj);
    }
}