package com.java.Day2;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListCollectionsSort {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(13);
        numbers.add(1);
        numbers.add(3);
        numbers.add(7);
        numbers.add(10);
        numbers.add(99);
        
        System.out.println("Before Sorting: " + numbers);
        
        Collections.sort(numbers);
        
        System.out.println("After Sorting: " + numbers);
    }
}