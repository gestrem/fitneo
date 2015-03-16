package core;

public class BasketFacade {
	private Basket basket;
	
	public BasketFacade(int persistType){
		//On crée une room du type de persistance choisi
		basket = Basket.getInstance(persistType);
	}
}
