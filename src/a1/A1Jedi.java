package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Create 3 arrays, one for the item names, one for number of that item bought, 
		//and one for number of people who bought that item. Elements with the same index
		//correspond to each other
		String[] itemNames = new String[scan.nextInt()];
		int[] numItems = new int[itemNames.length];
		int[] numPeople = new int[itemNames.length];
		
		//Fill the arrays with the item names
		for(int i = 0; i < itemNames.length; i++) {
					
			itemNames[i] = scan.next();
			
			//Skip the item price
			scan.next();
					
		}		
		
		//Records the number of customers
		int numCustomers = scan.nextInt();
		
		//Every iteration, adds the number of items bought by one customer to the numItems element
		//that corresponds to the correct item name in itemNames
		for(int i = 0; i < numCustomers; i++) {
			
			//Skip the first and last names
			scan.next();
			scan.next();
			
			//Keeps track of if an item in the list was bought (true if bought, false otherwise)
			boolean[] itemBought = new boolean[itemNames.length];
			
			//Records the number of items bought by this customer
			int numItemsBought = scan.nextInt();
			
			//Every iteration, adds the number of a specific item bought by this customer to 
			//the numItems element that corresponds to the item name in itemNames
			for(int j = 0; j < numItemsBought; j++) {
				
				//Records the number of the specific item bought by this customer
				int itemCount = scan.nextInt();
				
				//Records the name of this specific item
				String itemName = scan.next();
				
				//Searches for the item in itemNames, and adds the number of items bought
				//to the corresponding element in numItems, as well as increasing the 
				//number of people who bought that item by one in the corresponding 
				//element in numPeople
				for(int k = 0; k < itemNames.length; k++) {
					
					if(itemName.equals(itemNames[k])) {
						
						numItems[k] += itemCount;
						itemBought[k] = true;
						
						break;
						
					}
					
				}
				
			}
			
			//Go through the list of items that this customer bought 
			for(int l = 0; l < itemBought.length; l++) {
				
				//If the customer bought an item in the item list, then...
				if(itemBought[l]) {
					
					//Increase the number of people who bought that item by 1
					numPeople[l]++;
					
				}
				
			}
			
		}
		
		//Prints out the information for each item
		for(int i = 0; i < itemNames.length; i++) {
			
			//If nobody bought an item, the message is slightly different
			if(numPeople[i] == 0) {
				
				System.out.println("No customers bought " + itemNames[i]);
				
			}
			else {
			
				System.out.println(numPeople[i] + " customers bought " + numItems[i] + " " + itemNames[i]);
			
			}
			
		}
		
		scan.close();
		
	}
} 