package core;

import java.util.ArrayList;

import persist.PersistKit;

public class Room {
	private int roomId;
	private String roomArea;
	private String roomType;
	

	
	public Room(int roomId,String roomArea){
		this.roomArea=roomArea;
		this.roomId=roomId;
		
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
	

}
