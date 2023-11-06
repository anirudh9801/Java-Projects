package com.java.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    Connection connection;
    PreparedStatement pst;

    @Override
    public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Hotel"; 
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer = null;
        while (rs.next()) {
            customer = new Customer();
            customer.setCustomerID(rs.getInt("CustomerID"));
            customer.setCustomerName(rs.getString("CustomerName"));
            customer.setCheckInDate(rs.getDate("CheckInDate"));
            customer.setCheckOutDate(rs.getDate("CheckOutDate"));
            customer.setRoomNumber(rs.getInt("RoomNumber"));
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Hotel WHERE CustomerID=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        Customer customer = null;
        if (rs.next()) {
            customer = new Customer();
            customer.setCustomerID(rs.getInt("CustomerID"));
            customer.setCustomerName(rs.getString("CustomerName"));
            customer.setCheckInDate(rs.getDate("CheckInDate"));
            customer.setCheckOutDate(rs.getDate("CheckOutDate"));
            customer.setRoomNumber(rs.getInt("RoomNumber"));
        }
        return customer;
    }

    @Override
    public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();

//        // Check if the room is already occupied
//        if (isRoomOccupied(customer.getRoomNumber(), 0)) { // 0 means no customer exists with this ID yet
//            return "Room is already occupied and cannot be allocated to the new customer.";
//        }

        String cmd = "INSERT INTO Hotel (CustomerName, CheckInDate, CheckOutDate, RoomNumber) VALUES (?, ?, ?, ?)";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, customer.getCustomerName());
        pst.setDate(2, new java.sql.Date(customer.getCheckInDate().getTime()));
        pst.setDate(3, new java.sql.Date(customer.getCheckOutDate().getTime()));
        pst.setInt(4, customer.getRoomNumber());
        pst.executeUpdate();

        return "Customer Record Inserted...";
    }

    @Override
    public String deleteCustomer(int customerId) throws ClassNotFoundException, SQLException {
        Customer customer = searchCustomer(customerId);
        if (customer != null) {
            connection = ConnectionHelper.getConnection();
            String cmd = "DELETE FROM Hotel WHERE CustomerID=?"; 
            pst = connection.prepareStatement(cmd);
            pst.setInt(1, customerId);
            pst.executeUpdate();
            return "Customer Record Deleted...";
        }
        return "Customer Record Not Found...";
    }

    @Override
    public String updateCustomer(Customer customerNew) throws ClassNotFoundException, SQLException {
        Customer customerFound = searchCustomer(customerNew.getCustomerID());
        if (customerFound != null) {
            connection = ConnectionHelper.getConnection();
            String cmd = "UPDATE Hotel SET CustomerName=?, CheckInDate=?, CheckOutDate=?, RoomNumber=? WHERE CustomerID=?"; 
            pst = connection.prepareStatement(cmd);
            pst.setString(1, customerNew.getCustomerName());
            pst.setDate(2, new java.sql.Date(customerNew.getCheckInDate().getTime()));
            pst.setDate(3, new java.sql.Date(customerNew.getCheckOutDate().getTime()));
            pst.setInt(4, customerNew.getRoomNumber());
            pst.setInt(5, customerNew.getCustomerID());
            pst.executeUpdate();
            return "Customer Record Updated...";
        }
        return "Customer Record Not Found...";
    }
//
//        @Override
//        public boolean isRoomOccupied(int roomNumber, int customerID) throws ClassNotFoundException, SQLException {
//            connection = ConnectionHelper.getConnection();
//            String cmd = "SELECT COUNT(*) FROM  WHERE RoomNumber = ? AND CustomerID != ?";
//            pst = connection.prepareStatement(cmd);
//            pst.setInt(1, roomNumber);
//            pst.setInt(2, customerID);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                int count = rs.getInt(1);
//                return count > 0;
//            }
//            return false;
//      }
    }


