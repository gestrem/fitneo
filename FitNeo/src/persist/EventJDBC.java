package persist;

import core.Event;

public class EventJDBC extends Event{
	
	private JdbcConnection jdbc = null;

	public EventJDBC(){
		jdbc = new JdbcConnection();
	}
	
}