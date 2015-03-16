package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Event;

public class EventJDBC extends Event{
	
	private JdbcConnection jdbc = null;

	public EventJDBC(){
		jdbc = new JdbcConnection();
	}
	
}