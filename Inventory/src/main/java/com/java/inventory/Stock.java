package com.java.inventory;

public class Stock {
	private String stockId;
	private String ItemName;
	private double price;
	private int QuantityAvail;
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityAvail() {
		return QuantityAvail;
	}
	public void setQuantityAvail(int quantityAvail) {
		QuantityAvail = quantityAvail;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String stockId, String itemName, int price, int quantityAvail) {
		super();
		this.stockId = stockId;
		ItemName = itemName;
		this.price = price;
		QuantityAvail = quantityAvail;
	}
	@Override
	public String toString() {
		return "Inventory [stockId=" + stockId + ", ItemName=" + ItemName + ", price=" + price + ", QuantityAvail="
				+ QuantityAvail + "]";
	}
	
	
}
