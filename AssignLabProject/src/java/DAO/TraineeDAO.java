package DAO;


import Pojo.Department;
import Pojo.User;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:49 AM
 */
public class TraineeDAO  extends GenericDAO{

	public TraineeDAO(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Obj
	 */
	public int Deactivate(User Obj){
		return 0;
	}

	/**
	 * 
	 * @param Obj
	 */
	public int Delete(User Obj){
		return 0;
	}

	/**
	 * 
	 * @param Obj
	 */
	public int Insert(User Obj){
		return 0;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List SelectAllActive(Department Obj){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List SelectAllDeactive(Department Obj){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List SelectOneActive(User Obj){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List SelectOneDeactive(User Obj){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public int Update(User Obj){
		return 0;
	}

}