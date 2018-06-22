package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

public class MachineStockerTest {

	MachineStocker test;
	Map<String, Stack<Item>> testMap = new HashMap <String, Stack<Item>> ();
	String key1 = "A1";
	String key2 = "A2";
	Stack<Item> item = new Stack <Item>();
	Stack<Item> item2 = new Stack <Item>();	
	Item Snickers = new Item("Snickers", 1.25, "Candy");
	Item Ruffles = new Item("Ruffles", 1.75, "Chip");
	
	
	@Before
	public void setUp() {
		test = new MachineStocker();
		
	}
	
	@Test
	public void getItemsRemaining() {
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		
		testMap.put(key1, item);
		
		Assert.assertEquals(5, testMap.get(key1).size());
		testMap.get(key1).pop();
		Assert.assertEquals(4, testMap.get(key1).size());
		testMap.get(key1).pop();
		Assert.assertEquals(3, testMap.get(key1).size());
		testMap.get(key1).pop();
		Assert.assertEquals(2, testMap.get(key1).size());
		testMap.get(key1).pop();
		Assert.assertEquals(1, testMap.get(key1).size());
		testMap.get(key1).pop();
		Assert.assertEquals(0, testMap.get(key1).size());
		
	}
	@Test
	public void dispenseTest() {
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		
		testMap.put(key1, item);
		Assert.assertEquals(Snickers, test.dispense(key1));
	}
}
