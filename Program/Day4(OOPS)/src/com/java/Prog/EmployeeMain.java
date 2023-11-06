package com.java.Prog;

public class EmployeeMain {
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Jack", "Manager", 70000);
		Employee e2 = new Employee("Rock", "HR", 40000);
		
		e1.printEmployeeDetails();
		e2.printEmployeeDetails();
		
		e1.raiseSalary(8);
		e2.raiseSalary(10);
		
		System.out.println("After Raise in Salary,Employee Details is : ");
		
		e1.printEmployeeDetails();
		e2.printEmployeeDetails();
	
	}

}
