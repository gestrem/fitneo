package core;

public class ProductFacade {
	private Product product;
	
	public ProductFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		product = Product.getInstance(persistType);
	}
}
