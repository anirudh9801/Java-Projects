package com.java.Prog;

import java.util.Scanner;

public class GetChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String :  ");
		String str = sc.nextLine();
		if(!str.isEmpty()) {
			System.out.println("Please Enter the index That You Want To get : ");
			int index = sc.nextInt();
			
			if(index>=0 && index<str.length()) {
				char ch = str.charAt(index);
				System.out.println("Character at index "+index+ " is "+ch);
			}else {
				System.out.println("Enter the valid index");
			}
		}
	    
		
	}

}