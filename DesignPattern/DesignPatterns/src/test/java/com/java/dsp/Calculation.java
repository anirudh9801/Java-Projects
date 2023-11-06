package com.java.dsp;

public class Calculation {
	private Calculation() {}
		private static Calculation calculation;
		public static Calculation getInstance() {
			if(calculation==null) {
				calculation= new Calculation();
			
		}
		return calculation;
}
	public int sum(int x, int y) {
		return x+y;
	}
	public int sub(int x, int y) {
		return x-y;
	}

	}
//The code you provided appears to be a Java class named "Calculation" 
//that is designed to be a Singleton,
//which means that it ensures only one instance of the class can be created. 