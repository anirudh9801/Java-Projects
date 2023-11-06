package com.java.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAOImpl implements BankDAO {

	Connection connection;
	PreparedStatement pst;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection = BankConnectionHelper.getConnection();
		String cmd = "Select Case when max(AccountNo) IS NULL THEN "
				+ " 1 else max(accountNo)+1 end accno from Bank";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		return accno;
	}
	@Override
	public String createAccountDao(Bank bank) throws ClassNotFoundException, SQLException {
		int id = generateAccountNo();
		bank.setAccountNo(id);
		connection = BankConnectionHelper.getConnection();
		String cmd = "Insert into Bank(AccountNo, FirstName, LastName, City, "
		+ " state, amount, cheqFacil, AccountType) values(?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, bank.getAccountNo());
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setDouble(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "Account created with Account No " +id;
	}
	@Override
	public Bank searchAccountDao(int accountNo) throws ClassNotFoundException, SQLException {
		connection = BankConnectionHelper.getConnection();
		String cmd = "select * from Bank where accountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		if (rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("firstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getInt("amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("accountType"));
			bank.setDateofOpen(rs.getDate("dateOfOpen"));
			bank.setStatus(rs.getString("status"));
		}
		return bank;
	}
//	@Override
//	public String closeAccountDao(int accountNo) throws ClassNotFoundException, SQLException {
//		Bank bank = searchAccountDao(accountNo);
//		if (bank!=null) {
//			connection = BankConnectionHelper.getConnection();
//			String cmd = "update bank set status = 'inactive' where accountNo=?";
//			pst = connection.prepareStatement(cmd);
//			pst.setInt(1, accountNo);
//			pst.executeUpdate();
//			return "Account Closed...";
//		}
//		return "Account No Not Found...";
//	}
	@Override
	public boolean depositAccountDao(int accountNo, double depositAmount) throws ClassNotFoundException, SQLException {
	    Bank bank = searchAccountDao(accountNo);
	    if (bank != null) {
	        connection = BankConnectionHelper.getConnection();
	        String cmd = "Update Bank set Amount = Amount + ? Where AccountNo=?";
	        pst = connection.prepareStatement(cmd);
	        pst.setDouble(1, depositAmount);
	        pst.setInt(2, accountNo);
	        int rowsUpdated = pst.executeUpdate();
	        if (rowsUpdated > 0) {
	            cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
	            pst = connection.prepareStatement(cmd);
	            pst.setInt(1, accountNo);
	            pst.setDouble(2, depositAmount);
	            pst.setString(3, "Deposited");
	            pst.executeUpdate();
	            return true; 
	        }
	    }
	    return false;
	}

	@Override
	public boolean withdrawAccountDao(int accountNo, double withdrawAmount) throws ClassNotFoundException, SQLException {
	    Bank bank = searchAccountDao(accountNo);
	    if (bank != null) {
	        int amount = bank.getAmount();
	        if (amount - withdrawAmount >= 1000) {
	            connection = BankConnectionHelper.getConnection();
	            String cmd = "Update Bank set Amount = Amount - ? Where AccountNo=?";
	            pst = connection.prepareStatement(cmd);
	            pst.setDouble(1, withdrawAmount);
	            pst.setInt(2, accountNo);
	            pst.executeUpdate();
	            cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
	            pst = connection.prepareStatement(cmd);
	            pst.setInt(1, accountNo);
	            pst.setDouble(2, withdrawAmount);
	            pst.setString(3, "Withdrawal");
	            pst.executeUpdate();
	            return true;
	        } else {
	            return false; 
	        }
	    }
	    return false; 
	}
}
