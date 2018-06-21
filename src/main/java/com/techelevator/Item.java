package com.techelevator;

public class Item {

	//local valriable
	private double price;
	private String name;
	private String type;
	
	public double getPrice() {
		return this.price;
	}
	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	
	public Item (String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
}
