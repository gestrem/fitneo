package core;

public class CategoryProductFacade {
	private CategoryProduct cat;
	
	public CategoryProductFacade(int persistType){
		//On crée une room du type de persistance choisi
		cat = CategoryProduct.getInstance(persistType);
	}
}
