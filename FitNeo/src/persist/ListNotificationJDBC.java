package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.ListNotification;
import core.Notification;

public class ListNotificationJDBC extends ListNotification{
	
	private JdbcConnection jdbc = null;

	public ListNotificationJDBC(){
		jdbc = new JdbcConnection();
	}
	
	public void load(int idUser){
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			ArrayList<Notification> listNotification = new ArrayList<Notification>();
			String query = "SELECT notification.*, mainuser.userFirstName FROM notification, mainuser WHERE sender=mainuser.idUser AND receiver ="+idUser;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listNotification.add(new Notification(rs.getString("userFirstName"), rs.getString("message"), rs.getBoolean("isread"), rs.getBoolean("isCreationDemand"))); 	
            }
			this.setListNotification(listNotification);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
}