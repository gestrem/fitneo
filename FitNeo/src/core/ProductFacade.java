package core;

public class ProductFacade {
	private ListProduct listproduct;
	
	public ProductFacade(int persistType){
		//On cr�e une listProduct du type de persistance choisi
		listproduct = ListProduct.getInstance(persistType);
	}
}
