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
public class DeliveryQueue {

    private ArrayList<String> list;

    public DeliveryQueue() {
        list = new ArrayList<>();
    }

    public ArrayList<String> getList(String lab) {
        if (lab.equals("lab1")) {
            list.add("7oda");
            list.add("3esam");
        }
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

}
