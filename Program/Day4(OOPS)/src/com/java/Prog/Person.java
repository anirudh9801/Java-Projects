package com.java.Prog;  // Package declaration

class Person {  // Declaration of the Person class
    private String name;  // Private attribute to store the name
    private int age;  // Private attribute to store the age
    private String Male;
	public Person(String name, int age, String male) {
		super();
		this.name = name;
		this.age = age;
		Male = male;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getMale() {
		return Male;
	}
    
}
