package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MachineStocker {

	
	private Map<String, Stack<Item>> vendingStock = new HashMap <String, Stack<Item>> ();
	
	public int getItemsRemaining(String key) {
				return this.vendingStock.get(key).size();
	}
	
	public Item dispense (String key) {
		if(getItemsRemaining(key) > 0) {
			return this.vendingStock.get(key).pop();
		}
		else {
			return null;
		}		
	}
	
	public void reStockMachine (Map <String, Stack<Item>> map) {
		this.vendingStock = map;
	}
}
