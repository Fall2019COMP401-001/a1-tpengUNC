package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Save the int which represents the number of customers
		int loop1 = scan.nextInt();

		//Each iteration of loop prints the name and total purchases of one customer
		for(int i = 0; i < loop1; i++) {
			
			//This is the formatted name
			String name = scan.next().substring(0, 1) + ". " + scan.next() + ": ";
			
			//Total value of purchases
			double total = 0;	
			
			//Save the int which represents the number of items purchased
			int loop2 = scan.nextInt();
			
			//Each iteration of loop adds the cost of all of a particular item to "total"
			for(int j = 0; j < loop2; j++) {
				
				//Save the int which represents the number of a specific item bought
				int numberBought = scan.nextInt();
				
				//Skip the name of the item
				scan.next();
				
				//Add the subtotal to "total"
				total += numberBought * scan.nextDouble();
				
			}
			
			//Prints the formatted name and total purchases (to 2 decimal places) of one customer
			System.out.println(name + String.format("%.2f", total));
			
		}
		
		scan.close();
		
	}
}