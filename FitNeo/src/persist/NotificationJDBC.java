package persist;

import core.Notification;

public class NotificationJDBC extends Notification{
	
	private JdbcConnection jdbc = null;

	public NotificationJDBC(){
		jdbc = new JdbcConnection();
	}
	
}