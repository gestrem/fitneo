package persist;

import java.sql.ResultSet;
import java.util.ArrayList;

import core.Basket;
import core.ListBasket;
import core.Product;

/**
 * Class ListBasketJDBC.java
 * @author Florent Guillaume
 */
public class ListBasketJDBC extends ListBasket{
	
	private JdbcConnection jdbc = null;

	public ListBasketJDBC(){
		jdbc = new JdbcConnection();
	}

	/**
	 * Methode loadMainBasket, charge le panier principal (panier courant) de l'utlisateur
	 * @param idUser, id de l'utilisateur
	 */
	@Override
	public void loadMainBasket(int idUser) {
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			Basket basket=null;
			String query = "SELECT idBasket, idUser, active_basket FROM basket WHERE active_basket=true AND idUser="+idUser;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				basket = new Basket(rs.getInt("idBasket"), rs.getInt("idUser"), rs.getBoolean("active_basket"), loadProducts(rs.getInt("idBasket"))); 	
			}
			this.setMainBasket(basket);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();		
	}

	/**
	 * Methode loadOrders, charge les commandes passees par un utilisateur (panier inactifs)
	 * @param idUser, id de l'utilisateur
	 */
	@Override
	public void loadOrders(int idUser) {
		jdbc.openConnection();
		ResultSet rs = null;
		ArrayList<Basket> listBasket = new ArrayList<Basket>();
		try{		
			String query = "SELECT idBasket, idUser, active_basket FROM basket WHERE active_basket=false AND idUser="+idUser;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listBasket.add(new Basket(rs.getInt("idBasket"), rs.getInt("idUser"), rs.getBoolean("active_basket"), loadProducts(rs.getInt("idBasket")))); 	
			}
			this.setOrders(listBasket);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();		
	}
	
	/**
	 * Methode loadProducts, charge les produits d'un panier
	 * @param idBasket, l'id du panier
	 * @return listProducts, la liste des produits du panier
	 */
	public ArrayList<Product> loadProducts(int idBasket) {
		jdbc.openConnection();
		ResultSet rs = null;
		ArrayList<Product> listProducts = new ArrayList<Product>();
		try{
			String query = "SELECT ProductType.*, CommandLine.quantity FROM CommandLine, ProductType WHERE CommandLine.id_producttype=ProductType.id_producttype AND id_basket="+idBasket;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listProducts.add(new Product(rs.getString("productTypeName"), rs.getInt("productPrice"), rs.getInt("quantity"), rs.getInt("DiscountMember"), rs.getInt("id_category"), rs.getInt("id_producttype"), rs.getInt("seller"))); 	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listProducts;
	}
	
	/**
	 * Methode getPrice, calcule le montant d'un panier
	 * @param idBasket, l'id du panier
	 * @return totalPrice, le montant total d'un panier
	 */
	public int getPrice (int idBasket){
		jdbc.openConnection();
		ResultSet rs = null;
		int totalPrice = 0;
		try{
			String query = "SELECT ProductType.*, CommandLine.quantity FROM CommandLine, ProductType WHERE CommandLine.id_producttype=ProductType.id_producttype AND id_basket="+idBasket;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				totalPrice += rs.getInt("quantity")*rs.getInt("productPrice");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return totalPrice;
	}
	

	@Override
	/**
	 * Methode confirmOrder, la methode valide un panier. Elle change l'etat du panier actif en un panier inactif(commande)
	 * Elle cree ensuite un nouveau panier actif vide
	 * @param idUser, l'i de l'utilisateur
	 * @param idBasket, l'id du panier
	 */
	public void confirmOrder(int idUser, int idBasket) {
		jdbc.openConnection();
		
		try{
			String query = "UPDATE basket SET active_basket=false WHERE idBasket ="+idBasket;
			jdbc.executeRequest(query);
			String query2 = "INSERT INTO basket(idUser,active_basket) VALUES("+idUser+", true)";
			jdbc.executeRequest(query2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();	
	}
	
	/**
	 * Methode insertProduct, ajoute un produit dans le panier actif
	 * @param p, le produit a ajouter dans le panier
	 * @param quantity, la quantite ajoutee pour ce produit
	 */
	public void insertProduct(Product p, int quantity){
		jdbc.openConnection();	
		try{
			String query = "INSERT INTO CommandLine VALUES("+p.getId_product()+","+this.getMainBasket().getIdBasket()+","+quantity+")";
			jdbc.executeRequest(query);
			int Newquantity = p.getAvailableQuantity()-quantity;
			String query2 = "UPDATE ProductType SET availableProductQuantity="+Newquantity+" WHERE id_producttype="+p.getId_product();
			jdbc.executeRequest(query2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();	
	}
	
	/**
	 * Methode deleteProduct, enleve un produit du panier actif
	 * @param p, le produit a enlever du panier
	 */
	public void deleteProduct(Product p){
		jdbc.openConnection();	
		try{
			String query = "DELETE FROM CommandLine WHERE id_producttype="+p.getId_product()+" AND id_basket="+this.getMainBasket().getIdBasket();
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();
	}
}