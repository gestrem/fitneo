package core;

import java.util.ArrayList;
import persist.PersistKit;

public abstract class ListBasket {

	private static ListBasket myListBasket = null;
	
	private Basket mainBasket = null;
	private ArrayList<Basket> orders = new ArrayList<Basket>(); 

	public static ListBasket getInstance(int persistType){
		if (myListBasket == null)
			myListBasket = PersistKit.createKit(persistType).createListBasket();
		return myListBasket;
	}
	
	public abstract void loadMainBAsket(int idUser);
	public abstract void loadOrders(int idUser);
	public abstract void confirmOrder(int idUser);

	public Basket getMainBasket() {
		return mainBasket;
	}

	public void setMainBasket(Basket mainBasket) {
		this.mainBasket = mainBasket;
	}

	public ArrayList<Basket> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Basket> orders) {
		this.orders = orders;
	}
}