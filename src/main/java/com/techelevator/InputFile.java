package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputFile  {

	
public static void main (String[] args) {
	
	
	String path = "vendingmachine.csv";
	Map <String, Item> ourMap = makeMap(path);
	for(Map.Entry<String, Item> kv  : ourMap.entrySet()) {
		System.out.println(kv.getKey() + " " + kv.getValue().getName() + " " + kv.getValue().getPrice() + " " + kv.getValue().getType());
	}
}
	 
	public static Map <String, Item> makeMap (String path) {	
		Map <String, Item> mapToReturn = new HashMap<String, Item>();
		
		File input = new File(path);
		
		try (Scanner fileScanner = new Scanner(input)) {			
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] element = line.split("\\|");
				Item hold = new Item (element[1], Double.parseDouble(element[2]), element [3]);
				mapToReturn.put(element[0], hold);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found!");			
			e.printStackTrace();
		}		
		return mapToReturn;	
	}
	
	
	
}
