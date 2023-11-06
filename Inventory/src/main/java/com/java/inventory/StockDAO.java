package com.java.inventory;
import java.sql.SQLException;
import java.util.List;

public interface StockDAO {
    boolean addStock(Stock stock) throws SQLException, ClassNotFoundException;
     Stock searchStock(String stockId) throws SQLException, ClassNotFoundException;
     List<Stock> showStock() throws SQLException, ClassNotFoundException;
     boolean placeOrder(String stockId, int quantityOrdered) throws SQLException, ClassNotFoundException;
    }




