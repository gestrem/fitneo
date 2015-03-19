package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.CategoryProduct;
import core.ListProduct;
import core.Product;

public class ListProductJDBC extends ListProduct{
	
	private JdbcConnection jdbc = null;

	public ListProductJDBC(){
		jdbc = new JdbcConnection();
	}
	
	public void getAllProduct(){
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			ArrayList<Product> listProduct = new ArrayList<Product>();
			String query = "SELECT * FROM ProductType p, categoryProduct c WHERE p.id_category=c.id_category";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listProduct.add(new Product(rs.getString("productTypeName"), rs.getInt("productPrice"), rs.getInt("availableProductQuantity"), rs.getInt("DiscountMember"), rs.getInt("id_category")));
            	
            }
			this.setListProduct(listProduct);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
}