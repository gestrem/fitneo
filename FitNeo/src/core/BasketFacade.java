package core;

import java.util.ArrayList;

public class BasketFacade {
	private ListBasket basket;
	
	public BasketFacade(int persistType){
		//On crée une room du type de persistance choisi
		basket = ListBasket.getInstance(persistType);
	}
	
	public void loadMainBasket(int idUser){
		basket.loadMainBasket(idUser);
	}
	
	public void loadOrders(int idUser){
		basket.loadOrders(idUser);
	}
	
	public void confirmOrder(int idUser){
		basket.confirmOrder(idUser);
	}
	
	public Basket getMainBasket(){
		return basket.getMainBasket();
	}
	
	public ArrayList<Basket> getOrders() {
		return basket.getOrders();
	}
/*
	public int getBasketPrice() {
		return basket.getBasketPrice();
	}*/
}
