package core;

import java.util.ArrayList;
import persist.PersistKit;
import core.Room;
public abstract class ListRoom {


	
		
		private static ListRoom myRoomList = null;
		private ArrayList<Room> listRoom = null; 
		
		
		public ListRoom(){
		}
		
		




		public void setListRoom(ArrayList<Room> listRoom) {
			this.listRoom = listRoom;
		}




		
	
		
		
		public static ListRoom getInstance(int persistType){
			if (myRoomList == null)
				myRoomList= PersistKit.createKit(persistType).createListRoom();
			
			return myRoomList;
		}


		public void createRoom(String roomArea, String roomType){
			createRoomJDBC(roomArea, roomType);
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
		
		public void getListRoom(){
		
		String res;
			for (int i=0; i<this.listRoom.size(); i++){
				
			
		          res=listRoom.get(i).getRoomArea()+" "+
		          listRoom.get(i).getRoomType()+" "+
		          listRoom.get(i).getRoomType();
		          System.out.println(res+"\n");
			}

		}
		
		public void deleteRoom(int id){
			deleteListRoomJDBC(id);
		}
		public void updateListRoom(int idRoom,String roomArea, String roomType,int capacite){
			updateListRoomJDBC(idRoom,roomArea, roomType,capacite);
		}
		public abstract void createRoomJDBC(String roomArea, String roomType);
		public abstract void updateListRoomJDBC(int idRoom,String roomArea, String roomType,int capacite);
		public abstract void deleteListRoomJDBC(int idRoom);
		public abstract void getAllRoomJDBC();
		public abstract void getAllRoomFreeJDBC();


	}


