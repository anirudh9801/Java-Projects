package com.java.inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class PlaceOrderMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Stock ID: ");
        String stockId = scanner.nextLine();

        System.out.print("Enter Quantity Ordered: ");
        int quantityOrdered = scanner.nextInt();

        StockDAO stockDAO = new StockDAOImpl();

        boolean isOrderPlaced = stockDAO.placeOrder(stockId, quantityOrdered);

        if (isOrderPlaced) {
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Failed to place order.");
        }

        scanner.close();
    }
}

