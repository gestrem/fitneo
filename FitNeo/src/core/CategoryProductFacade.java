package core;

public class CategoryProductFacade {
	private CategoryProduct cat;
	
	public CategoryProductFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		usecatr = CategoryProduct.getInstance(persistType);
	}
}
