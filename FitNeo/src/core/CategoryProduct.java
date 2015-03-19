package core;

public class CategoryProduct {

	private String categoryLabel; 
	private int categoryId; 
	private int superCategoryId;
		
	public CategoryProduct( int aCategoryId,String 	aCategoryName, int aSubCategoryId){	
		this.categoryLabel = aCategoryName;  
		this.categoryId = aCategoryId; 
		this.superCategoryId = aSubCategoryId; 
	}
	
	public String getCategoryName() {
		return categoryLabel;
	}

	public void setCategoryName(String categoryName) {
		this.categoryLabel = categoryName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	public int getSubCategoryId() {
		return superCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.superCategoryId = subCategoryId;
	}
		
}
