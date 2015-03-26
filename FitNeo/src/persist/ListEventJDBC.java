package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Event;
import core.ListEvent;
import core.Product;

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
			String query = "SELECT * FROM event e";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
            	listEvents.add(new Event(rs.getString("eventDate"),rs.getString("eventName"),rs.getDouble("eventPrice"),rs.getInt("idroom"),rs.getInt("id_activity"), rs.getInt("participant"))); 
            }
			
			this.setListEvent(listEvents); 
		}
		
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
	public void createEventJDBC(Event aEvent) throws SQLException{
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		String query = "INSERT INTO event(eventName, eventDate, eventPrice, idroom, participant ,id_activity) values('"+aEvent.getEventName()+"','"+aEvent.getEventDate()+"','"+aEvent.getEventPrice()+"','"+aEvent.getEventRoom()+"','"+aEvent.getEventParticipant()+"','"+aEvent.getEventActivity()+"')";
		jdbc.executeRequest(query);
		jdbc.close();
	}
	public void updateEventJDBC(String aEventDate, String aEventName, Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId) throws SQLException{
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		String query = "UPDATE event SET eventName='"+aEventName+"',eventDate='"+aEventDate+"',eventPrice='"+aEventPrice+"',idroom='"+aEventRoom+"',participant='"+aEventParticipant+"',id_activity='"+aEventActivity+"' WHERE idEvent='"+aEventId+"'";
		jdbc.executeRequest(query);
		jdbc.close();
	}
	
	public void deleteListEventJDBC(int aEventId){
		jdbc.openConnection();
		try{
			String query ="delete from event where idEvent='"+aEventId+"'  ";
						jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
}