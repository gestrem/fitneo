package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Room;
import core.ListRoom;
public class ListRoomJDBC extends ListRoom{
	
	private JdbcConnection jdbc = null;

	
	public ListRoomJDBC(){
		jdbc = new JdbcConnection();
		System.out.println("jdbclist");
	}
	
	public void createRoomJDBC(String roomArea, String roomType){
		
		jdbc.openConnection();
		
		try{
			String query = "INSERT INTO room(roomArea, roomType) VALUES ('" +roomArea +"','"+ roomType+"')";
			jdbc.executeRequest(query);
			
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
	public void updateRoomJDBC(int roomId,String roomArea,String roomType,int capacity){
		jdbc.openConnection();
		try{
			String query ="UPDATE room set roomArea='"+roomArea+"' ,roomType='"+roomType+"',capacity='"+capacity+"' WHERE idRoom='"+roomId+"' ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
	public void deleteListRoomJDBC(int roomId){
		jdbc.openConnection();
		try{
			String query ="delete from room where idRoom='"+roomId+"'  ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}

	public void getAllRoomJDBC(){
		
		jdbc.openConnection();
		ResultSet rs = null;
		ArrayList<Room> listRoom=new ArrayList<Room>();
		
		try{
			String query = "SELECT * FROM room";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listRoom.add(new Room(rs.getInt("idRoom"),rs.getString("roomArea"),rs.getString("roomType")));
            	
            }
		this.setListRoom(listRoom);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}


	public void getAllRoomFreeJDBC(){
		 //to do
		jdbc.openConnection();
		ResultSet rs = null;
		ArrayList<Room> listRoom=new ArrayList<Room>();
		
		try{
			String query = "SELECT * FROM room ";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listRoom.add(new Room(rs.getInt("idRoom"),rs.getString("roomArea"),rs.getString("roomType")));
	        	
	        }
		this.setListRoom(listRoom);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}

	@Override
	public Room getRoomJDBC(int idRoom) {
		// TODO Auto-generated method stub
		return null;
	}

}