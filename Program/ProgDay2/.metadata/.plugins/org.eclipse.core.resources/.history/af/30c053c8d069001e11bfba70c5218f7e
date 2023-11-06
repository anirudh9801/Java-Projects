package com.java.Day2;

import java.util.ArrayList;
public class RmvDuplArrLst {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();//creating an ArrayList with duplicate elements
        colors.add("Red"); // Adding the elements to ArrayList
        colors.add("Blue");
        colors.add("Blue");
        colors.add("Black");

        // Removing the duplicate element using a traditional for loop
        for (int i = 0; i < colors.size(); i++) {
            String currentColor = colors.get(i);
            for (int j = i + 1; j < colors.size(); j++) {
                if (currentColor.equals(colors.get(j))) {
                    colors.remove(j);
                    j--; // Decrement j to account for the removed element
                }
            }
        }

        // Iterating with a traditional for loop to print the unique elements
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }
}

//public class RmvDuplArrLst {
//	public static void main(String[] args) {
//		ArrayList<String> colors = new ArrayList<String>();//creating an Arraylist with duplicate element
//		colors.add("Red"); // Adding the elements in Arraylist
//		colors.add("Blue");
//		colors.add("Blue");
//		colors.add("Black");
//		
//		//Removing the duplicate element using remove() method
//		colors.remove("Blue");
//		// iterating on every elements in colors 
//		for (String str : colors) {
//			System.out.println(str);
//		}
//	}
//
//}

