package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Basket;

public class BasketJDBC extends Basket{
	
	private JdbcConnection jdbc = null;

	public BasketJDBC(){
		jdbc = new JdbcConnection();
	}
	
}