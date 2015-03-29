package core;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * @author Florent
 *
 */
public class Basket {
	
	private int idBasket;
	private int idUser;
	private boolean isMainBasket;
	private ArrayList<Product> listProducts = new ArrayList<Product>(); 
	
	public Basket(int idBasket, int idUser, boolean active_basket, ArrayList<Product> listProducts){
		this.idBasket=idBasket;
		this.idUser = idUser;
		this.isMainBasket=active_basket;	
		this.listProducts=listProducts;
	}

	public int getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(int idBasket) {
		this.idBasket = idBasket;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isMainBasket() {
		return isMainBasket;
	}

	public void setMainBasket(boolean isMainBasket) {
		this.isMainBasket = isMainBasket;
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}

	/**
	 * Methode getTotalPrice, calcule le montant total du panier actif
	 * @return totalPrice, le montant total du panier actif
	 */
	public int getTotalPrice() {
		int totalPrice = 0;
		Iterator<Product> it =  this.getListProducts().iterator();	
		while ( it.hasNext()) {
			Product p = it.next();
			totalPrice += p.getProductPrice()*p.getAvailableQuantity(); 
		}
		return totalPrice;
	}

}
