package core;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryProductFacade {
	private ListCategory listcat;
	
	public CategoryProductFacade(int persistType){
		//On cree une room du type de persistance choisi
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
	
	public void createCategoryFacade(String catName, int catParentId) throws SQLException{
		listcat.insertCategoryWithNameAndSuperCategoryJDBC(catName, catParentId);
	}
	public void updateCategoryFacade(int idAct, String actName, int catParentId) throws SQLException{
		listcat.updateCategoryWithNameAndSuperCategoryJDBC(idAct, actName,catParentId);
	}
	public void deleteCategory(int catId)throws SQLException{
		listcat.deleteCategoryJDBC(catId); 
	}	
	
	public String searchName (int catId) {
		return listcat.searchNameWithId(catId); 
	}
	
	public boolean verifyCategoryExist(String nameCat){
		return listcat.verifyCategoryExist(nameCat); 
	}
	
	public ArrayList<String> loadCategories(){
		return listcat.getListCatNameJDBC	(); 

	}

}
