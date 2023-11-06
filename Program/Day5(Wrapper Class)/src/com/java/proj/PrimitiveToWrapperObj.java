package com.java.proj;

public class PrimitiveToWrapperObj {
	
	public static void main(String[] args) {
		
		//create primitive types
		
		int a=5;
		double b=5.65;
		
		// creating wrapper objects from the primitive values a and b.
		Integer aObj = Integer.valueOf(a);
		Double bObj = Double.valueOf(b);
		
		
		if(aObj instanceof Integer) {
			System.out.println("An Object of integer is Created");
		}
		if(bObj instanceof Double) {
			System.out.println("An Object of Double is created");
		}
	}

}
