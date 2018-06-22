package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class FileIOTest {

	String restockPath;
	String logPath;
	String reportPath;
	
	private Date currentDate;
	private 	SimpleDateFormat format;
	String dateToStr;
	
	FileIO test;
	
	@Before
	public void setUp() {
		restockPath = "vendingmachine.csv";
		logPath = "log.txt";
		reportPath = "report.txt";
		
		currentDate = new Date();
		format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa");
		dateToStr = format.format(currentDate);
		
		test = new FileIO();
	}
	
	@Test
	public void restock_machine_test() {
		
		Map <String, Stack<Item>> testMap = new HashMap <String, Stack<Item>>();		
		testMap = test.restockMachine(restockPath);
		
		for(Map.Entry<String, Stack<Item>> kv  : testMap.entrySet()) {
			System.out.println(kv.getKey() + " " + kv.getValue().peek());
		}
		
		
		Assert.assertEquals("Potato Crisps", testMap.get("A1").peek().getName());
		Assert.assertEquals("Mountain Melter", testMap.get("C3").peek().getName());
		Assert.assertEquals("Candy", testMap.get("B4").peek().getType());
		Assert.assertEquals("Gum", testMap.get("D2").peek().getType());
		Assert.assertEquals(0.75, testMap.get("D3").peek().getPrice(), .001);
		Assert.assertEquals(3.65, testMap.get("A4").peek().getPrice(), .001);
		
	}
	
	@Test
	public void add_money_log_test() {
		int dollars = 5;
		double balance = 0;
		test.addMoneyLog(dollars, balance);
		
	}
	
	@Test
	public void dispense_log_test() {
		Item testItem = new Item("Dr. Salt", 1.50, "Drink");
		String key = "C2";
		double balance = 20;
		test.dispenseLog(testItem, key, balance);
		
	}
	
	@Test
	public void give_change_log_test() {
		double balance = 20;
		test.giveChangeLog(balance);
		
	}
}
