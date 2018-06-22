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
	public void restockmachineTest() {
		
		Assert.assertNull(testMap); //failing but is empty
		
		test.reStockMachine(testMap);
		
		Assert.assertNotNull(testMap);
	
	}
	
	@Test
	public void getItemsRemainingTest() {
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		
		testMap.put(key1, item);
		
		test.reStockMachine(testMap);
		
		Assert.assertEquals(5, test.getItemsRemaining(key1));
		test.dispense(key1);
		Assert.assertEquals(4, test.getItemsRemaining(key1));
		test.dispense(key1);
		Assert.assertEquals(3, test.getItemsRemaining(key1));
		test.dispense(key1);
		Assert.assertEquals(2, test.getItemsRemaining(key1));
		test.dispense(key1);
		Assert.assertEquals(1, test.getItemsRemaining(key1));
		test.dispense(key1);
		Assert.assertEquals(0, test.getItemsRemaining(key1));
		
	}
	@Test
	public void dispenseTest() {
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		item.push(Snickers);
		
		test.reStockMachine(testMap);
		
		testMap.put(key1, item);
		Assert.assertEquals(Snickers, test.dispense(key1));
	}
}
