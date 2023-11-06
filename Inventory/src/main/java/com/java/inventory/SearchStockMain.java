package com.java.inventory;
import java.util.Scanner;

public class SearchStockMain {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Stock ID: ");
        String stockId = scanner.nextLine();

        StockDAO stockDAO = new StockDAOImpl();

        Stock foundStock = stockDAO.searchStock(stockId);

        if (foundStock != null) {
            System.out.println("Stock item found:");
            System.out.println(foundStock);
        } else {
            System.out.println("Stock item not found.");
        }

        scanner.close();
    }
}
