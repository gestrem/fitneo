package core;

import java.util.ArrayList;

import persist.PersistKit;

public class Event {
	
	private String eventDate; 
	private String eventName; 
	private Float eventPrice; 
	private int eventRoom; 
	private int eventActivity; 
	private int eventParticipant; 
	private User[] eventMembers = null; 
	
	private static Event event = null;
	private ArrayList<Event> listEvent = null;  
	
	public Event(){	
	}
	
	public Event(String aEventDate, String aEventName,Float aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant){
		this.eventDate = aEventDate; 
		this.eventName = aEventName; 
		this.eventPrice = aEventPrice;
		this.eventRoom = aEventRoom; 
		this.eventActivity = aEventActivity; 
		this.eventParticipant = aEventParticipant; 
	
	}
	
	
	

}
