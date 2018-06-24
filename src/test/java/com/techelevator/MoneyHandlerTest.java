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
		testItem = new Item("Ruffles", 135, "Chips");

	}
	
	@Test
	public void get_balance_test() {
		Assert.assertEquals(0,  test.getBalance());
	}
	
	@Test
	public void add_money_test() {
		test.addMoney(10);
		Assert.assertEquals(1000,  test.getBalance());
		test.addMoney(150000);
		Assert.assertEquals(15001000, test.getBalance());
		test.addMoney(-10);
		Assert.assertEquals(15001000, test.getBalance());
	}
	
	@Test
	public void pay_for_item_test() {
		test.addMoney(10);
		test.payForItem(testItem);
		Assert.assertEquals(865,  test.getBalance());
		test.payForItem(testItem);
		Assert.assertEquals(730,  test.getBalance());
		test.payForItem(testItem);
		Assert.assertEquals(595,  test.getBalance());		
		
		testItem = new Item("Super Ruffles", 600, "Chips");
		Assert.assertEquals(595,  test.getBalance());
	}
	
	@Test
	public void give_change_test() {
		test.addMoney(10);
		test.payForItem(testItem);
		String changeMessage = test.giveChange();
		
		Assert.assertEquals("Your change is 34 quarters, 1 dimes, and 1 nickels.", changeMessage);
		Assert.assertEquals("Your change is 0 quarters, 0 dimes, and 0 nickels.", test.giveChange());
		
		testItem = new Item("Super Ruffles", 580, "Chips");
		test.addMoney(6);
		test.payForItem(testItem);
		String changeMessage2 = test.giveChange();
		Assert.assertEquals("Your change is 0 quarters, 2 dimes, and 0 nickels.", changeMessage2);
		Assert.assertEquals("Your change is 0 quarters, 0 dimes, and 0 nickels.", test.giveChange());
		
		
	}

}
