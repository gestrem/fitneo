package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.CategoryProduct;

public class CategoryJDBC extends CategoryProduct{
	
	private JdbcConnection jdbc = null;

	public CategoryJDBC(){
		jdbc = new JdbcConnection();
	}
	
}