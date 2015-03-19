package core;

public class RoomFacade {
	private ListRoom listroom;
	
	public RoomFacade(int persistType){
		//On crée une room du type de persistance choisi
		listroom = ListRoom.getInstance(persistType);
	}
}
