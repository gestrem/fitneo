package core;

public class RoomFacade {
<<<<<<< Updated upstream
	private Room room;
	
	public RoomFacade(int persistType){
		//On crée une room du type de persistance choisi
		room = Room.getInstance(persistType);
=======
	Room room;
	
	public void addAccessoryRoom(Room room, String accessoryName, Integer quantity){
		
	}
	public void deleteAccessoryRoom(Room room, String accessoryName, Integer quantity){
		
>>>>>>> Stashed changes
	}
}
