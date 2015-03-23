package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.ListAccessoryType;
import core.AccessoryType;

import core.Room;

public class ListAccessoryJDBC extends ListAccessoryType{
	
	private JdbcConnection jdbc = null;

	public ListAccessoryJDBC(){
		jdbc = new JdbcConnection();
	}
	

	@Override
	public void createAccessoryTypeJDBC(String accessoryType) {
		jdbc.openConnection();
		
		try{
			String query = "INSERT INTO accessoryType(accessoryName) VALUES ('" +accessoryType +"')";
			jdbc.executeRequest(query);
			
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();		
	}


	@Override
	public void getAllAccessoryTypeJDBC() {

		jdbc.openConnection();
		ResultSet rs = null;
		ArrayList<AccessoryType> accessoryList=new ArrayList<AccessoryType>();
		
		try{
			String query = "SELECT * FROM accessoryType";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				accessoryList.add(new AccessoryType(rs.getInt("idAccessoryType"),rs.getString("accessoryTypeName")));
            	
            }
		this.setMyAccessoryTypeList(accessoryList);
		
		(listRoom);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
		
	}
	
	
}