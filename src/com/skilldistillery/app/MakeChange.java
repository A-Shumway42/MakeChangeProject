package com.skilldistillery.app;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);

		// listing tender in register
		int cent = 0;
		int cent5 = 0;
		int cent10 = 0;
		int cent25 = 0;
		int dollar = 0;
		int dollar5 = 0;
		int dollar10 = 0;
		int dollar20 = 0;

		boolean doQuit = printMenu(kb);

		if (!doQuit) {
			// The user is prompted asking for the price of the item.
			System.out.print("Enter the cost of items: ");
			int cost = convertDoubleToIntCurrency(kb.nextDouble());
			// The user is then prompted asking how much money was tendered by the customer.
			System.out.print("Enter the amount tendered: ");
			int tender = convertDoubleToIntCurrency(kb.nextDouble());
			kb.close();
			int changeBack = tender - cost;
			int changeBackCopy = changeBack;
			if (cost > tender) {
				System.out.println("Insufficient funds tendered! Sale cancelled. ");
			} else if (cost == tender) {
				System.out.println("Exact cost applied. No change due. Thank You! ");
			} else {
				while (changeBack != 0) {
					if (changeBack >= 2000) {
						dollar20++;
						changeBack -= 2000;
					} else if (changeBack >= 1000) {
						dollar10++;
						changeBack -= 1000;
					} else if (changeBack >= 500) {
						dollar5++;
						changeBack -= 500;
					} else if (changeBack >= 100) {
						dollar++;
						changeBack -= 100;
					} else if (changeBack >= 25) {
						cent25++;
						changeBack -= 25;
					} else if (changeBack >= 10) {
						cent10++;
						changeBack -= 10;
					} else if (changeBack >= 5) {
						cent5++;
						changeBack -= 5;
					} else if (changeBack >= 1) {
						cent++;
						changeBack -= 1;
					}

				} // closing while loop
				printChange(changeBackCopy, cent, cent5, cent10, cent25, dollar, dollar5, dollar10, dollar20);

			} // closing else statement
		}
		printGoodbye();
	} // closing main method

	private static void printGoodbye() {
		// TODO Auto-generated method stub
		System.out.println("End of sale. Goodbye!");
		
	}

	public static void printChange(int changeBackCopy, int cent, int cent5, int cent10, int cent25, int dollar,
			int dollar5, int dollar10, int dollar20) {
		System.out.print("Change due: ");
		while (changeBackCopy > 0) {
			if (dollar20 > 1) {
				System.out.print(dollar20 + " twenty dollar bills");
				changeBackCopy -= (2000 * dollar20);
				dollar20 = 0;
			} else if (dollar20 == 1) {
				System.out.print(dollar20 + " twenty dollar bill");
				changeBackCopy -= (2000 * dollar20);
				dollar20 = 0;
			} else if (dollar10 > 1) {
				System.out.print(dollar10 + " ten dollar bills");
				changeBackCopy -= (1000 * dollar10);
				dollar10 = 0;
			} else if (dollar10 == 1) {
				System.out.print(dollar10 + " ten dollar bill");
				changeBackCopy -= (1000 * dollar10);
				dollar10 = 0;
			} else if (dollar5 > 1) {
				System.out.print(dollar5 + " five dollar bills");
				changeBackCopy -= (500 * dollar5);
				dollar5 = 0;
			} else if (dollar5 == 1) {
				System.out.print(dollar5 + " five dollar bill");
				changeBackCopy -= (500 * dollar5);
				dollar5 = 0;
			} else if (dollar > 1) {
				System.out.print(dollar + " one dollar bills");
				changeBackCopy -= (100 * dollar);
				dollar = 0;
			} else if (dollar == 1) {
				System.out.print(dollar + " one dollar bill");
				changeBackCopy -= (100 * dollar);
				dollar = 0;
			} else if (cent25 > 1) {
				System.out.print(cent25 + " quarters");
				changeBackCopy -= (25 * cent25);
				cent25 = 0;
			} else if (cent25 == 1) {
				System.out.print(cent25 + " quarter");
				changeBackCopy -= (25 * cent25);
				cent25 = 0;
			} else if (cent10 > 1) {
				System.out.print(cent10 + " dimes");
				changeBackCopy -= (10 * cent10);
				cent10 = 0;
			} else if (cent10 == 1) {
				System.out.print(cent10 + " dime");
				changeBackCopy -= (10 * cent10);
				cent10 = 0;
			} else if (cent5 > 1) {
				System.out.print(cent5 + " nickels");
				changeBackCopy -= (5 * cent5);
				cent5 = 0;
			} else if (cent5 == 1) {
				System.out.print(cent5 + " nickel");
				changeBackCopy -= (5 * cent5);
				cent5 = 0;
			} else if (cent > 1) {
				System.out.print(cent + " pennies");
				changeBackCopy -= (cent);
				cent = 0;
			} else if (cent == 1) {
				System.out.print(cent + " penny");
				changeBackCopy -= (cent);
				cent = 0;
			}
			System.out.print(changeBackCopy > 0 ? ", " : ". \n");
		}
	}
	// solution to rounding error

	public static int convertDoubleToIntCurrency(double money) {
		int dollars = (int) money;
		double cents = (money - dollars);
		return ((int) ((cents * 100) + 0.5)) + dollars * 100;

	}

	public static boolean printMenu(Scanner kb) {

		System.out.println("*****************");
		System.out.println("*_____Menu______*");
		System.out.println("* 1: SALE       *");
		System.out.println("* 2: RETURN     *");
		System.out.println("* 3: LOG OUT    *");
		System.out.println("*****************");

		boolean keepGoing = true;
		while (keepGoing) {
			int choice = kb.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Welcome!");
				return false;
			case 2:
				System.out.println("Unauthorized access! Supervisor code required. ");
				break;
			case 3:
				System.out.println("Logging out! Goodbye! ");
				return true;
			default:
				System.out.println("Invalid option! Please select numbers displayed. ");
				break;

			}
		}
		return true;
	}

}
