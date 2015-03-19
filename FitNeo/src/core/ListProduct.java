package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class ListProduct {

	protected static ListProduct listProduct = null;
	
	private ArrayList <Product> listAllProduct = new ArrayList<Product>();
	
	public ArrayList<Product> getListAllProduct() {
		return listAllProduct;
	}

	public ListProduct(){
		
	}
	
	public void add(Product prod){
		listAllProduct.add(prod);
	}
	
	public abstract void getAllProduct();
	
	public static ListProduct getInstance(int persistType){
		if (listProduct == null)
			listProduct = PersistKit.createKit(persistType).createListProduct();
		return listProduct;
	}
	public void setListProduct(ArrayList<Product> listProduct){
		this.listAllProduct= listProduct;
	}
}
