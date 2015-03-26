package core;

import java.util.ArrayList;

import persist.PersistKit;
import core.Room;
public abstract class ListRoom {

		private static ListRoom myRoomList = null;
		
		private ArrayList<Room> listRoom = new ArrayList<Room>(); 
			
		public ListRoom(){
			
		}

	

		public void createRoom(String roomArea, String roomType){
			createRoomJDBC(roomArea, roomType);
		}
		
		public Room getRoom(int idRoom){
			
			return (getRoomJDBC(idRoom));
			
		}
		public void addRoomToList(Room room){
			listRoom.add(room);
		}
		
		public void createListRoom(int choice){
			
			switch (choice) {
            case 0: getAllRoomJDBC();
            case 1: getAllRoomFreeJDBC();
            default : getAllRoomJDBC();
            break;
			}
		}
		
		public void setListRoom(ArrayList<Room> listRoom) {
			this.listRoom = listRoom;
		}	
		
		public ArrayList<Room> getListRoom(){
			return listRoom;
		}
		
	
		
		
		
		public static ListRoom getInstance(int persistType){
			if (myRoomList == null)
				myRoomList= PersistKit.createKit(persistType).createListRoom();
			
			return myRoomList;
		}
		
		public abstract void createRoomJDBC(String roomArea, String roomType);
		public abstract void updateRoomJDBC(int idRoom,String roomArea, String roomType,int capacite);
		public abstract void deleteListRoomJDBC(int idRoom);
		public abstract Room getRoomJDBC(int idRoom);

		public abstract void getAllRoomJDBC();
		public abstract void getAllRoomFreeJDBC();
	}