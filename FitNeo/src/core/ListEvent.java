package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class ListEvent {

	protected static ListEvent listEvent = null; 
	
	private ArrayList<Event> listAllEvents = new ArrayList<Event>(); 

	public ListEvent(){
		
	}
	
	public void add(Event cat){
		listAllEvents.add(cat);
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
}
