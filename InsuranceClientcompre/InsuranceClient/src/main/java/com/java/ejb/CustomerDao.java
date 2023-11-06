package com.java.ejb;

import java.util.List;

public interface CustomerDao {

	
	List<Customer> showCustomer();
	
	String addCustomer(Customer customer);
	
	
}
