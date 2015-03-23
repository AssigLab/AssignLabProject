package DAO;

import Pojo.Group;
import Pojo.User;
import java.util.List;



/**
 * @author Sara
 * @version 1.0
 * @created 19-Mar-2015 10:55:46 AM
 */
public class GroupDAO extends GenericDAO {

	public GroupDAO(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param u
	 */
	public int deactivate(User u){
		return 0;
	}

	/**
	 * 
	 * @param u
	 */
	public int delete(User u){
		return 0;
	}

	/**
	 * 
	 * @param u
	 */
	public int insert(User u){
		return 0;
	}

	public List selectAllActiveGroup(){
		return null;
	}

	public List selectAllDeactiveGroup(){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List selectOneActiveGroup(Group Obj){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List selectOneDeactiveGroup(Group Obj){
		return null;
	}

	/**
	 * 
	 * @param Obj
	 */
	public List selectUserGroups(User Obj){
		return null;
	}

	/**
	 * 
	 * @param u
	 */
	public int update(User u){
		return 0;
	}

}