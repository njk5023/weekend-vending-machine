package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputFile  {

	
//public static void main (String[] args) {
//	
//	
//	String path = "vendingmachine.csv";
//	Map <String, Item> ourMap = restockMachine(path);
//	for(Map.Entry<String, Item> kv  : ourMap.entrySet()) {
//		System.out.println(kv.getKey() + " " + kv.getValue().getName() + " " + kv.getValue().getPrice() + " " + kv.getValue().getType() + " " + kv.getValue().getInventory());
//	}
//}
	 
	public static Map <String, Item> restockMachine (String path) {	
		//returning file info into map
		Map <String, Item> mapToReturn = new HashMap<String, Item>();
		//file object is holding file input in input variable
		File input = new File(path);
		//scanner object to run through file input
		try (Scanner fileScanner = new Scanner(input)) {			
			//looping through each line of txt file
			while(fileScanner.hasNextLine()) {
				//line variable holding each line of txt file
				String line = fileScanner.nextLine(); 
				//splitting each string of txt file into element variable
				String[] element = line.split("\\|");
				//item object returning hold array holding elements value
				Item hold = new Item (element[1], Double.parseDouble(element[2]), element [3]);
				//adding 1st element as key to map and hold array as value
				mapToReturn.put(element[0], hold);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found!");			
			e.printStackTrace();
		}		
		//return mapToReturn when restockMachine Map is called
		return mapToReturn;	
	}
	
	
	
}
