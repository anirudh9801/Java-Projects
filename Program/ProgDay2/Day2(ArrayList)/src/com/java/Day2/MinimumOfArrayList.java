package com.java.Day2;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumOfArrayList {
	
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		
		arraylist.add("8765434");
		arraylist.add("4567");
		arraylist.add("78987678");
		arraylist.add("987654321");
		arraylist.add("456789876");
		
		// to find the min element of ArrayListuse,
		//we have to use the min() method from the collection class
		
		Object obj = Collections.max(arraylist);
		
		System.out.println("Minimum is : " +obj);
	}

}
