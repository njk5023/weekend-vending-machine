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
	Stack<Item> testStack = new Stack <Item>();
	Stack<Item> testStack2 = new Stack <Item>();	
	Item Snickers = new Item("Snickers", 125, "Candy");
	Item Ruffles = new Item("Ruffles", 175, "Chip");
	
	
	@Before
	public void setUp() {
		test = new MachineStocker();
		
	}
	
	@Test
	public void restockmachineTest() {
		
		Assert.assertTrue(test.getMap().isEmpty());
		testMap.put(key1, testStack);
		testMap.put(key2, testStack2);
		test.reStockMachine(testMap);
		Assert.assertFalse(test.getMap().isEmpty());
	}
	
	@Test
	public void getItemsRemainingTest() {
		testStack.push(Snickers);
		testStack.push(Snickers);
		testStack.push(Snickers);
		testStack.push(Snickers);
		testStack.push(Snickers);
		
		testMap.put(key1, testStack);
		
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
		testStack.push(Snickers);
		testStack.push(Snickers);
		testStack.push(Snickers);
		testStack.push(Snickers);
		testStack.push(Snickers);
		
		test.reStockMachine(testMap);
		
		testMap.put(key1, testStack);
		Assert.assertEquals(Snickers, test.dispense(key1));
	}
}
