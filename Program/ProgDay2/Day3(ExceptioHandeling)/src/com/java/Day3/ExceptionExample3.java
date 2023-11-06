package com.java.Day3;

public class ExceptionExample3 {
    public static void main(String[] args) {
        try {
            System.out.println("A"); // Print "A"
            throw new Exception(); // Throw an Exception
        } catch (Exception e) {
            System.out.println("B"); // This block is executed when an Exception is caught
        } finally {
            System.out.println("C"); // Print "C" (Always executed, even if there's an exception)
            int num = 9/0; // This line will throw an ArithmeticException
            System.out.println("D"); // This line is not executed due to the exception
        }
        System.out.println("E"); // This line is not executed due to the unhandled exception
    }
}