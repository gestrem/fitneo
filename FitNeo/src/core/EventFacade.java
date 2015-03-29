package core;

import java.sql.SQLException;
import java.util.ArrayList;

public class EventFacade {
	private ListEvent listevent;
	
	public EventFacade(int persistType){
		//On crée une room du type de persistance choisi
		listevent = ListEvent.getInstance(persistType);
	}
	public void getAllEventsFacade(){
		listevent.getAllEvents();
	}
	
	public ArrayList<Event> getListAllEventsFacade() {
		return listevent.getListAllEvents();
	}
	public void createEventFacade(Event aEvent) throws SQLException{
		listevent.createEvent(aEvent);
	}
	public void updateEventFacade(String aEventDate, String aEventName,Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId)throws SQLException{
		listevent.updateEvent(aEventDate, aEventName, aEventPrice, aEventRoom, aEventActivity, aEventParticipant, aEventId);
	}
	public void deleteListEventFacade(int aEventId){
		listevent.deleteListEvent(aEventId);
	}
	public Event searchWithIdFacade(int aEventID){
		return listevent.searchWithId(aEventID);
	}
}

