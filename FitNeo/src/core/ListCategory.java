package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;

public abstract class ListCategory {
	
	protected static ListCategory listCategory = null; 
	
	private ArrayList<CategoryProduct> listAllCategories = new ArrayList<CategoryProduct>(); 
	
	public ListCategory(){
		
	}
	
	public void add(CategoryProduct cat){
		listAllCategories.add(cat);
	}
	
	public void setListCategory(ArrayList<CategoryProduct> aListAllCategories){
		this.listAllCategories = aListAllCategories; 
	}
	
	public ArrayList<CategoryProduct> getListAllCategories() {
		return listAllCategories;
	}
	
	public boolean confirmCreationCategory(String category, int idParent){
		if(verifyCategoryExist(category)){
			if(idParent == 0)
				insertCategoryWithNameJDBC(category);
			else
				insertCategoryWithNameAndSuperCategoryJDBC(category, idParent);
			return true;
		}
		else
			return false;
			
	}
	
	public static ListCategory getInstance (int persistType){
		
		if (listCategory == null){
			listCategory = PersistKit.createKit(persistType).createListCategory(); 
		}
		
		return listCategory;
	}
	
	public abstract void getAllCategories();
	
	
	public abstract void insertCategoryWithNameJDBC(String cat) ; 
	public abstract void insertCategoryWithNameAndSuperCategoryJDBC(String catName, int catParent);
	public abstract void updateCategoryWithNameJDBC(int idCat, String catName) throws SQLException;
	public abstract void updateCategoryWithSuperCategoryJDBC(int idCat,  int catIdSuperCategory) throws SQLException; 
	public abstract void updateCategoryWithNameAndSuperCategoryJDBC(int idCat, String catName,  int catIdSuperCategory) throws SQLException;
	public abstract void deleteCategoryJDBC(int idCat) throws SQLException; 
	public abstract boolean verifyCategoryExist(String nameCat);
	
	
	public CategoryProduct searchWithId(int idcat){
		CategoryProduct cat = null; 
		Iterator<CategoryProduct> it =  this.getListAllCategories().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			cat=it.next();
			if(cat.getCategoryId() == idcat){
				find=true;
			}
		}
		return cat; 
	}
	
}
