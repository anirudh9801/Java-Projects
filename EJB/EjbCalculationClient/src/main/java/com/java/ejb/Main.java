package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	public static void main(String[] args) {
		
		try {
			CalculationBeanRemote service = 
					(CalculationBeanRemote) new InitialContext().lookup("CalculationBean/remote");
			System.out.println(service.sum(10, 25));
			System.out.println(service.sub(10, 25));
			System.out.println(service.mult(10, 25));
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
