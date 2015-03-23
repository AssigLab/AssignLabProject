
import Pojo.Group;
import Pojo.User;
import java.util.List;



/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public interface GroupInt {

	

	/**
	 * 
	 * @param obj
	 */
	public int create(Group obj);
		

	/**
	 * 
	 * @param obj
	 */
	public int deactivate(Group obj);
		

	/**
	 * 
	 * @param obj
	 */
	public int delete(Group obj);
	

	/**
	 * 
	 * @param obj
	 */
	public List<Group> getAllGroupActive(Group obj);
	

	/**
	 * 
	 * @param obj
	 */
	public List<Group> getAllGroupDeactive(Group obj);

	/**
	 * 
	 * @param obj
	 */
	public Group getOneGroupActive(Group obj);
		

	/**
	 * 
	 * @param obj
	 */
	public Group getOneGroupDeactive(Group obj);

	/**
	 * 
	 * @param Obj
	 */
	public List getUserGroup(User Obj);

	/**
	 * 
	 * @param obj
	 */
	public int update(Group obj);
		

}