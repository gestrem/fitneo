package core;

import java.util.ArrayList;
public class RoomFacade {
	private ListRoom listroom;
	
	
	public RoomFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		listroom = ListRoom.getInstance(persistType);
	}
	
	public void createRoom(String roomArea,String roomType,int maxParticipants){
		listroom.createRoom(roomArea, roomType,maxParticipants);
	}
	
	public void createListRoomComboBox(int choice){
		listroom.createListRoom(choice); 
		}
	
	public ArrayList<Room> getListRoom(){
		return(listroom.getListRoom());
	}
	
	public String[] listRoomToArrayStringListRoom(ArrayList<Room> listRoom){
		return(listroom.listRoomToArrayStringListRoom(listRoom));
	}
	

	public void updateRoom(String roomAreaOld,String roomArea, String roomType,int capacite){
		
		 listroom.updateRoomJDBC(roomAreaOld,roomArea,roomType,capacite);
	}
	public Room getRoom(String roomArea){
		
		return (listroom.getRoom(roomArea));
		
	}
	public int getIndexRoomUpdated(ArrayList<Room> listRoom, String roomName){
		 return listroom.getIndexRoomUpdated(listRoom,roomName);
	}
	public void updateRoomListRoom(ArrayList<Room> listRoom,int index,String roomArea, String roomType,int capacity ){
		listroom.updateRoomListRoom(listRoom, index, roomArea, roomType, capacity);
	}
	public void deleteRoomListRoom(ArrayList<Room> listRoom,int index){
		listroom.deleteRoom(listRoom,index);
	}
	public void deleteRoomJDBC(String roomArea){
		listroom.deleteRoomJDBC(roomArea);
	}
	
	public void addRoomToListRoom(ArrayList<Room> listRoom,String roomArea, String roomType,int capacity ){
	
		listroom.addRoomToListRoom(listRoom,roomArea, roomType,capacity );
	}
}

