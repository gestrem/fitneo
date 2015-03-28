package core;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductFacade {
	private ListProduct listproduct;
	
	public ProductFacade(int persistType){
		//On crée une listProduct du type de persistance choisi
		listproduct = ListProduct.getInstance(persistType);
	}
	
	public void createProductFacade(Product aProduct) throws SQLException{
			listproduct.createProduct(aProduct);
			}
	
	public void updateProductFacade(String productName, int productPrice, int availableQuantity, int discountMember, int category, int id_product, int id_seller ) throws SQLException{
			listproduct.updateProduct(productName, productPrice, availableQuantity, discountMember, category, id_product, id_seller);
			}
	
	public void deleteProductFacade(int id_product ) throws SQLException{
			listproduct.deleteListProduct(id_product);
			}
	public ArrayList<Product> getListAllProductFacade() {
		return listproduct.getListAllProduct();
	}
	
	public void getAllProductByCategoryFacade(int aCatId){
			 listproduct.getAllProductByCategory(aCatId);
			}
	
	public void getAllProductFacade(){
		 	listproduct.getAllProduct();
		}
}