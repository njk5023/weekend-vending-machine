package com.techelevator;

public class Item {

	private double price; //of item in VM
	private String name; //of item in VM
	private String type; //of item in VM
	
	//consumption method when Finish Transaction option and after change is printed
	public String getConsumeMessage() {
		if ("Chips".equals(this.type)) {
			return "Crunch Crunch, Yum!";
		} else if ("Candy".equals(this.type)) {
			return "Munch Munch, Yum!";
		} else if ("Drink".equals(this.type) ) {
			return "Glug Glug, Yum!";
		} else if ("Gum".equals(this.type)) {
			return "Chew Chew, Yum!";			
		} else {
			return "I don't know what this is, but it's tasty.";
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
	
	
	//item constructor, values of restockMachine Map in InputFile Class
	public Item (String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
}
