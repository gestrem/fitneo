package core;

public class CategoryProductFacade {
	private ListCategory listcat;
	
	public CategoryProductFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		listcat = ListCategory.getInstance(persistType);
	}
}
