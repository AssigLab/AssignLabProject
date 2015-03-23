package Impl;


import DAO.CourseDAO;
import Interfaces.CourseInt;
import Pojo.Course;
import Pojo.Department;
import java.util.List;



/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public class CourseImpl implements CourseInt {

	public CourseDAO m_CourseDAO;


    @Override
    public int create(Course crs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deactive(Course crs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Course crs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllActiveCourses(Department dept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllDeactiveCourses(Department dept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getOneCourseActive(Course crs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getOneCourseDeactive(Course crs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Course crs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}