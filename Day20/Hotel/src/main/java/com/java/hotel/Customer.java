package com.java.hotel;

import java.util.Date;

public class Customer {
	
	private int CustomerID;
	private String CustomerName;
	private Date CheckInDate;
	private Date CheckOutDate;
	private int RoomNumber;
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public Date getCheckInDate() {
		return CheckInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		CheckInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return CheckOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		CheckOutDate = checkOutDate;
	}
	public int getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerID, String customerName, Date checkInDate, Date checkOutDate, int roomNumber) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		RoomNumber = roomNumber;
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", CustomerName=" + CustomerName + ", CheckInDate=" + CheckInDate
				+ ", CheckOutDate=" + CheckOutDate + ", RoomNumber=" + RoomNumber + "]";
	}
	
	

}
