package core;

import java.util.ArrayList;

import persist.PersistKit;
import core.Room;
public abstract class ListRoom {

		private static ListRoom myRoomList = null;
		
		private ArrayList<Room> listRoom = new ArrayList<Room>(); 
			
		public ListRoom(){
			
		}

	

		public void createRoom(String roomArea, String roomType,int capacite){
			createRoomJDBC(roomArea, roomType,capacite);
		}
		
		public Room getRoom(String roomArea){
			
			return (getRoomJDBC(roomArea));
			
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
		
	
		public String[] listRoomToArrayStringListRoom(ArrayList<Room> listRoom){
			
			String[] listRoomString=new String[listRoom.size()];
			
			for(int i=0;listRoom.size()>i;i++){
				String roomArea=listRoom.get(i).getRoomArea();
				listRoomString[i]=roomArea;
				
			}
			
			return listRoomString;
		}
		
		
	public int getIndexRoomUpdated(ArrayList<Room> listRoom, String roomName){
			
			int res=-1;	
			for(int i=0;listRoom.size()>i;i++){
				if (listRoom.get(i).getRoomArea().equals(roomName)){
					res=i;
				}
				
			}
			
			return res;
		}
	
		
		
		public static ListRoom getInstance(int persistType){
			if (myRoomList == null)
				myRoomList= PersistKit.createKit(persistType).createListRoom();
			
			return myRoomList;
		}
		public void updateRoomListRoom(ArrayList<Room> listRoom,int index,String roomArea, String roomType,int capacity ){
			Room roomToUpdate=listRoom.get(index);
			roomToUpdate.setRoomArea(roomArea);
			roomToUpdate.setRoomType(roomType);
			roomToUpdate.setCapacity(capacity);
			
		}
		
		public void deleteRoom(ArrayList<Room> listRoom,int index){
			listRoom.remove(index);
			
		}
		public void addRoomToListRoom(ArrayList<Room> listRoom,String roomArea, String roomType,int capacity ){
			
			Room room=new Room(roomArea,roomType,capacity);
			listRoom.add(room);
				
		
		}
		public abstract void createRoomJDBC(String roomArea, String roomType,int capacite);
		public abstract void updateRoomJDBC(String roomAreaOld,String roomArea, String roomType,int capacite);
		public abstract void deleteRoomJDBC(String RoomArea);
		public abstract Room getRoomJDBC(String roomArea);

		public abstract void getAllRoomJDBC();
		public abstract void getAllRoomFreeJDBC();
	}