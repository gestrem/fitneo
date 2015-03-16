package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.AccessoryType;

public class AccessoryJDBC extends AccessoryType{
	
	private JdbcConnection jdbc = null;

	public AccessoryJDBC(){
		jdbc = new JdbcConnection();
	}
	
}