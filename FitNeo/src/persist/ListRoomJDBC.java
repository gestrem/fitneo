package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void updateListRoomJDBC(int roomId,String roomArea,String roomType,int capacity){
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
}