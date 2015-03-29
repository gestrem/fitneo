package core;
/**
 *@author Guillaume
 */
import java.util.ArrayList;

import persist.PersistKit;
import core.Room;
public abstract class ListRoom {

		private static ListRoom myRoomList = null;
		
		private ArrayList<Room> listRoom = new ArrayList<Room>(); 
			
		public ListRoom(){
			
		}

	
		/**
		 *CreateRoom creer une room
		 * @param String roomArea, String roomType,int capacite
		 * @return 
		 */
		public void createRoom(String roomArea, String roomType,int capacite){
			createRoomJDBC(roomArea, roomType,capacite);
		}
		

		/**
		 *GetRoom  renvoie un objet Room avec une roomName
		 * @param String roomArea
		 * @return Room
		 */
		public Room getRoom(String roomArea){
			
			return (getRoomJDBC(roomArea));
			
		}
		/**
		 *GetRoom  instancie une ListRoom 
		 * @param Choix 
		 * @return Room
		 */
	
		
		public void createListRoom(int choice){
			
			switch (choice) {
            case 0: getAllRoomJDBC();
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
		
	
		/**
		 * listRoomToArrayStringListRoom transforme une arrayList<Room> en String[] de nom de room
		 * pour une comboBox
		 * @param listRoom
		 * @return
		 */
		public String[] listRoomToArrayStringListRoom(ArrayList<Room> listRoom){
			
			String[] listRoomString=new String[listRoom.size()];
			
			for(int i=0;listRoom.size()>i;i++){
				String roomArea=listRoom.get(i).getRoomArea();
				listRoomString[i]=roomArea;
				
			}
			
			return listRoomString;
		}
		
	/**
	 * 	getIndexRoomUpdated(ArrayList<Room> listRoom, String roomName) recupere l'id de la room modifie
			
	 * @param listRoom
	 * @param roomName
	 * @return
	 */
	public int getIndexRoomUpdated(ArrayList<Room> listRoom, String roomName){
			
			int res=-1;	
			for(int i=0;listRoom.size()>i;i++){
				if (listRoom.get(i).getRoomArea().equals(roomName)){
					res=i;
				}
				
			}
			
			return res;
		}
	
		
		/**
		 * getInstance(int persistType) retourne une instance de la liste en fct de la persistance
		 * @param persistType
		 * @return
		 */
		public static ListRoom getInstance(int persistType){
			if (myRoomList == null)
				myRoomList= PersistKit.createKit(persistType).createListRoom();
			
			return myRoomList;
		}
		/**
		 * updateRoomListRoom met à une Room dans une liste
		 * @param listRoom
		 * @param index
		 * @param roomArea
		 * @param roomType
		 * @param capacity
		 */
		public void updateRoomListRoom(ArrayList<Room> listRoom,int index,String roomArea, String roomType,int capacity ){
			Room roomToUpdate=listRoom.get(index);
			roomToUpdate.setRoomArea(roomArea);
			roomToUpdate.setRoomType(roomType);
			roomToUpdate.setCapacity(capacity);
			
		}
		/**
		 * Delete Room supprime une room d'une liste
		 * @param listRoom
		 * @param index
		 */
		public void deleteRoom(ArrayList<Room> listRoom,int index){
			listRoom.remove(index);
			
		}
/**
 * addRoomToListRoom ajoute une room dans une liste Room
 * @param listRoom
 * @param roomArea
 * @param roomType
 * @param capacity
 */
		public void addRoomToListRoom(ArrayList<Room> listRoom,String roomArea, String roomType,int capacity ){
			
			Room room=new Room(roomArea,roomType,capacity);
			listRoom.add(room);
				
		
		}
		/**
		 * CreateRoomJDBC Créee une room
		 * @param roomArea
		 * @param roomType
		 * @param capacite
		 */
		public abstract void createRoomJDBC(String roomArea, String roomType,int capacite);
		/**
		 * UpdateRoomJDBC met à jour une room
		 * @param roomAreaOld
		 * @param roomArea
		 * @param roomType
		 * @param capacite
		 */
		public abstract void updateRoomJDBC(String roomAreaOld,String roomArea, String roomType,int capacite);
		/**
		 * DeleteRoom detruit une room
		 * @param RoomArea
		 */
		public abstract void deleteRoomJDBC(String RoomArea);
/**
 * getRoomJDBC retourne une room
 * @param roomArea
 * @return
 */
		/** GetAllRoomJDBC instancie une listRoom
		 * @param 
		 */
		public abstract void getAllRoomJDBC();
		/** GetAllRoomJDBC instancie une listRoom
		 * @param 
		 */

		/** GetRoomJDBC retourne une Room
		 * @param 
		 */
		public abstract Room getRoomJDBC(String RoomArea);



	}