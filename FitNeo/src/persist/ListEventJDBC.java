package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Event;
import core.ListEvent;

/**
 * 
 * @author arnaud jacquez
 *
 */
public class ListEventJDBC extends ListEvent{
	
	private JdbcConnection jdbc = null;

	public ListEventJDBC(){
		jdbc = new JdbcConnection();
	}
	
	/**
	 * getAllEvents permet de charger dans la liste d evenement tous les evenements de la BD
	 */
	public void getAllEvents(){
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			ArrayList<Event> listEvents= new ArrayList<Event>();	
			String query = "SELECT e.idEvent, e.eventDate, e.eventName, e.eventPrice, e.idroom, e.id_activity, e.participant, u.userFirstName , u.userLastName FROM event e, mainuser u Where e.participant=u.idUser";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
            	listEvents.add(new Event(rs.getInt("idEvent"), rs.getString("eventDate"),rs.getString("eventName"),rs.getDouble("eventPrice"),rs.getInt("idroom"),rs.getInt("id_activity"), rs.getInt("participant"), rs.getString("userFirstName")+" "+rs.getString("userLastName"))); 
            }
			
			this.setListEvent(listEvents); 
		}
		
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	/**
	 * createEventJDBC permet d inserer un evenement dans la BD a partir d un object evenement 
	 * @param aEvent
	 * @throws SQLException
	 */
	public void createEventJDBC(Event aEvent) throws SQLException{
		
		jdbc.openConnection();
		
		String query = "INSERT INTO event(eventName, eventDate, eventPrice, idroom, participant ,id_activity) values('"+aEvent.getEventName()+"','"+aEvent.getEventDate()+"','"+aEvent.getEventPrice()+"','"+aEvent.getEventRoom()+"','"+aEvent.getEventParticipant()+"','"+aEvent.getEventActivity()+"')";
		jdbc.executeRequest(query);
		jdbc.close();
	}
	/**
	 * updateEventJDBC permet de mettre a jour un evenement dans la BD 
	 * @param aEventDate doit etre de type string
	 * @param aEventName doit etre de type string
	 * @param aEventPrice doit etre de type double
	 * @param aEventRoom doit etre de type int
	 * @param aEventActivity doit etre de type int
	 * @param aEventParticipant doit etre de type int
	 * @param aEventId doit etre de type int 
	 * @throws SQLException
	 */
	public void updateEventJDBC(String aEventDate, String aEventName, Double aEventPrice, int aEventRoom, int aEventActivity, int aEventParticipant, int aEventId) throws SQLException{
		
		jdbc.openConnection();
		
		String query = "UPDATE event SET eventName='"+aEventName+"',eventDate='"+aEventDate+"',eventPrice='"+aEventPrice+"',idroom='"+aEventRoom+"',participant='"+aEventParticipant+"',id_activity='"+aEventActivity+"' WHERE idEvent='"+aEventId+"'";
		jdbc.executeRequest(query);
		jdbc.close();
	}
	
	/**
	 * deleteListEventJDBC permet de supprimer un evenement de la bd 
	 * @param aEventId
	 */
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