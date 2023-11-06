package com.java.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.time.ZoneId;
import java.time.ZonedDateTime;  

public class tes {
    public static String updateCustomer() throws ClassNotFoundException, SQLException {

        Connection connection;
        PreparedStatement pst;
//        Customer customerFound = searchCustomer(customerNew.getCustomerID());
//        if (customerFound != null) {
            connection = ConnectionHelper.getConnection();
            String cmd = "UPDATE Hotel SET CustomerName=?, CheckInDate=?, CheckOutDate=?, RoomNumber=? WHERE CustomerID=?"; // Change table name to Hotel
            pst = connection.prepareStatement(cmd);
            pst.setString(1, "Anirudh ");
            LocalDateTime localDateTime = LocalDateTime.now();
            
            ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
            long now = zdt.toInstant().toEpochMilli();
            pst.setDate(2, new java.sql.Date(now));
            pst.setDate(3, new java.sql.Date(now));
            pst.setInt(4, 123);
            pst.setInt(5, 9);
            pst.executeUpdate();
            return "Customer Record Updated...";
        
      
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	updateCustomer();
    }
    
}