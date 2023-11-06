package com.java.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalcTest
 */
@Stateless
@Remote(CalcTestRemote.class)
public class CalcTest implements CalcTestRemote {

    /**
     * Default constructor. 
     */
    public CalcTest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

}