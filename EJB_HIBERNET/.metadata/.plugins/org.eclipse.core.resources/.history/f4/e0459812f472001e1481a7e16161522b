package com.java.ejb;

 

import java.io.Serializable;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="insurance_details")
public class Insurance implements Serializable {

 

	@Id
	@GeneratedValue
	@Column(name="insuranceId")
	private String insuranceId;


	@Column(name="insuranceName")
	private String insuranceName;

	@Column(name="insuranceType")
	private String insuranceType;

	@Column(name="premiumStart")
	private String premiumStart;

	@Column(name="premiumEnd")
	private String premiumEnd;

	@Column(name="minPeriod")
	private String minPeriod;

	@Column(name="maxPeriod")
	private String maxPeriod;

	@Column(name="launchDate")
	private String launchDate;

	@Column(name="status")
	private String status;

	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getPremiumStart() {
		return premiumStart;
	}
	public void setPremiumStart(String premiumStart) {
		this.premiumStart = premiumStart;
	}
	public String getPremiumEnd() {
		return premiumEnd;
	}
	public void setPremiumEnd(String premiumEnd) {
		this.premiumEnd = premiumEnd;
	}
	public String getMinPeriod() {
		return minPeriod;
	}
	public void setMinPeriod(String minPeriod) {
		this.minPeriod = minPeriod;
	}
	public String getMaxPeriod() {
		return maxPeriod;
	}
	public void setMaxPeriod(String maxPeriod) {
		this.maxPeriod = maxPeriod;
	}
	public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", insuranceName=" + insuranceName + ", insuranceType="
				+ insuranceType + ", premiumStart=" + premiumStart + ", premiumEnd=" + premiumEnd + ", minPeriod="
				+ minPeriod + ", maxPeriod=" + maxPeriod + ", launchDate=" + launchDate + ", status=" + status + "]";
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(String insuranceId, String insuranceName, String insuranceType, String premiumStart,
			String premiumEnd, String minPeriod, String maxPeriod, String launchDate, String status) {
		super();
		this.insuranceId = insuranceId;
		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.premiumStart = premiumStart;
		this.premiumEnd = premiumEnd;
		this.minPeriod = minPeriod;
		this.maxPeriod = maxPeriod;
		this.launchDate = launchDate;
		this.status = status;
	}

}


