package core;

public class Inscription {

	private String eventName;
	private String eventDate;
	private String eventDateInscription;
	private int eventId;
	
	public Inscription(String event, String date, String dateI, int id){
		this.eventId=id;
		this.eventName=event;
		this.eventDate=date;
		this.eventDateInscription = dateI;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventDateInscription() {
		return eventDateInscription;
	}

	public void setEventDateInscription(String eventDateInscription) {
		this.eventDateInscription = eventDateInscription;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
