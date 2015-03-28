package core;

import java.util.ArrayList;

public class NotificationFacade {
	private ListNotification listnotification;
	
	public NotificationFacade(int persistType){
		//On crée une room du type de persistance choisi
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
	
	public int nbNewNotification(int idUser){
		return listnotification.nbNewNotification(idUser);
	}
}
