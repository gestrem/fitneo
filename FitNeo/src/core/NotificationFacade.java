package core;

public class NotificationFacade {
	private Notification notification;
	
	public NotificationFacade(int persistType){
		//On crée une room du type de persistance choisi
		notification = Notification.getInstance(persistType);
	}
}
