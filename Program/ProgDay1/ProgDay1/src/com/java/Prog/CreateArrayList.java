package com.java.Prog;

import java.util.*;

public class CreateArrayList {
	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("Ani");
		str.add("Harsh");
		str.add("Ariz");
		str.add("rock");
		System.out.println(str);
        System.out.println("After Iterating : ");
        
//        for (int i = 0; i < str.size(); i++) { 
//            String element = str.get(i);
//            System.out.println(element);
//        }
//        
        
		for (String elemnt : str) { // for each loop :iterarting on  Each element which is of String Type of str
			System.out.println(elemnt);
		}
	}

}
