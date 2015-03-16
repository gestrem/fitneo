package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class Product {
	private String productTypeName; 
	private int productPrice; 
	private int availableQuantity; 
	private int discountMember; 
	private CategoryProduct category; 
	
	private static Product product = null;
	private ArrayList<Product> listProduct = null; 
	
	public Product(){	
	}
	
	
	public static Product getInstance(int persistType){
		if (product == null)
			product = PersistKit.createKit(persistType).createProduct();
		return product;
	}

}
