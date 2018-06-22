package com.techelevator;

public class Item {

	private double price; //of item in VM
	private String name; //of item in VM
	private String type; //of item in VM
	private int inventory; //of item in VM
	
	//consumption method when Finish Transaction option and after change is printed
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
	
	
	//method called with each successful product selection. decrements inventory of product
	public void dispenseItem() {
		if (this.inventory > 0) {
			this.inventory--;			
		}
	}
	
	//item constructor, values of restockMachine Map in InputFile Class
	public Item (String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
}
