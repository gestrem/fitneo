package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Product;

public class ProductJDBC extends Product{
	
	private JdbcConnection jdbc = null;

	public ProductJDBC(){
		jdbc = new JdbcConnection();
	}
	
}