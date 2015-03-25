package Interfaces;

import Pojo.Department;
import Pojo.User;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:49 AM
 */
public interface UserInt {

	
	/**
	 * 
	 * @param Obj
	 */
	public void create(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public void deactivate(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public void delete(User Obj);
	
	/**
	 * 
	 * @param Obj
	 */
	public List GetAllUserDepartActive(Department Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public List GetAllUserDepartDeactive(Department Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public List GetOneUser(User Obj);
	
        /**
	 * 
	 * @param Obj
	 */
	public List GetUserByName(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public void update(User Obj);
	
         public User getUserByName(User user);

}