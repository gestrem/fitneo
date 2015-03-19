package core;

import java.util.ArrayList;
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
	
}
