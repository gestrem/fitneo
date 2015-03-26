package core;

import java.sql.SQLException;

public class CategoryProductFacade {
	private ListCategory listcat;
	
	public CategoryProductFacade(int persistType){
		//On crée une room du type de persistance choisi
		listcat = ListCategory.getInstance(persistType);
	}
	
	public boolean confirmCreationCategory(String category, int idParent){
		return listcat.confirmCreationCategory(category, idParent);
	}
}
