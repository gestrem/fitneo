package core;

public class Product {
	private String productTypeName; 
	private int productPrice; 
	private int availableQuantity; 
	private int discountMember; 
	private int category; 
	private int id_product;
	private int id_seller;
	

	
	
	public Product(String productTypeName, int productPrice,int availableQuantity,int discountMember,int category, int id_product, int id_seller){	
		this.productTypeName= productTypeName;
		this.productPrice= productPrice;
		this.availableQuantity = availableQuantity;
		this.discountMember = discountMember;
		this.category = category;
		this.id_product = id_product;
		this.id_seller = id_seller;
	}
	public Product(String productTypeName, int productPrice,int availableQuantity,int discountMember,int category, int id_seller){	
		this.productTypeName= productTypeName;
		this.productPrice= productPrice;
		this.availableQuantity = availableQuantity;
		this.discountMember = discountMember;
		this.category = category;
		this.id_seller = id_seller;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getDiscountMember() {
		return discountMember;
	}
	public void setDiscountMember(int discountMember) {
		this.discountMember = discountMember;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String toString(){
		return productTypeName;
	}
	public int getId_seller() {
		return id_seller;
	}
	public void setId_seller(int id_seller) {
		this.id_seller = id_seller;
	}
}
