package com.java.Prog;

public class StringManipulator {

    // Concatenate two strings
    public String manipulate(String str1, String str2) {
        return str1 + str2;
    }

    // Count the number of occurrences of a character in a string using a for loop
    public int manipulate(String text, char character) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    // Reverse a string using a for loop
    public String manipulate(String text) {
        int length = text.length();
        char[] reversedChars = new char[length];
        for (int i = 0; i < length; i++) {
            reversedChars[i] = text.charAt(length - 1 - i);
        }
        return new String(reversedChars);
    }

    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();

        String result1 = manipulator.manipulate("Anirudh", "Mehta");
        int result2 = manipulator.manipulate("Aniruddh", 'd');
        String result3 = manipulator.manipulate("Anirudh");

        System.out.println("Concatenated Strings: " + result1);
        System.out.println("Occurrences of 'd': " + result2);
        System.out.println("Reversed String: " + result3);
    }
}
