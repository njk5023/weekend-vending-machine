package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class FeedMoney {
	
	private double balance = 0;
	private Date currentDate;
	private 	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa");

	
	
	public double getBalance() {
		return this.balance;
	}
	
	public void balanceZero() {
		this.balance = 0;
	}
	
	public void addMoney() {
		//NEED TO CHECK IF LOG EXISTS IN THIS FUNCTION, AND IF NOT CREATE IT
		
	String path = "log.txt";

	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	System.out.print("Current Money Provided: " + this.getBalance());
	System.out.println("How many dollars to add? ");
	double dollarsInput = Double.parseDouble(input.nextLine());
	this.balance += dollarsInput;
	System.out.print("Current Money Provided: " + this.getBalance());

	currentDate = new Date();
	String dateToStr = format.format(currentDate);
	
	try(FileWriter fw = new FileWriter(path, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(dateToStr + "\tFEED MONEY: " + dollarsInput + "\t" + this.getBalance());
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}


	}
	
	public void giveChange() {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		double change = this.getBalance();
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
		
		currentDate = new Date();
		String dateToStr = format.format(currentDate);
		
		System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.");
		this.balanceZero();
		
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
	
	public static void main(String[] args) {
		FeedMoney andy = new FeedMoney();
		andy.addMoney();
		andy.giveChange();
		System.out.print("balance is now" + andy.getBalance());
	}
	
	
}
