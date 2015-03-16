package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class Event {
	private String eventDate; 
	private String eventName; 
	private int eventPrice; 
	private Activity eventActivity; 
	private User eventManager; 
	private User eventParticipant; 
	private User[] eventMembers; 
	
	private static Event event = null;
	private ArrayList<Event> listEvent = null;  
	
	public Event(){	
	}
	
	
	public static Event getInstance(int persistType){
		if (event == null)
			event = PersistKit.createKit(persistType).createEvent();
		return event;
	}
	
	

}
