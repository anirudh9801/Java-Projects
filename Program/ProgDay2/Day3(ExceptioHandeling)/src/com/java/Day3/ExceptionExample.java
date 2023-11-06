package com.java.Day3;

public class ExceptionExample {
	public static void main(String[] args) {
		try {
			int result = divideNumbers(5, 0);
			System.out.println("Result : " +result);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("Error : "+e.getMessage());
		}
	
	}
	public static int divideNumbers(int dividend, int divisor) {
		if(divisor==0) {
			throw new ArithmeticException("cannot divide the given number by zero!");
		}
		return dividend/divisor;
	}

}
 