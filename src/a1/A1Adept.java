package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Creates two arrays, one for the item names and one for item values
		//Value of item at itemNames[i] equals itemValues[i]
		String[] itemNames = new String[scan.nextInt()];
		double[] itemValues = new double[itemNames.length];
		
		//Fill the arrays with the item names and their corresponding prices
		for(int i = 0; i < itemNames.length; i++) {
			
			itemNames[i] = scan.next();
			itemValues[i] = scan.nextDouble();
			
		}
		
		//Records the names of the customer who spent the most and the customer who spent the least (so far)
		String bigCustomer = "";
		String smallCustomer = "";
		
		//Records the amounts that bigCustomer and smallCustomer spent (so far)
		double bigAmount = 0;
		double smallAmount = Double.MAX_VALUE;
		
		//Records the number of customers and the total amount spent by all customers
		int numberOfCustomers = scan.nextInt();
		double totalAmount = 0;
		
		//Every iteration calculates the total amount spent by one customer and compares that
		//value to the current bigAmount and smallAmount values
		for(int i = 0; i < numberOfCustomers; i++) {
			
			//Records the customer's name
			String customerName = scan.next() + " " + scan.next();
			
			//Records the total amount this customer spent
			double subtotal = 0;
			
			//Represents the number of items this customer bought
			int loop1 = scan.nextInt();
			
			//Every iteration calculates the cost of all of a specific item and adds that to the subtotal
			for(int j = 0; j < loop1; j++) {
				
				//Records the number of this specific item bought and its name
				int numberItems = scan.nextInt();
				String itemName = scan.next();
				
				//Every iteration checks the current item's name against the array containing all the 
				//items' names. If there's a match, it finds the corresponding price of the item, 
				//calculates the cost of all of this specific item, and adds that cost to the subtotal
				for(int k = 0; k < itemNames.length; k++) {
					
					if(itemName.equals(itemNames[k])) {
						
						subtotal += numberItems * itemValues[k];
						break;
						
					}
					
				}
				
			}
			
			//If the subtotal is greater than the current maximum amount, then replace the 
			//maximum amount with this subtotal and update the name as well
			if(subtotal > bigAmount) {
				
				bigAmount = subtotal;
				bigCustomer = customerName;
				
			}
			
			//If the subtotal is less than the current minimum amount, then replace the 
			//minimum amount with this subtotal and update the name as well
			if(subtotal < smallAmount) {
				
				smallAmount = subtotal;
				smallCustomer = customerName;
				
			}
			
			//Add the subtotal to the total amount spent by all customers
			totalAmount += subtotal;
			
		}
		
		//Prints the name and amount spent of the biggest and smallest spender, as well as the average amount spent
		System.out.println("Biggest: " + bigCustomer + " (" + String.format("%.2f", bigAmount) + ")");
		System.out.println("Smallest: " + smallCustomer + " (" + String.format("%.2f", smallAmount) + ")");
		System.out.println("Average: " + String.format("%.2f", totalAmount / numberOfCustomers));
		
		scan.close();
		
	}
}