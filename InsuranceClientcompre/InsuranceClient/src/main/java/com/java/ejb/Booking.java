package com.java.ejb;

import java.io.Serializable;
import java.sql.Date;

public class Booking implements Serializable {
	public int PolicyId;
	public int custId;
	public int planId;
	public String insuranceId;
	private String PremiumAmount;
	private String Paymode;
	private Double InstallmentAmount;
	private Date RegisterDate;
	public int getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(int policyId) {
		PolicyId = policyId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getPlanId() {
		System.out.println("Getter plan id "+this.planId);
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
		System.out.println("Plan id "+planId);
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getPremiumAmount() {
		return PremiumAmount;
	}
	public void setPremiumAmount(String premiumAmount) {
		PremiumAmount = premiumAmount;
	}
	public String getPaymode() {
		return Paymode;
	}
	public void setPaymode(String paymode) {
		Paymode = paymode;
	}
	public Double getInstallmentAmount() {
		return InstallmentAmount;
	}
	public void setInstallmentAmount(Double installmentAmount) {
		InstallmentAmount = installmentAmount;
	}
	public Date getRegisterDate() {
		return RegisterDate;
	}
	public void setRegisterDate(Date registerDate) {
		RegisterDate = registerDate;
	}
	
	

}
