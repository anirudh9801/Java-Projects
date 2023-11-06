package com.java.servlets;

import java.sql.SQLException;


public interface CustomerDAO {
    String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
    Customer searchByUserName(String userName) throws ClassNotFoundException, SQLException;
    String validateOtp(String user, int otpCode) throws ClassNotFoundException, SQLException;
    void saveResetTokenInDatabase(String userName, String resetToken) throws ClassNotFoundException, SQLException;
    boolean isResetTokenValid(String resetToken) throws ClassNotFoundException, SQLException;
    void updatePasswordByResetToken(String resetToken, String newPassword) throws ClassNotFoundException, SQLException;
}

	

