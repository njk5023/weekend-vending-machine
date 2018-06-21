package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class SelectProduct {
	
	public static void main(String[] args) {
	
	String path = "vendingmachine.csv";
	Map <String, Item> ourMap = InputFile.restockMachine(path);
	
		
	String key;
	
	Scanner input = new Scanner(System.in);
	System.out.print("Provide desired key: ");
	key = input.nextLine();
	if (!ourMap.containsKey(key)) {
		System.out.println("Invalid key, please try again.");
	} else if (ourMap.get(key).getInventory() == 0) {
		System.out.println("Item sold out! Please try again.");
	} else {
		ourMap.get(key).dispenseItem();
		
	}
	
	
	
	

	}
}
