package core;

/**
 * 
 * @author Maite
 *
 */
public class CategoryProduct {
	
	private int categoryId;
	private String categoryLabel;  
	private CategoryProduct superCategory = null;
	
	public CategoryProduct(String aCategoryName){	
		this.categoryLabel = aCategoryName;  
	}
	
	public CategoryProduct(int aCategoryInt,String aCategoryName){	
		this.categoryId = aCategoryInt; 
		this.categoryLabel = aCategoryName;  
	}
	
		
	public CategoryProduct(int aCategoryInt, String aCategoryName, CategoryProduct aSuperCategory){	
		this.categoryId = aCategoryInt; 
		this.categoryLabel = aCategoryName;  
		this.superCategory = aSuperCategory; 
	}
	
	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryLabel;
	}

	public void setCategoryName(String categoryName) {
		this.categoryLabel = categoryName;
	}
		
	public CategoryProduct getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(CategoryProduct superCategory) {
		this.superCategory = superCategory;
	}
	
	public String toString(){
		return this.categoryLabel;
	}
		
	public int getSuperCategoryId(){
		return this.superCategory.categoryId;
	}
	
	public String getSuperCategoryName(){
		return this.superCategory.categoryLabel;
	}


	
}
