package com.java.jsf;

import com.java.jsf.Gender;

public class Agent {

	private int AgentID;
	private String name;
	private String city;
	private Gender gender;
	
	private int MaritalStatus;
	private double Premium;
	public int getAgentID() {
		return AgentID;
	}
	public void setAgentID(int agentID) {
		AgentID = agentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public double getPremium() {
		return Premium;
	}
	public void setPremium(double premium) {
		Premium = premium;
	}
	@Override
	public String toString() {
		return "Agent [AgentID=" + AgentID + ", name=" + name + ", city=" + city + ", gender=" + gender
				+ ", MaritalStatus=" + MaritalStatus + ", Premium=" + Premium + "]";
	}
	public Agent(int agentID, String name, String city, Gender gender, int maritalStatus, double premium) {
		super();
		AgentID = agentID;
		this.name = name;
		this.city = city;
		this.gender = gender;
		MaritalStatus = maritalStatus;
		Premium = premium;
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
