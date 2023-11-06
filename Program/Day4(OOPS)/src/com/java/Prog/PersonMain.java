
package com.java.Prog;  // Package declaration

public class PersonMain {  // Declaration of the Main class
    public static void main(String[] args) {  // Main method, the entry point of the program
        Person p1 = new Person("Anirudh", 23,"Male");  // Create a Person object "p1" with a name and age
        Person p2 = new Person("Harsh", 22, "Male");    // Create another Person object "p2" with a name and age

        System.out.println(p1.getName() + " " + p1.getAge()+" "+p1.getMale());  // Print the name and age of p1
        System.out.println(p2.getName() + " " + p2.getAge()+" "+p2.getMale());  // Print the name and age of p2
    }
}