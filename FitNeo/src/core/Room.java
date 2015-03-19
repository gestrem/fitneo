package core;

public class Room {
	
	private int roomId;
	private String roomArea;
	private String roomType;
	private int capacity; 
	
	/* 
	 * constructeur pour une salle de type office
	 */
	public Room(int idRoom, String roomArea, String roomType){
		this.roomArea=roomArea;
		this.roomId=idRoom;
		this.roomType=roomType;	
	}
	
	/* 
	 * constructeur pour une salle de type cours
	 */
	public Room(int idRoom, String roomArea, String roomType, int capacity){
		this.roomArea=roomArea;
		this.roomId=idRoom;
		this.roomType=roomType;	
		this.capacity = capacity;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
