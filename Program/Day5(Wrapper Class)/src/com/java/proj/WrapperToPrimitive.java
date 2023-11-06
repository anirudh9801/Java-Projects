package com.java.proj;

public class WrapperToPrimitive {
    public static void main(String[] args) {
        // Create an Integer object 'aObj' and store the value 23 in it.
        Integer aObj = Integer.valueOf(23);
        
        // Create a Double object 'bObj' and store the value 5.55 in it.
        Double bObj = Double.valueOf(5.55);
        
        // Extract the integer value from 'aObj' and store it in the primitive int variable 'a'.
        int a = aObj.intValue();
        
        // Extract the double value from 'bObj' and store it in the primitive double variable 'b'.
        double b = bObj.doubleValue();
        
        // Print the value of 'a' (which is 23) to the console.
        System.out.println(a);
        
        // Print the value of 'b' (which is 5.55) to the console.
        System.out.println(b);
    }
}
