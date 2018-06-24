package com.techelevator;

public class MoneyHandler {

	private int balance = 0;

	public int getBalance() {
		return this.balance;
	}

	// method called when Feed Money option selected. adds money to current balance
	// and loop back to purchase menu.
	public void addMoney(int dollars) {
		dollars *= 100;
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
		while (change >= 25) {
			quarters++;
			change -= 25;
		}
		while (change >= 10) {
			dimes++;
			change -= 10;
		}
		while (change >= 5) {
			nickels++;
			change -= 5;
		}
		
		this.balance = 0;
		return "Your change is " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.";
	}

}
