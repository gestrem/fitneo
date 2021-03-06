package core;

import java.util.ArrayList;
/**
 * 
 * @author Florent
 *
 */
public class BasketFacade {
	private ListBasket basket;
	
	public BasketFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		basket = ListBasket.getInstance(persistType);
	}
	
	public void loadMainBasket(int idUser){
		basket.loadMainBasket(idUser);
	}
	
	public void loadOrders(int idUser){
		basket.loadOrders(idUser);
	}
	
	public void confirmOrder(int idUser, int idBasket){
		basket.confirmOrder(idUser, idBasket);
	}
	
	public Basket getMainBasket(){
		return basket.getMainBasket();
	}
	
	public ArrayList<Basket> getOrders() {
		return basket.getOrders();
	}

	public void deleteProduct(Product p){
		basket.deleteProduct(p);
	}

	public void insertProduct(Product p, int quantity){
		basket.insertProduct(p, quantity);
	}
}
