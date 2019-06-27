package edu.albany.fp;

import java.util.ArrayList;
import java.util.*;

public class JerseyStore{
	//HashMap
	Map<Jerseys, Double> prices;
	Map<Jerseys,Integer> archive;
	Map<List<Jerseys>, Double> deals;
	
	public JerseyStore() {
		prices = new HashMap<Jerseys,Double>();
		archive = new HashMap<Jerseys, Integer>();
		deals = new HashMap<List<Jerseys>, Double>();
	}
	
	public void add(Jerseys j, int num, Double price) {
		if(archive.containsKey(j)) {
				archive.put(j, num + archive.get(j));
		} else {
			prices.put(j, price);
			archive.put(j, num);
			}
		}
	
	void addSale(List<Jerseys> combo, Double deal) {
		if(deals.containsKey(combo)) {
			deals.put(combo, deal)	;
			
		} else {
			deals.put(combo, deal);
			}
		}
	
	int inStock(Jerseys j) {
		return archive.get(j);
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	Double sale(List<Jerseys> saleOrder) throws InsufficientStockException, JerseyNotAvailableException{
		double saleTotal = 0;
		Map<Jerseys, Integer> saleCount = new HashMap<Jerseys, Integer>();

		for(Jerseys j: saleOrder) {

			if (!archive.containsKey(j)) { 
				throw new InsufficientStockException(j, 0, 1, "Error: Insufficient stock");
			}

			// If any item not in prices map, throw NoSuchJersey
			if (!prices.containsKey(j)) {
				throw new JerseyNotAvailableException(j, "Error: No such clothing item found");
			}

			// If the cart doesn't have Jersey, add to cart after checking the 2 conditions
			if (!saleCount.containsKey(j)) {
				saleCount.put(j, 1);
			} else {
				saleCount.put(j, saleCount.containsKey(j) ? saleCount.get(j) + 1 : 1);

			}
		}

		// If store doesn't have enough of that item, throw InsufficientStockException
		for (Jerseys j : saleCount.keySet()) { 
			if (saleCount.get(j) > archive.get(j)) {
				throw new InsufficientStockException(j, archive.get(j), saleCount.get(j), "Error: Insufficient stock");
			}
		}

		// verifying all Jerseys have a price and are in stock
		// a) Reduce level of inventory of that piece by 1
		// b) Add the price of the clothing to a sum

		ArrayList<Jerseys> JerseysInBag = new ArrayList<Jerseys>();
		for(Jerseys j : saleOrder) {
			archive.put(j, archive.containsKey(j) ? archive.get(j) - 1 : 1);
			saleTotal = saleTotal + prices.get(j); // Adds price to sum
			JerseysInBag.add(j); 
		}

		// Checks for all possible combinations of clothing items in cart and applies discounts
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Combination checkBag = new Combination(JerseysInBag); 
		JerseysInBag = checkBag.nextComb();
		for(Jerseys j : JerseysInBag) {
			if (deals.containsKey(j)) {
				saleTotal = saleTotal - deals.get(j);
			}
		}

		return saleTotal;
	}
}

class InsufficientStockException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Jerseys lostJersey;
	int jerseysLeft; 
	int jerseysWanted;

	InsufficientStockException(Jerseys lostJersey, int jerseysLeft, int jerseysWanted, String errorMessage) {
		super(errorMessage); //superclass to display error message
		this.lostJersey = lostJersey;
		this.jerseysLeft = jerseysLeft;
		this.jerseysWanted = jerseysWanted;
	}
}

class JerseyNotAvailableException extends Exception { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Jerseys itemSought; 

	JerseyNotAvailableException(Jerseys itemSought, String errorMessage) {
		super(errorMessage);
		this.itemSought = itemSought;
	}
	
	

}










