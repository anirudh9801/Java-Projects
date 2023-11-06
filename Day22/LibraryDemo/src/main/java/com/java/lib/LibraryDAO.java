package com.java.lib;

import java.sql.SQLException;
import java.util.List;

public interface LibraryDAO {
	String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	int authenticate(LibUsers libUsers) throws SQLException, ClassNotFoundException;
	List<Books> searchBooks(String searchType, String SearchValue) throws ClassNotFoundException, SQLException;
	String  searchBookbyId( int bookId) throws SQLException, ClassNotFoundException;
	String  issuebook(String userName, int bookId) throws SQLException, ClassNotFoundException;
}