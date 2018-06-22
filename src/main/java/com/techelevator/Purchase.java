package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Purchase {
	
	private double moneyTotal;
	private String keySelected = "";
	private Map<String, Item> vendingMap;
	
	public Purchase(HashMap<String, Item> map) {
		this.moneyTotal = 0;
		this.vendingMap = map;
	}
	//feed money option selection
	public void feedMoney(int dollarsToFeed) {
		if (dollarsToFeed < 1) {
			dollarsToFeed = 0;
			System.out.print("Please enter a positive whole dollar amount.");
		}
		this.moneyTotal += dollarsToFeed;
	}
	//need to complete
	public void selectProduct(String key) {
		if (this.vendingMap.containsKey(key)) {
			
		} else {
			System.out.println("Please make a valid selection.");
		}
	}
	

}
