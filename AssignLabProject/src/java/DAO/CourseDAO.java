package DAO;

import Pojo.Course;
import Pojo.Department;
import java.util.List;



/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:45 AM
 */
public class CourseDAO extends GenericDAO {

	public CourseDAO(){

	}

	

	/**
	 * 
	 * @param c
	 */
	public int deactive(Course c){
		return 0;
	}

	/**
	 * 
	 * @param c
	 */
	public int delete(Course c){
		return 0;
	}

	/**
	 * 
	 * @param c
	 */
	public int insert(Course c){
		return 0;
	}

	/**
	 * 
	 * @param d
	 */
	public List selectAllActiveCourse(Department d){
		return null;
	}

	/**
	 * 
	 * @param d
	 */
	public List selectAllDeactiveCourse(Department d){
		return null;
	}

	/**
	 * 
	 * @param c
	 */
	public Course  selectOneActiveCourse(Course c){
		return null;
	}

	/**
	 * 
	 * @param c
	 */
	public Course  selectOneDeactiveCourse(Course c){
		return null;
	}

	/**
	 * 
	 * @param c
	 */
	public int update(Course c){
		return 0;
	}

}