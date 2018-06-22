package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	//tried to create separate log class
	//may not make sense to do so, each method is printing out a separate log input
	//if else statement in log class to log when it recognizes a class was called?
	
	//have if else statement to check for file existence
	//seems unnecessary, could just be something to do in JUnit instead
	
	//current date object and format object; create own class or with log class?
		private Date currentDate = new Date();
		private 	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa");
	//dateToStr holding current date in specified time and date format
		String dateToStr = format.format(currentDate);
		
	public void Log() {
	
	String path = "log.txt";
	
	File inputFile = new File(path);
	
	if (inputFile.exists() == false) { // checks for the existence of a file
		System.out.println(path + " does not exist");
		System.exit(1); // Ends the program
	}
	else if (inputFile.isFile() == false) {
		System.out.println(path + " is not a file");
		System.exit(1); // Ends the program
	}
	else if (inputFile.exists() == true) {
		System.out.println(path + " exists");
	}
	
	//appending text to file
	//path parameter is text file's path, 
	//true parameter instructing to append to file
	try(FileWriter fw = new FileWriter(path, true); 
	//necessary for performance, maintains a buffer
			BufferedWriter bw = new BufferedWriter(fw);
	//provides more flexibility to format what is to be appended
			PrintWriter out = new PrintWriter(bw))
		{
		//continuous printing to log.txt file
		    out.println(dateToStr + "\tFEED MONEY: " + "dollarsInput" + "\t" + "this.getBalance()");
		} catch (IOException e) {
			System.out.println("Input/output exception error");
		}
	}
	
	public static void main(String[] args) {
		Log andy = new Log();
		andy.Log();
	}
}
