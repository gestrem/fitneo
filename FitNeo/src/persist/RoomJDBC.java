package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Room;

public class RoomJDBC extends Room{
	
	private JdbcConnection jdbc = null;

	public RoomJDBC(){
		jdbc = new JdbcConnection();
	}
	
}