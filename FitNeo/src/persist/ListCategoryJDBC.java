package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.CategoryProduct;
import core.ListCategory;

public class ListCategoryJDBC extends ListCategory {
	private JdbcConnection jdbc = null;

	public ListCategoryJDBC(){
		jdbc = new JdbcConnection();
	}
	
	public void getAllCategories(){
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			ArrayList<CategoryProduct> listAllCategories = new ArrayList<CategoryProduct>();	
			String query = "SELECT * FROM CategoryProduct";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
            	listAllCategories.add(new CategoryProduct(rs.getInt("id_category"), rs.getString("categoryLabel"), rs.getInt("id_super_category"))); 
            }
		
		this.setListCategory(listAllCategories);
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}

}
