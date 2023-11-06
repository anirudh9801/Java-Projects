package com.java.inventory;

import java.util.List;

public class ShowStockMain {

    public static void main(String[] args) throws Exception {
        StockDAO stockDAO = new StockDAOImpl();

        List<Stock> stockList = stockDAO.showStock();

        if (!stockList.isEmpty()) {
            System.out.println("Stock items:");
            for (Stock stock : stockList) {
                System.out.println(stock);
            }
        } else {
            throw new Exception("No stock items found.");
        }
    }
}
