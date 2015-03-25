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
    public void create(Course crs);

    /**
     *
     * @param crs
     */
    public void deactive(Course crs);

    /**
     *
     * @param crs
     */
    public void delete(Course crs);

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
    public List getOneCourse(Course crs);

    /**
     *
     * @param crs
     */
    public void update(Course crs);

    public List getCourseByName(Course crs);
    

    public List getAllCoursesAssignedToGroup(Group group);

}
