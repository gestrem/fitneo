package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;
/**
 * 
 * @author arnaud jacquez
 *
 */
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
	
	/**
	 * getAllProduct permet de charger dans une liste de produits tous les produits
	 */
	public abstract void getAllProduct();
	
	/**
	 * getAllProductByCategory permet de charger dans une liste de produits tous les produits d'une categorie
	 * @param idCategory doit etre de type int 
	 */
	public abstract void getAllProductByCategory(int idCategory);
	
	/**
	 * CreateProduct d'inserer un Produit dans la base de donnees en appelant la methode createProductJDBC
	 * @param aProduct represente l'objet java produit qui va etre inserer dans la BD
	 */
	public void createProduct(Product aProduct)throws SQLException{
		createProductJDBC(aProduct);
	}
	
	public abstract void createProductJDBC(Product aProduct)throws SQLException;
	
	/**
	 * updateProduct permet de mettre ˆ jour un produit dans la BD en appelant la methode updateProductJDBC
	 * @param productName doit etre de type string
	 * @param productPrice doit etre de type int
	 * @param availableQuantity doit etre de type int
	 * @param discountMember doit etre de type int 
	 * @param category doit etre de type int (id de la category du produit)
	 * @param id_product doit etre de type int (id du produit)
	 * @param id_seller doit etre de type int (id du revendeur)
	 */
	public void updateProduct(String productName, int productPrice, int availableQuantity, int discountMember, int category, int id_product,int id_seller )throws SQLException{
		updateProductJDBC( productName,productPrice,availableQuantity,discountMember,category,id_product,id_seller);
	}
	
	public abstract void updateProductJDBC(String productName, int productPrice, int availableQuantity, int discountMember, int category, int id_product, int id_seller)throws SQLException;
	
	/**
	 * deleteProduct permet de supprimer un produit de la BD en appelant la methode deleteProductJDBC
	 * @param aProductId doit etre de type int 
	 */
	public void deleteListProduct(int aProductId)throws SQLException{
		deleteListProductJDBC(aProductId);
		}
	public abstract void deleteListProductJDBC(int aProductId)throws SQLException;
	
	/**
	 * serachWithId permet de rechercher les informations relatives a un produit ˆ partir de son identifiant dans la liste de produits
	 * @param idprod doit etre de type int
	 */
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

