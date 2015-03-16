package core;

import persist.PersistKit;

public abstract class CategoryProduct {

	private String categoryName; 
	
	private static CategoryProduct category = null;
	
	public CategoryProduct(){	
	}
	
	public static CategoryProduct getInstance(int persistType){
		if (category == null)
			category = PersistKit.createKit(persistType).createCategory();
		return category;
	}

}
