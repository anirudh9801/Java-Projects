package com.java.servlets;

import java.sql.SQLException;

public interface BankDAO {
	String createAccountDao(Bank bank) throws ClassNotFoundException, SQLException;
	Bank searchAccountDao(int accountNo) throws ClassNotFoundException, SQLException;
	boolean depositAccountDao(int accountNo, double depositAmount) throws ClassNotFoundException, SQLException;
	boolean withdrawAccountDao(int accountNo, double withdrawAmount) throws ClassNotFoundException, SQLException;

}