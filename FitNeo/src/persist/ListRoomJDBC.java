package persist;

import java.sql.ResultSet;

import core.ListRoom;

public class ListRoomJDBC extends ListRoom{
	
	private JdbcConnection jdbc = null;

	
	public ListRoomJDBC(){
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

	@Override
	public void createRoomJDBC(String roomArea, String roomType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListRoomJDBC(int idRoom, String roomArea,
			String roomType, int capacite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteListRoomJDBC(int idRoom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllRoomJDBC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllRoomFreeJDBC() {
		// TODO Auto-generated method stub
		
	}
}