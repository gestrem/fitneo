package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Notification;

public class NotificationJDBC extends Notification{
	
	private JdbcConnection jdbc = null;

	public NotificationJDBC(){
		jdbc = new JdbcConnection();
	}
	
}