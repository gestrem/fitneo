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
	
	public static ListCategory getInstance (int persistType){
		
		if (listCategory == null){
			listCategory = PersistKit.createKit(persistType).createListCategory(); 
		}
		
		return listCategory;
	}
	
	public abstract void getAllCategories();
	
	public abstract void insertCategoryWithNameJDBC(String cat) throws SQLException; 
	public abstract void insertCategoryWithNameAndSuperCategoryJDBC(String catName, int catParent) throws SQLException;
	public abstract void updateCategoryWithNameJDBC(int idCat, String catName) throws SQLException;
	public abstract void updateCategoryWithSuperCategoryJDBC(int idCat,  int catIdSuperCategory) throws SQLException; 
	public abstract void updateCategoryWithNameAndSuperCategoryJDBC(int idCat, String catName,  int catIdSuperCategory) throws SQLException;
	public abstract void deleteCategoryJDBC(int idCat) throws SQLException; 
	
	
	
	public CategoryProduct searchWithId(int idcat){
		CategoryProduct cat = null; 
		Iterator<CategoryProduct> it =  this.getListAllCategories().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			if(it.next().getCategoryId() == idcat){
				find=true;
				cat = ((CategoryProduct) it);
			}
		}
		return cat; 
	}
	
}
