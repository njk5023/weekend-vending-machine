package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class FeedMoney {
	/*
	
	private double balance = 0;
	
	//current date object and format object; create own class or with log class?
	private Date currentDate = new Date();
	private 	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa");
	//dateToStr holding current date in specified time and date format
	String dateToStr = format.format(currentDate);
	
	public double getBalance() {
		return this.balance;
	}
	
	//setting balance to zero
	public void balanceZero() {
		this.balance = 0;
	}
	
	//method called when Feed Money option selected. adds money to current balance and loop back to purchase menu.
	public void addMoney() {
	
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	System.out.println("Current Money Provided: " + this.getBalance());
	System.out.println("How many dollars to add? ");
	double dollarsInput = Double.parseDouble(input.nextLine());
	//adding user input to balance
	this.balance += dollarsInput;
	System.out.println("Current Money Provided: " + this.getBalance());

	//appending text to file
	//create FileWriter object, initialize w/ text file > 
	//create BufferedWriter object, initialize w/ FileWriter var >
	//create PrintWriter object, initialize w/ BufferedWriter var
	//NEED TO CHECK IF LOG EXISTS IN THIS FUNCTION, AND IF NOT CREATE IT
	//might not be possible to create log class with each method printing something different?
	String path = "log.txt";
	try(FileWriter fw = new FileWriter(path, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		//continuous printing to log.txt file
		    out.println(dateToStr + "\tFEED MONEY: " + dollarsInput + "\t" + this.getBalance());
		} catch (IOException e) {
			System.out.println("Input/output exception error");
		}
	}
	
	
	//method called when Finish Transaction option selected. provides output of Q, D, N.
	public void giveChange() {
		//initialize change var
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		//change to return to user
		double change = this.getBalance();
		//while loop to return change in least amount of coin
		while (change >= 0.25) {
			quarters++;
			change -= 0.25;
		}
		while (change >= 0.10) {
			dimes++;
			change -= 0.10;
		}
		while (change >= 0.05) {
			nickels++;
			change -= 0.05;
		}
		
		System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.");
		this.balanceZero();
					
		//Appending Text to File
		//NEED TO CHECK IF LOG EXISTS
		//might not be possible to create log class with each method printing something different?
		String path = "log.txt";
		try(FileWriter fw = new FileWriter(path, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(dateToStr + "\tGIVE CHANGE: " + (quarters*0.25 + dimes*0.10 + nickels*0.05) + "\t" + this.getBalance());
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	//testing methods in FeedMoney class
	public static void main(String[] args) {
		FeedMoney andy = new FeedMoney();
		andy.addMoney();
		andy.giveChange();
		System.out.print("balance is now" + andy.getBalance());
	}
	
	//EXTRA COMMENTS TO DELETE IN MERGE
	 * */
}
