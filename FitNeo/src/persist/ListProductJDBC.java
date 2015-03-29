package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import core.ListProduct;
import core.Product;
/**
 * 
 * @author arnaud jacquez
 *
 */
public class ListProductJDBC extends ListProduct{
	
	private JdbcConnection jdbc = null;

	public ListProductJDBC(){
		jdbc = new JdbcConnection();
	}
	
	/**
	 * getAllProduct permet de charger dans une liste de produits de tous ceux presents dans la BD
	 * @return void
	 */
	public void getAllProduct(){
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			ArrayList<Product> listProduct = new ArrayList<Product>();
			String query = "SELECT * FROM ProductType p, categoryProduct c WHERE p.id_category=c.id_category";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listProduct.add(new Product(rs.getString("productTypeName"), rs.getInt("productPrice"), rs.getInt("availableProductQuantity"), rs.getInt("DiscountMember"), rs.getInt("id_category"),rs.getInt("id_producttype"),rs.getInt("seller")));
            	
            }
			this.setListProduct(listProduct);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
	/**
	 * getAllProductByCategory permet de charger dans une liste de produits tous les produits d'une categorie
	 * @param idCategory doit etre de type int 
	 * @return void
	 */
	public void getAllProductByCategory(int idCategory){
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			ArrayList<Product> listProduct = new ArrayList<Product>();
			String query = "SELECT * FROM ProductType p, categoryProduct c WHERE p.id_category=c.id_category and p.id_category='"+idCategory+"'";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listProduct.add(new Product(rs.getString("productTypeName"), rs.getInt("productPrice"), rs.getInt("availableProductQuantity"), rs.getInt("DiscountMember"), rs.getInt("id_category"),rs.getInt("id_producttype"),rs.getInt("seller")));
            	
            }
			this.setListProduct(listProduct);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	/**
	 * CreateProductJDBC d'inserer un Produit dans la base de donnees 
	 * @param aProduct represente l'objet java produit qui va etre inserer dans la BD
	 * @return void
	 */

	public void createProductJDBC(Product aProduct) throws SQLException{
	
		jdbc.openConnection();
		
		String query = "INSERT INTO ProductType(productTypeName,productPrice,availableProductQuantity,DiscountMember,id_category, seller) values('"+aProduct.getProductTypeName()+"','"+aProduct.getProductPrice()+"','"+aProduct.getAvailableQuantity()+"','"+aProduct.getDiscountMember()+"','"+aProduct.getCategory()+"','"+aProduct.getId_seller()+"')";
		jdbc.executeRequest(query);
		jdbc.close();
	}
	
	/**
	 * updateProduct permet de mettre ˆ jour un produit dans la BD 
	 * @param productName doit etre de type string
	 * @param productPrice doit etre de type int
	 * @param availableQuantity doit etre de type int
	 * @param discountMember doit etre de type int 
	 * @param category doit etre de type int (id de la category du produit)
	 * @param id_product doit etre de type int (id du produit)
	 * @param seller doit etre de type int (id du revendeur)
	 * @return void
	 */
	public void updateProductJDBC(String productName, int productPrice, int availableQuantity, int discountMember, int category, int id_product, int id_seller) throws SQLException{
		
		jdbc.openConnection();
		
		String query = "UPDATE ProductType SET productTypeName='"+productName+"',productPrice='"+productPrice+"',availableProductQuantity='"+availableQuantity+"',DiscountMember='"+discountMember+"',seller='"+id_seller+"',id_category='"+category+"' WHERE id_producttype='"+id_product+"'";
		jdbc.executeRequest(query);
		jdbc.close();
	}
	
	/**
	 * deleteListProductJDBC permet de supprimer un produit de la BD 
	 * @param aProductId doit etre de type int 
	 * @return void
	 */
	public void deleteListProductJDBC(int aProductId) throws SQLException{
		jdbc.openConnection();
		try{
			String query ="delete from ProductType where id_producttype='"+aProductId+"'  ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
}