package com.java.Day3;

public class CheckEvenNo {
	public static void main(String[] args) {
	        try {
				   checkEvenNo(7);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block  
				e.printStackTrace();
			}
	       
		
	}
	
	public static void checkEvenNo(int number) {
		if(number%2!=0) {
			throw new IllegalArgumentException(number +" is Odd");
		}else {
			System.out.println(number +" Is Even");
		}
	}

}
