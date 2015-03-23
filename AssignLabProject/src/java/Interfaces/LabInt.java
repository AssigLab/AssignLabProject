package Interfaces;


import Pojo.Course;
import Pojo.Lab;
import java.util.List;



/**
 * @author JETS_ITI
 * @version 1.0
 * @created 19-Mar-2015 10:55:48 AM
 */
public interface LabInt {

	


	/**
	 * 
	 * @param obj
	 */
	public int create(Lab obj);
	

	/**
	 * 
	 * @param obj
	 */
	public int delete(Lab obj);
	

	/**
	 * 
	 * @param obj
	 */
	public List getAllLab(Course obj);
	

	/**
	 * 
	 * @param obj
	 */
	public List getOneLab(Lab obj);
	

	/**
	 * 
	 * @param obj
	 */
	public int update(Lab obj);
	

}