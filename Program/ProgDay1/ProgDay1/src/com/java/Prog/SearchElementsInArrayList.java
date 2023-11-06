package com.java.Prog;

import java.util.ArrayList;

public class SearchElementsInArrayList {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anirudh");
		names.add("Harsh");
		names.add("Himanshu");
		names.add("Ariz");
		names.add("Giridhar");
		
		System.out.println("Does names contains Anirudh : " +names.contains("Anirudh"));
		
		// now if i want to find the index of any name 
		
		System.out.println("Index of Anirudh : " +names.indexOf("Anirudh"));
		System.out.println("Index of Giridhar : " +names.indexOf("Giridhar"));
		
		// now lets try a name which is not present in the list
		
		System.out.println("Index of Yukesh : " +names.indexOf("Yukesh"));
	}

}
