package com.java.proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WrapperCollection {
    public static void main(String[] args) {
        // Create a list of Integer objects
        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(17);
        numbers.add(82);
        numbers.add(34);
        numbers.add(56);

        // Find the maximum and minimum values in the list
        Integer max = Collections.max(numbers);
        Integer min = Collections.min(numbers);

        // Calculate the average of the values
        double sum = 0.0;
        for (Integer num : numbers) {
            sum += num;
        }
        double average = sum / numbers.size();

        // Display the results
        System.out.println("List of Numbers: " + numbers);
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
        System.out.println("Average: " + average);
    }
}
