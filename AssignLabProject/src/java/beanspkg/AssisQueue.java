/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanspkg;

import java.util.ArrayList;

/**
 *
 * @author Muhammad Lupate
 */
public class AssisQueue {

    private ArrayList<String> list;

    public AssisQueue() {
        list = new ArrayList<>();
    }

    public ArrayList<String> getList(String lab) {
        //call whatever to return List of delivery
        if (lab.equals("lab1")) {
            list.add("Mahmoud");
            list.add("Ahmed");
            list.add("Mahmoud");
            list.add("Mhas");
        }
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

}
