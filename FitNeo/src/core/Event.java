package core;

import java.util.Iterator;

public class Event {
	
	
	private int eventId;
	private String eventDate; 
	private String eventName; 
	private Double eventPrice; 
	private int eventRoom; 
	private int eventActivity; 
	private int eventParticipant; 
	private User[] eventMembers = null; 
	
	public Event(){	
	}
	
	public Event(String aEventDate, String aEventName,Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant){
		this.eventDate = aEventDate; 
		this.eventName = aEventName; 
		this.eventPrice = aEventPrice;
		this.eventRoom = aEventRoom; 
		this.eventActivity = aEventActivity; 
		this.eventParticipant = aEventParticipant; 
	
	}
	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Double getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(Double eventPrice) {
		this.eventPrice = eventPrice;
	}

	public int getEventRoom() {
		return eventRoom;
	}

	public void setEventRoom(int eventRoom) {
		this.eventRoom = eventRoom;
	}

	public int getEventActivity() {
		return eventActivity;
	}

	public void setEventActivity(int eventActivity) {
		this.eventActivity = eventActivity;
	}

	public int getEventParticipant() {
		return eventParticipant;
	}

	public void setEventParticipant(int eventParticipant) {
		this.eventParticipant = eventParticipant;
	}
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public User[] getEventMembers() {
		return eventMembers;
	}

	public void setEventMembers(User[] eventMembers) {
		this.eventMembers = eventMembers;
	}
	
	
}

