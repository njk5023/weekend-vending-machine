package com.techelevator;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class MoneyHandlerTest {
	
	MoneyHandler test;
	Item testItem;
	
	@Before
	public void setup() {
		test = new MoneyHandler();
		testItem = new Item("Ruffles", 1.35, "Chips");

	}
	
	@Test
	public void get_balance_test() {
		Assert.assertEquals(0,  test.getBalance(), 0.0);
	}
	
	@Test
	public void add_money_test() {
		test.addMoney(10);
		Assert.assertEquals(10,  test.getBalance(), 0.0);
	}
	
	@Test
	public void pay_for_item_test() {
		test.addMoney(10);
		test.payForItem(testItem);
		Assert.assertEquals(8.65,  test.getBalance(), 0.001);
		test.payForItem(testItem);
		Assert.assertEquals(7.30,  test.getBalance(), 0.001);
		test.payForItem(testItem);
		Assert.assertEquals(5.95,  test.getBalance(), 0.001);		
	}
	
	@Test
	public void give_change_test() {
		test.addMoney(10);
		test.payForItem(testItem);
		String changeMessage = test.giveChange();
		System.out.println(changeMessage);
		
		Assert.assertEquals("Your change is 34 quarters, 1 dimes, and 1 nickels.", changeMessage);
		Assert.assertEquals("Your change is 0 quarters, 0 dimes, and 0 nickels.", test.giveChange());
		
	}

}
