package com.java.Day3;

public class ExectionExample2 {
	public static void main(String[] args) {
		
		try {
			System.out.print("A");
			int num = 99/0;
			System.out.print("B"); // Here B will Not Print in the console bcz
		                           //it will not be ecuted as its previous line throws an exception
		} catch (ArithmeticException e) 
		{
			System.out.print("C");
			
		}catch (Exception e) {
			System.out.print("D");
			
			
		}finally { // finally block will be executed every-time 
		          //it does not depend on whether an exception in the corresponding try is thrown or not,
			      // and regardless of whether a thrown exception is caught or not
			System.out.print("E");
		}
	}
	
	

}
