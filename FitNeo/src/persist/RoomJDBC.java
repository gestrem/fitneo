package persist;

import core.Room;

public class RoomJDBC extends Room{
	
	private JdbcConnection jdbc = null;

	public RoomJDBC(){
		jdbc = new JdbcConnection();
	}
	
}