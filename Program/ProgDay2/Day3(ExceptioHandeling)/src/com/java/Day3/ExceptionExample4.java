package com.java.Day3;

public class ExceptionExample4 {
    public static void main(String[] args) {
        try {
            int arr[] = {1, 2, 3, 4, 5};
            for (int i = 0; i <= 5; i++) {
                System.out.println("Array Elements Are: " + arr[i] + "\n");
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("Error: " + a);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
