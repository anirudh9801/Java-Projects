package com.java.Prog;

public class MultiplesUptoN {
    public static void printMultiples(int num, int count) {
        System.out.println("Printing first " + count + " multiples of " + num);
        for (int i = 1; i <= count; i++) {
            System.out.println(num + " x " + i + " = " + num * i);
        }
    }

    // Method overloading for different number of multiples
    public static void printMultiples(int num) {
        printMultiples(num, 10); // Default to printing 10 multiples
    }

    public static void main(String[] args) {
        // printing multiples of 2 different numbers
        printMultiples(5, 7); // 7 multiples of 5
        printMultiples(3);    // 10 multiples of 3 (default)
    }
}
