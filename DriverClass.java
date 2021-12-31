package com.greatlearning.main;

import java.util.Arrays;
import java.util.Scanner;

import com.greatlearning.services.Count;
import com.greatlearning.services.LinearSearch;
import com.greatlearning.services.MergeSort;

public class DriverClass {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		LinearSearch linearSearch = new LinearSearch();
		Count stockStatusCount = new Count(); 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the No. of Companies");
		int N = scanner.nextInt();
		
		double[] stockPrice = new double[N];
		boolean[] stockPriceStatus = new boolean[N];
		for(int i=0; i<N; i++) {
			System.out.println("Enter current stock price of the company "+(i+1));
			stockPrice[i] = scanner.nextDouble();
			
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			stockPriceStatus[i] = scanner.nextBoolean();
		}
		
		int choice;
		do {
			displayMenu();
			choice = scanner.nextInt();
			switch(choice) {
				case 1:	System.out.println("Company Stock prices in ascending order");
						mergeSort.sort(stockPrice, 0, stockPrice.length-1, 'a');
						outputArray(stockPrice);
						break;
				case 2:	System.out.println("Company Stock prices in descending order");
						mergeSort.sort(stockPrice, 0, stockPrice.length-1, 'd');
						outputArray(stockPrice);						
						break;
				case 3:	System.out.println("Total No. of companies for which Stock prices rose today");
						int stockRaiseCount = stockStatusCount.count(stockPriceStatus, true);
						System.out.println(stockRaiseCount);
						break;
				case 4:	System.out.println("Total No. of companies for which Stock prices declined today");
						int stockDeclineCount = stockStatusCount.count(stockPriceStatus, false);
						System.out.println(stockDeclineCount);				
						break;
				case 5:	System.out.println("Searching specific Stock price");
						System.out.println("Enter the key value");
						double key = scanner.nextDouble();
						int position = linearSearch.search(stockPrice, key, stockPrice.length-1);
						if(position == -1) {
							System.out.println("Stock value is not present");
						}else {
							System.out.println("Stock value is present");
						}
						break;
				case 0:	System.out.println("0 pressed to exit");
						System.exit(0);
				default:
						System.out.println("Invalid option");
			}
		}while(choice != 0);		

		scanner.close();
	}

	private static void outputArray(double[] stockPrice) {
		System.out.println(Arrays.toString(stockPrice));
	}

	private static void displayMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. Press 0 to exit");
		System.out.println("-----------------------------------------------");
	}

}
