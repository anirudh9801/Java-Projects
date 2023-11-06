package com.java.hello;

import java.util.Date;

public class Greeting {
	public String company() {
		return "company is infinite....";
	}
	public String salutaion() {
		Date obj = new Date();
		int hr = obj.getHours();
		if(hr<=12) {
			return "Good Morning......";
		}
		else if(hr>12 && hr<16) {
			return "Godd afternoon.....";
		}else {
			return "Good Evening....";
		}
	}

}
