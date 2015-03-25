package Impl;

import DAO.CourseDAO;
import DAO.GenericDAO;
import Interfaces.CourseInt;
import Pojo.Course;
import Pojo.Department;
import Pojo.Group;
import java.util.List;

/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public class CourseImpl implements CourseInt {

    public CourseDAO Obj;

    public CourseImpl() {
        Obj = new CourseDAO();
    }

    @Override
    public void create(Course courseObj) {
        Obj.insert(courseObj);
    }

    @Override
    public void deactive(Course courseObj) {
        Obj.Update(courseObj);
    }

    @Override
    public void delete(Course courseObj) {
        Obj.Delete(courseObj);
    }

    @Override
    public List getAllActiveCourses(Department dept) {
        return Obj.selectAllActiveCourse(dept);
    }

    @Override
    public List getAllDeactiveCourses(Department dept) {
        return Obj.selectAllDeactiveCourse(dept);
    }

    @Override
    public List getOneCourse(Course courseObj) {
        return Obj.selectOneCourse(courseObj);
    }

    @Override
    public void update(Course courseObj) {
        Obj.Update(courseObj);
    }

    @Override
    public List getCourseByName(Course courseObj) {
        return Obj.SelectOneByName(courseObj);
    }

        @Override
    public List getAllCoursesAssignedToGroup(Group group) {
        GenericDAO gdao = new GenericDAO();
        gdao.beginTransaction();

        CourseDAO course = new CourseDAO();

        return course.selectAllActiveCourse(group);
    }


}
