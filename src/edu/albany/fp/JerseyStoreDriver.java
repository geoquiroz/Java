package edu.albany.fp;
import java.util.*;


public class JerseyStoreDriver extends Jerseys{
		
	public JerseyStoreDriver(double srp, double op, JerseyType jerseyType, JerseyTeams team, JerseySize size,
			JerseyCondition cond) {
		super(srp, op, jerseyType, team, size, cond);
		
	}
		public static void main(String[] args) {
			// Testing JerseyTypeClass
			 System.out.println("TEST JerseyType.java");
			 JerseyType jerseyTypeTest = JerseyType.FOOTBALL;
			 System.out.println(jerseyTypeTest.getSport());
		

		System.out.println("Test");
		
		Jerseys yankees = new Jerseys(125.00, 100.00, JerseyType.BASEBALL, JerseyTeams.YANKEES, JerseySize.MEDIUM, JerseyCondition.NEW);
		Jerseys giants = new Jerseys(130.00, 105.00, JerseyType.FOOTBALL, JerseyTeams.GIANTS, JerseySize.LARGE, JerseyCondition.NEW);
		Jerseys knicks = new Jerseys(105.00, 85.00, JerseyType.BASKETBALL, JerseyTeams.KNICKS, JerseySize.XLARGE, JerseyCondition.GOOD);
		Jerseys rangers = new Jerseys(250.00, 200.00, JerseyType.HOCKEY, JerseyTeams.RANGERS, JerseySize.LARGE, JerseyCondition.AUTHENTIC);
			
			System.out.println("Comparing " + yankees.compareTo(giants));
			System.out.println("Comparing " + yankees.compareTo(rangers));




		System.out.println("Testing JerseyStore.java");

		JerseyStore jerseyStore = new JerseyStore(); // Create the Jersey store
		jerseyStore.add(yankees, 25, 100.00); // Add Jerseys to the store
		jerseyStore.add(giants, 30, 105.00);
		jerseyStore.add(knicks, 15, 85.00);
		jerseyStore.add(rangers, 3, 200.00); 

		// Create a discount for two Jerseys
		List<Jerseys> jerseySales = new ArrayList<Jerseys>(); 
		jerseySales.add(yankees);
		jerseySales.add(knicks);

		// Add discount 
		jerseyStore.addSale(jerseySales, 25.00); 

		// Testing inStock
		System.out.println("There are " + jerseyStore.inStock(yankees) + "yankee jerseys in stock");

		List<Jerseys> myCart = new ArrayList<Jerseys>(); // Create a cart
		myCart.add(yankees);
		myCart.add(knicks);
		myCart.add(giants);
		myCart.add(rangers);

		// Testing sale() 
		try {
			System.out.println("Your cart total was " + jerseyStore.sale(myCart)); 
		} 
		catch (InsufficientStockException insufficientStockException) {
			System.out.println("ERROR: Insufficient stock available");
		}
		catch (JerseyNotAvailableException noSuchClothingException) {
			System.out.println("ERROR: Jersey not available");
		}
	}
}
		

