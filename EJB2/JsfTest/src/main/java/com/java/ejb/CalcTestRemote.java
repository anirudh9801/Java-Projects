package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface CalcTestRemote {
	int sum(int a, int b);
	int sub(int a, int b);
	int mult(int a, int b);
	
	

}
