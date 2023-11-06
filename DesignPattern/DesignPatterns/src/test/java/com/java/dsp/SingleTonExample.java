package com.java.dsp;

public class SingleTonExample {
	public static void main(String[] args) {
		Calculation calc1 = Calculation.getInstance();
		System.out.println(calc1.sum(12, 5));
		
		
		Calculation calc2 = Calculation.getInstance();
		System.out.println(calc2.sub(12, 5));
		
		System.out.println(calc1.hashCode());
		System.out.println(calc2.hashCode());
	}

}
