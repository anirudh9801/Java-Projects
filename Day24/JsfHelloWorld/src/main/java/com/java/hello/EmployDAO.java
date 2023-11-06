package com.java.hello;

import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
    public List<Employ> showEmploy() {
        List<Employ> employList = new ArrayList<Employ>();
        employList.add(new Employ(1, "Gaurav", "Java", "Devloper", 84245.33));
        employList.add(new Employ(2, "Harshit", "J2EE", "Manager", 56245.3));
        employList.add(new Employ(3, "Virat", "MySql", "TL", 67455.343));
        employList.add(new Employ(4, "Anushka", "Python", "tester", 8544555.83));
        employList.add(new Employ(5, "Gandhi", "JRE", "Devloper", 7349.35));

        return employList; 
    }
}
