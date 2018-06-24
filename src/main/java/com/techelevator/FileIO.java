package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class FileIO {
	
	
	//file paths vars
	String restockPath = "vendingmachine.csv";
	String logPath = "log.txt";
	String reportPath = "salesreport.txt";
	
	//date & time vars
	private Date currentDate = new Date();
	private 	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa");
	//dateToStr holding current date in specified time and date format
	String dateToStr = format.format(currentDate);
	
	NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
	
	
	public Map <String, Stack<Item>> restockMachine (String restockPath) {	
		//returning file info into map
		Map <String, Stack<Item>> mapToReturn = new HashMap<String, Stack<Item>>();
		//file object is holding file input in input variable
		File input = new File(restockPath);
		//scanner object to run through file input
		try (Scanner fileScanner = new Scanner(input)) {			
			//looping through each line of txt file
			while(fileScanner.hasNextLine()) {
				//line variable holding each line of txt file
				Stack<Item> stackToReturn = new Stack<Item>();
				String line = fileScanner.nextLine(); 
				//splitting each string of txt file into element variable
				String[] element = line.split("\\|");
				//item object returning hold array holding elements value
				Item hold = new Item (element[1], (int)((Double.parseDouble(element[2])) * 100) , element [3]);
				for(int i = 0; i < 5; i++) {
				stackToReturn.push(hold);
				}
				/*stackToReturn.push(hold);
				stackToReturn.push(hold);
				stackToReturn.push(hold);
				stackToReturn.push(hold);
				*/
				//adding 1st element as key to map and hold array as value
				mapToReturn.put(element[0], stackToReturn);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found!");			
			e.printStackTrace();
		}		
		//return mapToReturn when restockMachine Map is called
		return mapToReturn;	
	}
	
	
	public void addMoneyLog (int dollars, int balance) {
		currentDate = new Date();
		dateToStr = format.format(currentDate);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		currentDate = new Date();
		File inputFile = new File(logPath);	
		if(!inputFile.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			File newFile = new File("log.txt");			
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();
			}			
		}	 
		//appending text to file
		try(FileWriter fw = new FileWriter(logPath, true); 
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
			{
			//continuous printing to log.txt file
			String toPrint;
			toPrint = String.format("%-23s%-25s%-16s%-16s", dateToStr, "~FEED MONEY~~~~~~~~~~~~~", nf.format(dollars), nf.format((double)balance / 100));
			out.println(toPrint);
//			    out.println(dateToStr + "\t FEED MONEY:        \t " + nf.format(dollars / 100) + "\t" + nf.format(balance / 100));
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();				
			}
	}
	
	public void dispenseLog (Item item, String key, int balance) {
		currentDate = new Date();
		dateToStr = format.format(currentDate);
		File inputFile = new File(logPath);	
		if(!inputFile.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			File newFile = new File("log.txt");			
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();
			}			
		}	 
		//appending text to file
		try(FileWriter fw = new FileWriter(logPath, true); 
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
			{
			//continuous printing to log.txt file
			String toPrint;
			toPrint = String.format("%-23s%-25s%-16s%-16s", dateToStr, item.getName() + " " + key, nf.format( ((double)(balance))/100), nf.format( (double) ( balance - item.getPrice() ) / 100));
			out.println(toPrint);

//			    out.println(dateToStr + " " + item.getName() + " " + key + "\t " + nf.format( (double) (balance/100) ) + "\t" + nf.format( (double) ( balance - item.getPrice() ) / 100));
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();				
			}
	}
	
	public void giveChangeLog (int balance) {
		currentDate = new Date();
		dateToStr = format.format(currentDate);
		File inputFile = new File(logPath);	
		if(!inputFile.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			File newFile = new File("log.txt");			
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();
			}			
		}	 
		//appending text to file
		try(FileWriter fw = new FileWriter(logPath, true); 
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
			{
			//continuous printing to log.txt file
			String toPrint;
			toPrint = String.format("%-23s%-25s%-16s%-16s", dateToStr, "~GIVE CHANGE:~~~~~~~~~~~" , nf.format( ((double)(balance))/100 ), "$0.00");
			out.println(toPrint);

//			    out.println(dateToStr + "\t GIVE CHANGE:       \t" + nf.format( ((double)(balance)) / 100 ) + "\t" + "$0.00");
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();				
			}
				
	}
	
	
	
	public void salesReportFromLog () {
		Map <String, Integer> inventoryMap = new HashMap<String, Integer>();
		reportPath = "salesreport.txt";
		File outputFile = new File(reportPath);
		File inputFile = new File(logPath);

		if(!inputFile.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			File newFile = new File(logPath);
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();
			}
		}

		int totalPennies = 0;
		
		if(!outputFile.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			File newFile = new File(reportPath);
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Input/output exception error");
				e.printStackTrace();
			}
		}

		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String name = "";
				String startingBalance = "";
				String endingBalance = "";
				int price = 0;
				if (!line.contains("FEED MONEY") && !line.contains("GIVE CHANGE")) {
					String[] line2 = line.split("[AP][M]+");
					String[] line3 = line2[1].split("[A-Z][1-9]+");
					name = line3[0];
					String[] line4 = line.split("\\$+");
					startingBalance = line4[1].replaceAll("\\s", "");
					endingBalance = line4[2].replaceAll("\\s", "");
					price = (int)(Double.parseDouble(startingBalance) * 100) -
							(int)(Double.parseDouble(endingBalance) * 100);
					if (!inventoryMap.containsKey(name)) {
						inventoryMap.put(name,  1);
					} else {
						inventoryMap.put(name, inventoryMap.get(name) + 1);
					}
					totalPennies += price;
					}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oops, something went wrong trying to read the input.");
		}
		
		String lineToPrint = "";
		try(PrintWriter pw = new PrintWriter(outputFile)) {
			for (Map.Entry<String, Integer> kv : inventoryMap.entrySet()) {
				lineToPrint = kv.getKey().substring(1,  kv.getKey().length() -1) + "|" + kv.getValue();
				pw.println(lineToPrint);
			}
			lineToPrint = "\n**TOTAL SALES** " + nf.format(((double)(totalPennies)/100));
			pw.println(lineToPrint);
		} catch (FileNotFoundException e) {
			System.out.println("Input/output exception error");

		}
		
	}

	
}
