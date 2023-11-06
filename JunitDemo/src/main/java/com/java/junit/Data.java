package com.java.junit;

import java.util.Hashtable;
import java.util.Map;

public class Data {
	public boolean evenOdd(int n) {
		if(n%2==0) {
			return true;
		}
		return false;
	}
	public Object mapEx(String key) {
		Map data = new Hashtable();
		data.put("Ganesh", "Mirda");
		data.put("Anirudh", "Mehta");
		data.put("Virat", "Kohli");
		data.put("Sakshi", "Dhoni");
		data.put("Anushka", "Sharma");
		return data.get(key);
	}
	public int max3(int a, int b, int c) {
		int m=a;
		if(m<b) {
			m=b;
		}
		if(m<c) {
			m=c;
		}
		return m;
	}
	public String SayHello(){
		return "Welcome to Junit Programming...";
	}
	public int sum(int a , int b) {
		return a+b;
	}

}
