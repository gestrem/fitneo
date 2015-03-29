package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;
/**
 * 
 * @author arnaud jacquez
 *
 */
public abstract class ListEvent {

	protected static ListEvent listEvent = null; 
	
	private ArrayList<Event> listAllEvents = new ArrayList<Event>(); 

	public ListEvent(){
		
	}
	/**
	 * add permet d ajouter un evenement a la liste d evenement
	 * @param event
	 */
	public void add(Event event){
		listAllEvents.add(event);
	}
	
	/**
	 * getListAllEvent retourne la liste des evenements
	 * @return liste des events
	 */
	public ArrayList<Event> getListAllEvent() {
		return listAllEvents;
	}
	
	public void setListEvent(ArrayList<Event> aListEvents){
		this.listAllEvents = aListEvents; 
	}
	
	public ArrayList<Event> getListAllEvents() {
		return listAllEvents;
	}
	
	/**
	 * getInstance permet de retourner une instance de la liste d evenement en fonction du type de persistance
	 * @param persistType doit etre de type int 
	 * @return listEvent
	 */
	public static ListEvent getInstance (int persistType){
		
		if (listEvent == null){
			listEvent = PersistKit.createKit(persistType).createListEvent(); 
		}
		
		return listEvent;
	}
	
	public abstract void getAllEvents();
	
	/**
	 * createEvent permet d inserer un evenement dans la BD a partir d un object evenement en faisant appel a la methode createEventJDBC
	 * @param aEvent
	 * @throws SQLException
	 */
	public void createEvent(Event aEvent)throws SQLException{
		createEventJDBC(aEvent);
	}
	public abstract void createEventJDBC(Event aEvent)throws SQLException;
	/**
	 * updateEvent permet de mettre a jour un evenement dans la BD en faisant appel a la methode updateEventJDBC
	 * @param aEventDate doit etre de type string
	 * @param aEventName doit etre de type string
	 * @param aEventPrice doit etre de type double
	 * @param aEventRoom doit etre de type int
	 * @param aEventActivity doit etre de type int
	 * @param aEventParticipant doit etre de type int
	 * @param aEventId doit etre de type int 
	 * @throws SQLException
	 */
	public void updateEvent(String aEventDate, String aEventName,Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId)throws SQLException{
		updateEventJDBC(aEventDate, aEventName, aEventPrice, aEventRoom, aEventActivity, aEventParticipant,aEventId);
	}
	
	public abstract void updateEventJDBC( String aEventDate, String aEventName,Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId)throws SQLException;
	
	/**
	 * deleteListEvent permet de supprimer un evenement de la bd en faisant appel a la methode deleteListEventJDBC
	 * @param aEventId
	 */
	public void deleteListEvent(int aEventId){
		deleteListEventJDBC(aEventId);
		}
	
public abstract void deleteListEventJDBC(int aEventId);
	
	/**
	 * searchWithId permet de rechercher les informations relatives a un evenement dans la liste d evenement a partir de son id 
	 * @param aEventID
	 * @return l'event concerne
	 */
	public Event searchWithId(int aEventID){
		Event aEvent = null; 
		Iterator<Event> it =  this.getListAllEvents().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			if(it.next().getEventId() == aEventID){
				find=true;
				aEvent = ((Event) it);
			}
		}
		return aEvent; 
	}
}
