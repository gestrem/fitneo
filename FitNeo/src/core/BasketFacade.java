package core;

public class BasketFacade {
	private Basket basket;
	
	public BasketFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		basket = Basket.getInstance(persistType);
	}
}
