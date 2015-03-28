package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class ListNotification {

	private static ListNotification mylistnotification = null;
	
	private ArrayList<Notification> listNotification = new ArrayList<Notification>(); 
	
	public ArrayList<Notification> getListNotification() {
		return listNotification;
	}

	public void setListNotification(ArrayList<Notification> listNotification) {
		this.listNotification = listNotification;
	}
	
    public void add(Notification notif) {
        
    	listNotification.add(notif);
    }

	public static ListNotification getInstance(int persistType){
		if (mylistnotification == null)
			mylistnotification = PersistKit.createKit(persistType).createListNotification();
		return mylistnotification;
	}
	
	public abstract void load(int idUser);
	public abstract void setRead(int idNotif);
	public abstract int nbNewNotification(int idUser);
}
