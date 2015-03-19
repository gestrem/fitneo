package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class Room {
	private int roomId;
	private int roomArea;
	
	private static Room room = null;
	private ArrayList<Room> listRoom = null; 
	
	public Room(){
	}
	
	public Room(int roomId,int roomArea){
		this.roomArea=roomArea;
		this.roomId=roomId;
		
	}
	
	
	public static Room getInstance(int persistType){
		if (room == null)
			room = PersistKit.createKit(persistType).createRoom();
		return room;
	}


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public int getRoomArea() {
		return roomArea;
	}


	public void setRoomArea(int roomArea) {
		this.roomArea = roomArea;
	}
	
	public void createRoom(int roomArea){
		room.createRoom(roomArea);
		
	}
	public void updateRoomArea(int roomId,int roomArea){
		room.updateRoomArea(roomId,roomArea);
		
	}
}
