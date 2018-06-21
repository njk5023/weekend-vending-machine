package com.techelevator;

import java.util.Map;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	

	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		String path = "vendingmachine.csv";
		Map <String, Item> ourMap = InputFile.restockMachine(path);
		
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for(Map.Entry<String, Item> kv  : ourMap.entrySet()) {
					System.out.println(kv.getKey() + " " + kv.getValue().getName() + " " + kv.getValue().getPrice() + " " + kv.getValue().getType() + " " + kv.getValue().getInventory());
				}
				// display vending machine items MAKE THIS PRETTY LATER
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if(choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.println("Please enter dollar amount.");
						
					}
				}

				
				// do purchase
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
