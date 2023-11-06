package com.java.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDAO {

    Connection connection;
    PreparedStatement pst;

    public boolean checkPassword(String pwd, String retype) {
        if (pwd.equals(retype)) {
            return true;
        }
        return false;
    }

    @Override
    public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String encPwd = EncryptPassword.getCode(libUsers.getPassWord());
        String cmd = "Insert into LibUsers(UserName, Password) values (?,?)";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, libUsers.getUserName());
        pst.setString(2, encPwd);
        pst.executeUpdate();
        return "User account Created";
    }

    @Override
    public int authenticate(LibUsers libUsers) throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String encr = EncryptPassword.getCode(libUsers.getPassWord());
        String cmd = "select count(*) cnt from LibUsers where userName=? AND Password=?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, libUsers.getUserName());
        pst.setString(2, encr.trim());
        ResultSet rs = pst.executeQuery();
        rs.next();
        int count = rs.getInt("cnt");
        return count;
    }

    @Override
    public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
        String Sql;
        boolean isValid = true;
        if (searchType.equals("id")) {
            Sql = "select * from books where ID=?";
        } else if (searchType.equals("bookname")) {
            Sql = "select * from books where Name=?";
        } else if (searchType.equals("authorname")) {
            Sql = "select * from books where Author=?";
        } else if (searchType.equals("dept")) {
            Sql = "select * from books where Dept=?";
        } else {
            isValid = false;
            Sql = "select * from books";
        }
        connection = ConnectionHelper.getConnection();
        try {
            pst = connection.prepareStatement(Sql);
            if (isValid) {
                pst.setString(1, searchValue);
            }
            ResultSet rs = pst.executeQuery();
            Books books = null;
            List<Books> booksList = new ArrayList<Books>();
            while (rs.next()) {
                books = new Books();
                books.setId(rs.getInt("id"));
                books.setName(rs.getString("name"));
                books.setAuthor(rs.getString("author"));
                books.setEdition(rs.getString("edition"));
                books.setDept(rs.getString("dept"));
                books.setNoOfBooks(rs.getInt("TotalBooks"));
                booksList.add(books);
            }
            return booksList;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Books>();
        }
    }

    @Override
    public String searchBookbyId(int bookId) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionHelper.getConnection();
        PreparedStatement selectStmt = connection.prepareStatement("SELECT * FROM Books WHERE Id = ?");
        selectStmt.setInt(1, bookId);
        ResultSet resultSet = selectStmt.executeQuery();

        if (resultSet.next()) {
            int totalBooks = resultSet.getInt("TotalBooks");
            if (totalBooks > 0) {
                return "Book is available. Details";
            } else {
                return "Book is out of stock.";
            }
        } else {
            return "Book not found.";
        }
    }

    @Override
    public String issuebook(String userName, int bookId) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionHelper.getConnection();

        // Check if the book is available
        String selectSql = "SELECT * FROM Books WHERE Id = ?";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        selectStmt.setInt(1, bookId);
        ResultSet resultSet = selectStmt.executeQuery();

        if (resultSet.next()) {
            int totalBooks = resultSet.getInt("TotalBooks");
            if (totalBooks > 0) {
                totalBooks--;

                // Update the totalBooks count in the Books table
                String updateSql = "UPDATE Books SET TotalBooks = ? WHERE Id = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                updateStmt.setInt(1, totalBooks);
                updateStmt.setInt(2, bookId);
                updateStmt.executeUpdate();

                // Insert the book issuance into TransBook table
                String insertSql = "INSERT INTO TransBook (Username, BookId) VALUES (?, ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertSql);
                insertStmt.setString(1, userName);
                insertStmt.setInt(2, bookId);
                insertStmt.executeUpdate();

                selectStmt.close();
                updateStmt.close();
                insertStmt.close();
                connection.close();

                return "Book issued successfully.";
            } else {
                selectStmt.close();
                connection.close();
                return "Book is out of stock.";
            }
        } else {
            selectStmt.close();
            connection.close();
            return "Book not found.";
        }
    }



    }
    
