package core;

public class Product {
	private String productTypeName; 
	private int productPrice; 
	private int availableQuantity; 
	private int discountMember; 
	private int category; 
	
	public Product(String productTypeName, int productPrice,int availableQuantity,int discountMember,int category){	
		this.productTypeName= productTypeName;
		this.productPrice= productPrice;
		this.availableQuantity = availableQuantity;
		this.discountMember = discountMember;
		this.category = category;
	}
	public String toString(){
		return productTypeName;
	}
}
