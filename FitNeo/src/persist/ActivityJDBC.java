package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Activity;

public class ActivityJDBC extends Activity{
	
	private JdbcConnection jdbc = null;

	public ActivityJDBC(){
		jdbc = new JdbcConnection();
	}
	
}