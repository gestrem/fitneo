package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import core.Event;
import core.ListEvent;

public class ListEventJDBC extends ListEvent{
	
	private JdbcConnection jdbc = null;

	public ListEventJDBC(){
		jdbc = new JdbcConnection();
	}
	
	public void getAllEvents(){
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			ArrayList<Event> listEvents= new ArrayList<Event>();	
			String query = "SELECT * FROM Event e";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
            	listEvents.add(new Event(rs.getString("eventDate"),rs.getString("eventName"),rs.getFloat("eventPrice"),rs.getInt("idroom"),rs.getInt("id_activity"), rs.getInt("participant"))); 
            }
			
			this.setListEvent(listEvents); 
		}
		
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
}