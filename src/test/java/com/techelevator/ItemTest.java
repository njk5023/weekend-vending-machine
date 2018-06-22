package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class ItemTest {
	
	Item test;
	String name = "Ruffles";
	double price = 1.25;
	String type = "Chips";

	
	@Before
	public void setup() {
		this.test = new Item(name, price, type);
	}
	
	@Test
	public void constructor_test() {
		Assert.assertEquals(name, test.getName());
		Assert.assertEquals(price, test.getPrice(), 0.0);
		Assert.assertEquals(type, test.getType());
	}
	
	@Test
	public void consume_test() {
		Item chips = new Item(name, price, "Chips");
		Item candy = new Item(name, price, "Candy");
		Item drink = new Item(name, price, "Drink");
		Item gum = new Item(name, price, "Gum");
		Item mystery = new Item(name, price, "unknown type");
				
		Assert.assertEquals("Crunch Crunch, Yum!", chips.getConsumeMessage());
		Assert.assertEquals("Munch Munch, Yum!", candy.getConsumeMessage());
		Assert.assertEquals("Glug Glug, Yum!", drink.getConsumeMessage());
		Assert.assertEquals("Chew Chew, Yum!", gum.getConsumeMessage());
		Assert.assertEquals("I don't know what this is, but it's tasty.", mystery.getConsumeMessage());
	}

}
