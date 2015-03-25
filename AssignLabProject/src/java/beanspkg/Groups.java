/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanspkg;

import Impl.GroupImpl;
import Interfaces.GroupInt;
import Pojo.Group;
import Pojo.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Muhammad Lupate
 */
public class Groups {

    ArrayList<String> deptNames;
    String selectedDeptString;
    List<Group> groups ;
    GroupInt groupInt;
    
    public Groups() {
        User user = new User();
        
        groupInt = new GroupImpl();
        groups = groupInt.getUserGroup(null);
        deptNames = new ArrayList<String>();
        deptNames.add("dept1");
        deptNames.add("dept2");
        deptNames.add("dept3");
        Collections.sort(deptNames);
        selectedDeptString = null;
    }

    public static boolean equals(
            String l1,
            String l2) {
        return l1.equals(l2);
    }

    public Collection getDeptNames() {
        return deptNames;
    }

    public void setSelectedDeptString(String displayName) {
        this.selectedDeptString = displayName;
    }

    public String getSelectedDeptString() {
        return selectedDeptString;
    }

}
