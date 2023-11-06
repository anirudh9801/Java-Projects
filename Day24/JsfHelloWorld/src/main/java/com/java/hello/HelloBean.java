package com.java.hello;

 

public class HelloBean {

 

	

	

	private String studentName;

 

	public String getStudentName() {

		return studentName;

	}

 

	public void setStudentName(String studentName) {

		this.studentName = studentName;

	}

 

	@Override

	public String toString() {

		return "HelloBean [studentName=" + studentName + "]";

	}

 

	public HelloBean(String studentName) {

		super();

		this.studentName = studentName;

	}

 

	public HelloBean() {

		super();

		// TODO Auto-generated constructor stub

	}

	

	

}

 