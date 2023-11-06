package com.java.proj;

public class WrapperComparison {
    public static void main(String[] args) {
        // Create two Integer objects 'a' and 'b' with values 10 and 20.
        Integer a = 10;
        Integer b = 20;
        
        // Compare two Integer objects using the compareTo method
        int result = a.compareTo(b);  // here compare to return integer value
        
        // Check the result of the comparison and print the appropriate message.
        if (result < 0) {
            System.out.println("a is less than b");
        } else if (result > 0) {
            System.out.println("a is greater than b");
        } else {
            System.out.println("a is equal to b");
        }
    }
}
