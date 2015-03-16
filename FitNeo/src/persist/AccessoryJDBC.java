package persist;

import core.AccessoryType;

public class AccessoryJDBC extends AccessoryType{
	
	private JdbcConnection jdbc = null;

	public AccessoryJDBC(){
		jdbc = new JdbcConnection();
	}
	
}