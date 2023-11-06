package com.java.statemanagement;

 

public class Login {

 

	private String userName;

	private String passCode;

	public String getUserName() {

		return userName;

	}

	public String getPassCode() {

		return passCode;

	}

	public void setPassCode(String passCode) {

		this.passCode = passCode;

	}

	public void setUserName(String userName) {

		this.userName = userName;

	}

	@Override

	public String toString() {

		return "Login [userName=" + userName + ", passCode=" + passCode + "]";

	}

	public Login(String userName, String passCode) {

		super();

		this.userName = userName;

		this.passCode = passCode;

	}

	public Login() {

		super();

		// TODO Auto-generated constructor stub

	}

	

}