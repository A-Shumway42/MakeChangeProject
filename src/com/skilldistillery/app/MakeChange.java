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
		
	//	The user is prompted asking for the price of the item.
		System.out.print("Enter the cost of items: ");
		int cost = convertDoubleToIntCurrency(kb.nextDouble());
		
	//	The user is then prompted asking how much money was tendered by the customer.
		System.out.print("Enter the amount tendered: ");
		int tender = convertDoubleToIntCurrency(kb.nextDouble());
		
		kb.close();
		
		int changeBack = tender - cost;
	
		if (cost > tender) {
			System.out.println("Insufficient funds tendered! Please give correct amount. ");
		} else if (cost == tender) {
			System.out.println("Exact cost applied. No change due. Thank You! ");
		} else {
			while (changeBack != 0) {
				if ( changeBack >= 2000) {
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
			printChange( cent, cent5, cent10, cent25,
					dollar, dollar5, dollar10, dollar20);
			
		} // closing else statement
		
		
		
		
		
	} // closing main method
	
	public static void printChange( int cent, int cent5, int cent10, int cent25,
			                        int dollar, int dollar5, int dollar10, int dollar20) {
		System.out.print("Change due: ");
		
		if (dollar20 > 1) {
			System.out.print(dollar20 + " twenty dollar bills, ");
		} else if ( dollar20 == 1) {
			System.out.print(dollar20 + " twenty dollar bill, ");
		} 	
		if (dollar10 > 1) {
			System.out.print(dollar10 + " ten dollar bills, ");
		} else if ( dollar10 == 1) {
			System.out.print(dollar10 + " ten dollar bill, ");
		}
		if (dollar5 > 1) {
			System.out.print(dollar5 + " five dollar bills, ");
		} else if (dollar5 == 1) {
			System.out.print(dollar5 + " five dollar bill, ");
		}
		if (dollar > 1) {
			System.out.print(dollar + " one dollar bills, ");
		} else if (dollar == 1) {
			System.out.print(dollar + " one dollar bill, ");
		}
		if (cent25 > 1) {
			System.out.print(cent25 + " quarters, ");
		} else if (cent25 == 1) {
			System.out.print(cent25 + " quarter, ");
		}
		if (cent10 > 1) {
			System.out.print(cent10 + " dimes, ");
		} else if (cent10 == 1) {
			System.out.print(cent10 + " dime, ");
		}
		if (cent5 > 1) {
			System.out.print(cent5 + " nickels, ");
		} else if (cent5 == 1) {
			System.out.print(cent5 + " nickel, ");
		}
		if (cent > 1) {
			System.out.print(cent + " pennies. ");
		} else if (cent == 1) {
			System.out.print(cent + " penny. ");
		}
	}	
	
	public static int convertDoubleToIntCurrency(double money) {
		int dollars = (int)money;
		double cents = (money - dollars);
		return ((int)((cents * 100) + 0.5)) + dollars * 100;
		
	}

}
