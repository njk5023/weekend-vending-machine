package com.techelevator;

public class Item {

	//local variable
	private double price;
	private String name;
	private String type;
	private int inventory;
	
	public void consumeMessage() {
		if (this.type.equals("Chip")) {
			System.out.println("Crunch Crunch, Yum!");
		} else if (this.type.equals("Candy")) {
			System.out.println("Munch Munch, Yum!");
		} else if (this.type.equals("Drink") ) {
			System.out.println("Glug Glug, Yum!");
		} else if (this.type.equals("Gum")) {
			System.out.println("Chew Chew, Yum!");			
		}
	}
	
	public double getPrice() {
		return this.price;
	}
	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	public int getInventory() {
		return this.inventory;
	}
	
	public void dispenseItem() {
		if (this.inventory > 0) {
			this.inventory--;			
		}
	}
		
	public Item (String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.inventory = 5;
	}
	
}
