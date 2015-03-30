package persist;

import java.sql.ResultSet;
import java.util.ArrayList;

import core.ListNotification;
import core.Notification;
/**
 * 
 * @author Florent
 *
 */
public class ListNotificationJDBC extends ListNotification{
	
	private JdbcConnection jdbc = null;

	public ListNotificationJDBC(){
		jdbc = new JdbcConnection();
	}
	
	/**
	 * Methode load, charge toutes les notification d'un utilisateur
	 * @param idUser l'id de l'utilisateur
	 */
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

	/**
	 * Methode setRead, update une notification pour dire qu'elle a ete lue
	 * @param idNotif l'id de la notification
	 */
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

	/**
	 * Methode nbNEwNotification, renvoi le nombre de notification non lue. Cette valeur est affichee dans la fenetre principale a cote du bouton
	 * @param idUser l'id de l'utilisateur
	 * @return nbNewNotif, le nombre de notification non lues
	 */
	@Override
	public String nbNewNotification(int idUser) {
		jdbc.openConnection();
		ResultSet rs = null;
		String nbNewNotif = null;
		
		try{
			
			String query = "select count(*) from notification where isRead=false and receiver="+idUser;
			jdbc.executeRequest(query);
			rs = jdbc.fetchArray();
			nbNewNotif=rs.getString("count(*)");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();
		return nbNewNotif;
	}

	@Override
	public void sendWelcomeNotification(String mail) {
		jdbc.openConnection();
		
		try{
			String query = "insert into notification(receiver, sender, isread, isCreationDemand, message, notification_date) values((select idUser from mainuser where userEmail = '"+mail+"'),4,0,0,'Welcome on Fitneo',curdate())";
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		jdbc.close();		
	}
	
	
	
}