package core;

public class NotificationFacade {
	private Notification notification;
	
	public NotificationFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		notification = Notification.getInstance(persistType);
	}
}
