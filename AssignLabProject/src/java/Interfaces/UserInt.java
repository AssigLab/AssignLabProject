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
	public int create(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public int deactivate(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public int delete(User Obj);
	

	public List GetAllUserActive();


	public List GetAllUserDeactive();
	

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
	public List GetOneUserActive(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public List GetOneUserDeactive(User Obj);
	

	/**
	 * 
	 * @param Obj
	 */
	public int update(User Obj);
	

}