package com.java.ejb;

import java.sql.SQLException;

public class Dummy {
	
	public static void main(String[] args) {
		try {
			System.out.println(new HmsEjbBean().showDoctors());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
