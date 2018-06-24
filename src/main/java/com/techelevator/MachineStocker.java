package com.techelevator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class MachineStocker {

	private Map<String, Stack<Item>> vendingStock = new HashMap<String, Stack<Item>>();
	private NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

	public Map<String, Stack<Item>> getMap() {
		return this.vendingStock;
	}

	public String getOrderedMenu() {
		String stringToReturn = "";
		ArrayList<String> stringList = new ArrayList<String>();
		for (Map.Entry<String, Stack<Item>> kv : this.getMap().entrySet()) {
			if (kv.getValue().size() > 0) {
				String add = String.format("%2s%-22s%8s%15s\n", "" + kv.getKey(), " | " + kv.getValue().peek().getName(), "" + nf.format( (double)(kv.getValue().peek().getPrice()) / 100), "INVENTORY: " + kv.getValue().size() );
				stringList.add(add);
			} else {
				stringList.add("" + kv.getKey() + "\t***ITEM SOLD OUT***\n");
			}
		}

		Collections.sort(stringList);
		for (String c : stringList) {
			stringToReturn += c;
		}

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

}
