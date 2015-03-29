package persist;
/**
 * @author gestrem
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.ListAccessoryType;
import core.AccessoryType;

public class ListAccessoryJDBC extends ListAccessoryType{
	
	private JdbcConnection jdbc = null;

	public ListAccessoryJDBC(){
		jdbc = new JdbcConnection();
	}
	

	/**createAccessoryTypeJDBC
	 * @param accessoryType
	 */
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


	/**GetAllAccessoryTypeJDBC
	 */	
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
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
		
	}
	/**
	 * updateAccessoryTypeJDBC met à jour un accessoire
	 * @param idAccessoryType
	 * @param nameAccessoryType
	 */
	public void updateAccessoryTypeJDBC(int idAccessoryType,String nameAccessoryType){
		jdbc.openConnection();
		try{
			String query ="UPDATE accessoryType set accessoryName='"+nameAccessoryType+"'  WHERE idAccessoryType='"+idAccessoryType+"' ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}


	/**
	 * deleteAccessoryTypeJDBC
	 * @param idAccessoryType
	 */
	public void deleteAccessoryTypeJDBC(int idAccessoryType) {
		jdbc.openConnection();
		try{
			String query ="DELETE from accessoryType  WHERE idAccessoryType='"+idAccessoryType+"' ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();		
	}
	
}