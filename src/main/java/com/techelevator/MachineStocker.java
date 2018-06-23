package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MachineStocker {

	private Map<String, Stack<Item>> vendingStock = new HashMap<String, Stack<Item>>();
	private List<Item> itemsBought = new ArrayList<Item>();
	

	public Map<String, Stack<Item>> getMap() {
		return this.vendingStock;
	}

	public String getOrderedMenu() {
		String stringToReturn = "";
		ArrayList<String> stringList = new ArrayList<String>();
		for (Map.Entry<String, Stack<Item>> kv : this.getMap().entrySet()) {
			if (kv.getValue().size() > 0) {
				stringList.add("" + kv.getKey() + " " + kv.getValue().peek().getName() + " "
						+ kv.getValue().peek().getPrice() + " INVENTORY: " + kv.getValue().size() + "\n");
			} else {
				stringList.add("" + kv.getKey() + " " + kv.getValue().peek().getName() + " "
						+ kv.getValue().peek().getPrice() + " SOLD OUT\n");
			}
		}

		Collections.sort(stringList);
		for (String c : stringList) {
			stringToReturn += c;
		}

		/*
		 * ArrayList<Map.Entry<String, Stack<Item>>> arrayList = new
		 * ArrayList<Map.Entry<String, Stack<Item>>>(); for (Map.Entry<String,
		 * Stack<Item>> kv : this.getMap().entrySet()) { arrayList.add(kv); }
		 * arrayList.sort(c);
		 */
		return stringToReturn;
	}

	public void reStockMachine(Map<String, Stack<Item>> map) {
		this.vendingStock = map;
	}

	public int getItemsRemaining(String key) {
		return this.vendingStock.get(key).size();
	}

	public Item dispense(String key) {
		if (this.getItemsRemaining(key) > 0) {
			return this.vendingStock.get(key).pop();
		} else {
			return null;
		}
	}
	
	public void itemBought(Item item) {
		this.itemsBought.add(item);
	}

}
