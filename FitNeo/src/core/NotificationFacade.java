package core;

import java.util.ArrayList;
/**
 * 
 * @author Florent
 *
 */
public class NotificationFacade {
	private ListNotification listnotification;
	
	public NotificationFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		listnotification = ListNotification.getInstance(persistType);
	}
	
	public void load(int idUser){
		listnotification.load(idUser);
	}
	
	public ArrayList<Notification> getListNotification() {
		return listnotification.getListNotification();
	}
	
	public void setRead(int idNotif){
		listnotification.setRead(idNotif);
	}
	
	public String nbNewNotification(int idUser){
		return listnotification.nbNewNotification(idUser);
	}
	
	public void sendWelcomeNotification(String email){
		listnotification.sendWelcomeNotification(email);
	}
}
