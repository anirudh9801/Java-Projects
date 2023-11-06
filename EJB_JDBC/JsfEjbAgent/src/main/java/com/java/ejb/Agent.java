package com.java.ejb;

import java.io.Serializable;

public class Agent implements Serializable {
	private int agentID;
	private String name;
	private Gender gender;
	private String city;
	private double premium;
	private int maritalStatus;
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public int getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		maritalStatus = maritalStatus;
	}
	@Override
	public String toString() {
		return "Agent [agentID=" + agentID + ", name=" + name + ", gender=" + gender + ", city=" + city + ", premium="
				+ premium + ", maritalStatus=" + maritalStatus + "]";
	}
	public Agent(int agentID, String name, Gender gender, String city, double premium, int maritalStatus) {
		super();
		this.agentID = agentID;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.premium = premium;
		maritalStatus = maritalStatus;
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
