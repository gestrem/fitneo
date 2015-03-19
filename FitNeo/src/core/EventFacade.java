package core;

public class EventFacade {
	private ListEvent listevent;
	
	public EventFacade(int persistType){
		//On crée une room du type de persistance choisi
		listevent = ListEvent.getInstance(persistType);
	}
}
