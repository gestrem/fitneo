package persist;

import java.sql.ResultSet;
import java.util.ArrayList;
import core.Basket;
import core.Product;

public class BasketJDBC extends Basket{
	
	private JdbcConnection jdbc = null;

	public BasketJDBC(){
		jdbc = new JdbcConnection();
	}

	public void loadProducts(int idBasket) {
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			ArrayList<Product> listProducts = new ArrayList<Product>();
			String query = "SELECT ProductType.* FROM CommandLine, ProductType WHERE CommandLine.id_producttype=ProductType.id_producttype AND id_basket="+idBasket;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listProducts.add(new Product(rs.getString("productTypeName"), rs.getInt("productPrice"), rs.getInt("availableProductQuantity"), rs.getInt("DiscountMember"), rs.getInt("id_category"), rs.getInt("id_producttype"), rs.getInt("seller"))); 	
			}
			this.setListProducts(listProducts);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
}