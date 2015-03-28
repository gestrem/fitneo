package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;

public abstract class ListProduct {

	protected static ListProduct listProduct = null;
	
	private ArrayList <Product> listAllProduct = new ArrayList<Product>();
	


	public ListProduct(){
		
	}
	
	public void add(Product prod){
		listAllProduct.add(prod);
	}	

	public ArrayList<Product> getListAllProduct() {
		return listAllProduct;
	}
	
	
	

	public void setListProduct(ArrayList<Product> listProduct){
		this.listAllProduct= listProduct;
	}
	
	public static ListProduct getInstance(int persistType){
		if (listProduct == null)
			listProduct = PersistKit.createKit(persistType).createListProduct();
		return listProduct;
	}
	
	public abstract void getAllProduct();
	public abstract void getAllProductByCategory(int idCategory);
	
	public void createProduct(Product aProduct)throws SQLException{
		createProductJDBC(aProduct);
	}
	public abstract void createProductJDBC(Product aProduct)throws SQLException;

	public void updateProduct(String productName, int productPrice, int availableQuantity, int discountMember, int category, int id_product,int id_seller )throws SQLException{
		updateProductJDBC( productName,productPrice,availableQuantity,discountMember,category,id_product,id_seller);
	}
	public abstract void updateProductJDBC(String productName, int productPrice, int availableQuantity, int discountMember, int category, int id_product, int id_seller)throws SQLException;
	
	public void deleteListProduct(int aProductId)throws SQLException{
		deleteListProductJDBC(aProductId);
		}
	public abstract void deleteListProductJDBC(int aProductId)throws SQLException;
	
	public Product searchWithId(int idprod){
		Product prod = null; 
		Iterator<Product> it =  this.getListAllProduct().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			if(it.next().getId_product() == idprod){
				find=true;
				prod = ((Product) it);
			}
		}
		return prod; 
	}
}

