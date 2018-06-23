package com.techelevator;

public class MoneyHandler {

	private double balance = 0;

	public double getBalance() {
		return this.balance;
	}

	// method called when Feed Money option selected. adds money to current balance
	// and loop back to purchase menu.
	public void addMoney(int dollars) {
		this.balance += dollars;
	}

	public void payForItem(Item item) {
		if (!(this.balance > item.getPrice())){
			this.balance = this.getBalance();			
		}else {
			this.balance -= item.getPrice();
		}
	}

	// method called when Finish Transaction option selected. provides output of Q,
	// D, N.
	public String giveChange() {
		// initialize change var
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		// change to return to user
		double change = this.getBalance();
		// while loop to return change in least amount of coin			
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
		
		this.balance = 0;
		return "Your change is " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.";
	}

}
