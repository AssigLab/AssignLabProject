package Interfaces;


import Pojo.*;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public interface DepartInt {

	 /**
     *
     * @param Obj
     */
    public abstract void create(Department Obj);

    /**
     *
     * @param Obj
     */
    public abstract void deactivate(Department Obj);

    /**
     *
     * @param Obj
     */
    public void delete(Department Obj);

    public List GetAllDepartActive();

    public List GetAllDepartDeactive();
    
    
    /**
     *
     * @param Obj
     */
    public List GetOneDepartActive(Department Obj);

    /**
     *
     * @param Obj
     */
    public List GetOneDepartDeactive(Department Obj);

    /**
     *
     * @param Obj
     */
    public abstract void update(Department Obj);
    
    /**
     *
     * @param Obj
     */
    public abstract List getDepartByName(Department Obj);


}