package persist;

import core.Basket;

public class BasketJDBC extends Basket{
	
	private JdbcConnection jdbc = null;

	public BasketJDBC(){
		jdbc = new JdbcConnection();
	}
	
}