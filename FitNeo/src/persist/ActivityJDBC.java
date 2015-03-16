package persist;

import core.Activity;

public class ActivityJDBC extends Activity{
	
	private JdbcConnection jdbc = null;

	public ActivityJDBC(){
		jdbc = new JdbcConnection();
	}
	
}