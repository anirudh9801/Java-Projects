package com.java.hotel;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {

    List<Customer> showCustomer() throws ClassNotFoundException, SQLException;

    Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException;

    String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;

    String deleteCustomer(int customerId) throws ClassNotFoundException, SQLException;

    String updateCustomer(Customer customerNew) throws ClassNotFoundException, SQLException;
    
//    boolean isRoomOccupied(int roomNumber, int customerID) throws ClassNotFoundException, SQLException;
}
