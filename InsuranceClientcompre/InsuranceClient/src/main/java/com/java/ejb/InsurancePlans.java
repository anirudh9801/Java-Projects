package com.java.ejb;

import java.io.Serializable;

public class InsurancePlans implements Serializable {
    private int planId;
    private String insuranceId;
    private String premiumAmount;
    private String coverageAmount;
    
    
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getInsuranceId() {
		System.out.println("planid form insurance plan table  "+planId);
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(String coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public InsurancePlans(int planId, String insuranceId, String premiumAmount, String coverageAmount) {
		super();
		this.planId = planId;
		this.insuranceId = insuranceId;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
	}
	public InsurancePlans() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    

}