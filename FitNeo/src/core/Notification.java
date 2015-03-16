package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class Notification {

	private String message;
	private User receiver; 
	private User sender;
	private Boolean isRead; 
	private Boolean isDemand; 
	
	/* isRead renvoie vrai si la notification est lue
	 * is Demand renvoie vrai si la notification correspond a une demande a valider */
	
	private static Notification[] notification = null;
	private ArrayList<Notification> listNotification = null; 
	
	public Notification(){	
	}
	
	
	public static Notification getInstance(int persistType){
		if (notification == null)
			notification = PersistKit.createKit(persistType).createNotification();
		return notification;
	}
}
