package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
	public static void main(String[] args) {
		HelloWorldRemote service = null;
		try {
			service = (HelloWorldRemote) new InitialContext().lookup("HelloWorld/remote");
			System.out.println(service.sayHello());
			System.out.println(service.greeting("Anirudh"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
