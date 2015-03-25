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
    public void create(Lab obj);

    public List getAllLab(Course obj);
    /**
     *
     * @param obj
     */
    public void delete(Lab obj);

    /**
     *
     * @param obj
     */
    public List getAllLabActive(Course obj);

    /**
     *
     * @param obj
     */
    public List getAllLabDeact(Course obj);

    /**
     *
     * @param obj
     */
    public List getOneLab(Lab obj);

    /**
     *
     * @param obj
     */
    public void update(Lab obj);

    public void update_staff(Lab obj);

    public void updateEnabled_staff(Lab obj);

    public void shiftqueue(Lab current, Lab next);

}
