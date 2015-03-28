package persist;

import java.sql.ResultSet;
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
			String query = "SELECT notification.*, DAY(notification_date) as jour, MONTH(notification_date) as mois, YEAR(notification_date) as an, mainuser.userFirstName, mainuser.userLastName FROM notification, mainuser WHERE sender=mainuser.idUser AND receiver ="+idUser;
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				if(!rs.getBoolean("isCreationDemand"))
					listNotification.add(new Notification(rs.getInt("idNotification"),rs.getString("userFirstName")+" "+rs.getString("userLastName"), rs.getString("message"), rs.getBoolean("isread"), rs.getBoolean("isCreationDemand"), rs.getString("jour")+"/"+rs.getString("mois")+"/"+rs.getString("an"))); 	
				else
					listNotification.add(new Notification(rs.getInt("idNotification"),rs.getString("userFirstName")+" "+rs.getString("userLastName"), rs.getString("message"), rs.getBoolean("isread"), rs.getBoolean("isCreationDemand"), rs.getString("jour")+"/"+rs.getString("mois")+"/"+rs.getString("an"), rs.getString("categoryName"), rs.getInt("idCategoryParent")));
			}
			this.setListNotification(listNotification);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}

	@Override
	public void setRead(int idNotif) {
		jdbc.openConnection();
		
		try{
			String query = "UPDATE notification SET isRead=true WHERE idNotification ="+idNotif;
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();
		
	}

	@Override
	public int nbNewNotification(int idUser) {
		jdbc.openConnection();
		ResultSet rs = null;
		int nbNewNotif=0;
		
		try{
			
			String query = "select count(*) from notification where isRead=false and receiver="+idUser;
			jdbc.executeRequest(query);
			rs = jdbc.fetchArray();
			nbNewNotif=rs.getInt("count(*)");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();
		return nbNewNotif;
	}
	
}