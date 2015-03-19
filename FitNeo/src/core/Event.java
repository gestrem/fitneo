package core;

public class Event {
	
	private String eventDate; 
	private String eventName; 
	private float eventPrice; 
	private int eventRoom; 
	private int eventActivity; 
	private int eventParticipant; 
	private User[] eventMembers = null; 
	
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
