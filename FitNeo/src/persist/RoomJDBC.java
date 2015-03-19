package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Room;

public class RoomJDBC extends Room{
	
	private JdbcConnection jdbc = null;

	
	public RoomJDBC(){
		jdbc = new JdbcConnection();
	}
	
	public void createRoom(int roomArea){
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			String query = "INSERT INTO ROOM VALUES ( ROOMAREAM ='" +roomArea + "')";
			jdbc.executeRequest(query);
			
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
	public void updateRoomArea(int roomId,int roomArea){
		jdbc.openConnection();
		try{
			String query ="UPDATE ROOM set ROOMAREA='"+roomArea+"' WHERE IDROOM='"+roomId+"' ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
}