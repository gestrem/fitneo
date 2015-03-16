package persist;

import core.CategoryProduct;

public class CategoryJDBC extends CategoryProduct{
	
	private JdbcConnection jdbc = null;

	public CategoryJDBC(){
		jdbc = new JdbcConnection();
	}
	
}