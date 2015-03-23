package DAO;

import Pojo.Course;
import Pojo.Lab;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:48 AM
 */
public class LabDAO  extends GenericDAO{

	public LabDAO(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param obj
	 */
	public int delete(Lab obj){
		return 0;
	}

	/**
	 * 
	 * @param obj
	 */
	public int insert(Lab obj){
		return 0;
	}

	/**
	 * 
	 * @param obj
	 */
	public List selectAllLab(Course obj){
		return null;
	}

	/**
	 * 
	 * @param obj
	 */
	public List selectOneLab(Lab obj){
		return null;
	}

	/**
	 * 
	 * @param obj
	 */
	public int update(Lab obj){
		return 0;
	}

}