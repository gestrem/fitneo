package core;

public class EventFacade {
	private Event event;
	
	public EventFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		event = Event.getInstance(persistType);
	}
}
