package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		MachineStocker ms = new MachineStocker();
		MoneyHandler mh = new MoneyHandler();
		FileIO io = new FileIO();
		Scanner input = new Scanner(System.in);
		String userInput = "";

		String restockPath = "vendingmachine.csv";
		ms.reStockMachine(io.restockMachine(restockPath));
		String orderedMenu;
		ArrayList<Item> itemsBought = new ArrayList<Item>();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				orderedMenu = ms.getOrderedMenu();
				System.out.print(orderedMenu);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					System.out.println("\nCurrent Money Provided: " + mh.getBalance());
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.println("Please enter dollar amount.");
						userInput = input.nextLine();

						try {
							int dollars = Integer.parseInt(userInput);
							if (dollars > 0) {
								mh.addMoney(dollars);
								io.addMoneyLog(dollars, mh.getBalance());
							} else {
								System.out.println("INVALID ENTRY: Please enter a whole dollar amount.");
							}
						} catch (NumberFormatException e) {
							System.out.println("INVALID ENTRY: Please enter a whole dollar amount.");
						}
					} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						System.out.println("Please enter key to vending machine item desired (e.g. A1, D3).");
						userInput = input.nextLine();
						if (!ms.getMap().containsKey(userInput)) {
							System.out.println("INVALID ENTRY: Key does not exist.");
						} else if (ms.getMap().get(userInput).isEmpty()) {
							System.out.println("INVALID ENTRY: Item is sold out.");
						} else {
							itemsBought.add(ms.dispense(userInput));
							io.dispenseLog(itemsBought.get(itemsBought.size() -1), userInput, mh.getBalance());
							mh.payForItem(itemsBought.get(itemsBought.size() - 1));
							System.out.println("Item purchased: " + itemsBought.get(itemsBought.size() -1).getName());
						}
					} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						for (Item item : itemsBought) {
							System.out.println(item.getConsumeMessage());
						}
						io.giveChangeLog(mh.getBalance());
						System.out.println(mh.giveChange());						
					}

				}

				// do purchase
			}
		}
	}

	// main program
	public static void main(String[] args) {
		// menu object, primarily displays option and records user input
		Menu menu = new Menu(System.in, System.out);
		// vendingMachine object initialized with Menu Object
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}
}
