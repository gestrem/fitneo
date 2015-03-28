package core;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryProductFacade {
	private ListCategory listcat;
	
	public CategoryProductFacade(int persistType){
		//On crée une room du type de persistance choisi
		listcat = ListCategory.getInstance(persistType);
	}
	
	public boolean confirmCreationCategory(String category, int idParent){
		return listcat.confirmCreationCategory(category, idParent);
	}
	public ArrayList<CategoryProduct> getAllCategoriesFacade(){
		return this.listcat.getListAllCategories();
		}
	public void loadListCategories(){
		listcat.getAllCategories();
	}
	

}
