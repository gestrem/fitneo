package core;

public class RoomFacade {
	private Room room;
	
	public RoomFacade(int persistType){
		//On crée une room du type de persistance choisi
		room = Room.getInstance(persistType);
	}
}
