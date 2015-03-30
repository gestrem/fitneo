package core;

import java.util.ArrayList;

import persist.PersistKit;
/**
 * 
 * @author Florent
 *
 */
public abstract class ListNotification {

	private static ListNotification mylistnotification = null;
	
	private ArrayList<Notification> listNotification = new ArrayList<Notification>(); 
	
	public ArrayList<Notification> getListNotification() {
		return listNotification;
	}

	public void setListNotification(ArrayList<Notification> listNotification) {
		this.listNotification = listNotification;
	}
	
	/**
	 * Methode add, ajoute une notification dans la liste des notifications
	 * @param notif la notification a ajouter
	 */
    public void add(Notification notif) {
        
    	listNotification.add(notif);
    }

    /**
     * Methode getInstance, renvoi une instance de ListNotification
     * @param persistType le type de persistance
     * @return mylistnotification, une instance de ListNotification du type de persistance choisi
     */
	public static ListNotification getInstance(int persistType){
		if (mylistnotification == null)
			mylistnotification = PersistKit.createKit(persistType).createListNotification();
		return mylistnotification;
	}
	
	/**
	 * Methode load, charge toutes les notification d'un user
	 * @param idUser l'id de l'utilisateur
	 */
	public abstract void load(int idUser);
	
	/**
	 * Methode setRead, update une notification pour dire qu'elle a ete lue
	 * @param idNotif l'id de la notification
	 */
	public abstract void setRead(int idNotif);
	
	/**
	 * Methode nbNewNotification, renvoi le nombre de notif non lue
	 * @param idUser l'id de l'utilisateur
	 * @return le nombre de nouvelles notifications
	 */
	public abstract String nbNewNotification(int idUser);
	
	/**
	 * Methode sendWelcomeNotification, envoi une notification de bienvenue
	 * @param mail, le mail de l'user
	 */
	public abstract void sendWelcomeNotification(String mail);
}
