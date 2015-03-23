package Interfaces;


import Pojo.*;
import java.util.List;


/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public interface CourseInt {

	/**
	 * 
	 * @param crs
	 */
	public int create(Course crs);

	/**
	 * 
	 * @param crs
	 */
	public int deactive(Course crs);

	/**
	 * 
	 * @param crs
	 */
	public int delete(Course crs);

	/**
	 * 
	 * @param dept
	 */
	public List getAllActiveCourses(Department dept);

	/**
	 * 
	 * @param dept
	 */
	public List getAllDeactiveCourses(Department dept);

	/**
	 * 
	 * @param crs
	 */
	public List getOneCourseActive(Course crs);

	/**
	 * 
	 * @param crs
	 */
	public List getOneCourseDeactive(Course crs);

	/**
	 * 
	 * @param crs
	 */
	public int update(Course crs);

}