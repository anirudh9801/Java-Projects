package com.java.inventory;
import java.util.Scanner;

public class AddStockMain {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Quantity Available: ");
        int quantityAvail = scanner.nextInt();

        Stock stockToAdd = new Stock();
        stockToAdd.setItemName(itemName);
        stockToAdd.setPrice(price);
        stockToAdd.setQuantityAvail(quantityAvail);

        StockDAO stockDAO = new StockDAOImpl();

        boolean isStockAdded = stockDAO.addStock(stockToAdd);

        if (isStockAdded) {
            System.out.println("Stock item added successfully.");
        } else {
            System.out.println("Failed to add stock item.");
        }

        scanner.close();
    }
}
