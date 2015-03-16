package core;

import persist.PersistKit;

public abstract class Order {
	private int orderId; 
	private Product[] productList; 
	
	private static Order order = null;
	
	public Order(){	
	}

}
