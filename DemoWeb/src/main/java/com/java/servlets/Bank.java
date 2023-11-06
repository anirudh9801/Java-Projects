package com.java.servlets;

import java.sql.Date;

public class Bank {

	private int accountNo;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private int amount;
	private String cheqFacil;
	private String accountType;
	private String status;
	private Date dateofOpen;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCheqFacil() {
		return cheqFacil;
	}
	public void setCheqFacil(String cheqFacil) {
		this.cheqFacil = cheqFacil;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateofOpen() {
		return dateofOpen;
	}
	public void setDateofOpen(Date dateofOpen) {
		this.dateofOpen = dateofOpen;
	}
	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", state=" + state + ", amount=" + amount + ", cheqFacil=" + cheqFacil + ", accountType="
				+ accountType + ", status=" + status + ", dateofOpen=" + dateofOpen + "]";
	}
	public Bank(int accountNo, String firstName, String lastName, String city, String state, int amount,
			String cheqFacil, String accountType, String status, Date dateofOpen) {
		super();
		this.accountNo = accountNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.amount = amount;
		this.cheqFacil = cheqFacil;
		this.accountType = accountType;
		this.status = status;
		this.dateofOpen = dateofOpen;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
