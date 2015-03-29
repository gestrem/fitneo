package persist;

import java.sql.ResultSet;
import java.util.ArrayList;

import core.Basket;
import core.ListBasket;
import core.Product;

public class ListBasketJDBC extends ListBasket{
	
	private JdbcConnection jdbc = null;

	public ListBasketJDBC(){
		jdbc = new JdbcConnection();
	}

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