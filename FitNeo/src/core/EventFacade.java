package core;

public class EventFacade {
	private ListEvent listevent;
	
	public EventFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		listevent = ListEvent.getInstance(persistType);
	}
}
