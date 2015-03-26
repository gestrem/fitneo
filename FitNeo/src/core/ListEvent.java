package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;

public abstract class ListEvent {

	protected static ListEvent listEvent = null; 
	
	private ArrayList<Event> listAllEvents = new ArrayList<Event>(); 

	public ListEvent(){
		
	}
	
	public void add(Event cat){
		listAllEvents.add(cat);
	}
	public ArrayList<Event> getListAllEvent() {
		return listAllEvents;
	}
	
	public void setListEvent(ArrayList<Event> aListEvents){
		this.listAllEvents = aListEvents; 
	}
	
	public ArrayList<Event> getListAllEvents() {
		return listAllEvents;
	}
	
	public static ListEvent getInstance (int persistType){
		
		if (listEvent == null){
			listEvent = PersistKit.createKit(persistType).createListEvent(); 
		}
		
		return listEvent;
	}
	
public abstract void getAllEvents();
	
	public void createEvent(Event aEvent)throws SQLException{
		createEventJDBC(aEvent);
	}
	public abstract void createEventJDBC(Event aEvent)throws SQLException;

	public void updateEvent(String aEventDate, String aEventName,Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId)throws SQLException{
		updateEventJDBC(aEventDate, aEventName, aEventPrice, aEventRoom, aEventActivity, aEventParticipant,aEventId);
	}
	
	public abstract void updateEventJDBC( String aEventDate, String aEventName,Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId)throws SQLException;
	
	public void deleteListEvent(int aEventId){
		deleteListEventJDBC(aEventId);
		}
	public abstract void deleteListEventJDBC(int aEventId);
	
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
