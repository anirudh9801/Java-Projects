package com.java.ejb;

import java.io.Serializable;

public class Login implements Serializable {
	private int authId;
	private int custId;
	private String username;
	private String Passcode;
	private String otp;
	private String status;
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return Passcode;
	}
	public void setPasscode(String passcode) {
		Passcode = passcode;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Login(int authId, int custId, String username, String passcode, String otp, String status) {
		super();
		this.authId = authId;
		this.custId = custId;
		this.username = username;
		Passcode = passcode;
		this.otp = otp;
		this.status = status;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [authId=" + authId + ", custId=" + custId + ", username=" + username + ", Passcode=" + Passcode
				+ ", otp=" + otp + ", status=" + status + "]";
	}
	
}