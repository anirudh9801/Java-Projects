package com.java.ejb;

import javax.faces.event.ActionEvent;
public class Calc {
	
	private int firstNo;
	private int secondNo;
	private int result;
	
	
	public String show() {
		return "Menu.jsp?faces-redirect=true";

	}
	
	public int getFirstNo() {
		return firstNo;
	}
	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}
	public int getSecondNo() {
		return secondNo;
	}
	public void setSecondNo(int secondNo) {
		this.secondNo = secondNo;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Calc(int firstNo, int secondNo, int result) {
		super();
		this.firstNo = firstNo;
		this.secondNo = secondNo;
		this.result = result;
	}
	public String redirect() {
		return "Menu.jsp?faces-redirect=true";
	}
	
	public Calc() {
		public void addition(ActionEvent) {
			
		}
	}
	
	

}
