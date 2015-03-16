package core;

import persist.PersistKit;

public abstract class Basket {
	private Product[] listProducts; 
	
	private static Basket basket = null;
	
	Basket(){
		
	}
	
	public static Basket getInstance(int persistType){
		if (basket == null)
			basket = PersistKit.createKit(persistType).createBasket();
		return basket;
	}

}
