package com.java.Day2;

import java.util.ArrayList;

public class AddElementsToSpecificIndex {
	
	public static void main(String[] args) {
		ArrayList arraylsit = new ArrayList();
		
		arraylsit.add("1");
		arraylsit.add("Anirudh");
		arraylsit.add("3");
		arraylsit.add("Amar");
		
		System.out.println("Before : " +arraylsit);
		
		arraylsit.add(3, "Giridhar");
		
		// We know that Adding elements in the list will not replace the existing element , but it wll
		// eventually shifts the element and increasing the size by 1
		
		System.out.println("After : ");
		
		for(int i = 0; i<arraylsit.size();i++) {
			System.out.println(arraylsit.get(i));
		}
	}

}
//
//
//
//package com.java.Day2;
//
//import java.util.ArrayList;
//
//public class AddElementsToSpecificIndex {
//    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<String>();
//
//        arrayList.add("1");
//        arrayList.add("Anirudh");
//        arrayList.add("3");
//        arrayList.add("Amar");
//
//        System.out.println("Before: " + arrayList);
//
//        // To replace the element at index 3 with "Giridhar"
//        arrayList.set(3, "Giridhar");
//
//        System.out.println("After: " + arrayList);
//    }
//}
