/**@author Maite AINCIBURU **/

package persist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Activity;
import core.ListActivity;


public class ListActivityJDBC extends ListActivity {
	private JdbcConnection jdbc = null;

	public ListActivityJDBC(){
		jdbc = new JdbcConnection();
	}
	
	/**
     * Methode getListActivities
     */
	/* On recupere toutes les activités de la BD : (int idAct, string activityName, string activityDesc, int idManager)
	 * on charge la Liste des activites : (int idAct, string activityName, string activityDesc, User Manager)
	 * */ 
	public void getListActivities(){
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			ArrayList<Activity> listAllActivities = new ArrayList<Activity>();

			String query = "SELECT idActivity, activityName, shortActivityDesc, detailedActivityDesc, u.userFirstName, u.userLastName FROM activity a, mainuser u WHERE a.manager = u.idUser";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				  int id = rs.getInt(1);
			      System.out.println("id=" + id);
			      String actName = rs.getString(2);
			      System.out.println("name=" + actName);
			      String shortDescr = rs.getString(3);
			      System.out.println("descrition=" + shortDescr);
			      String lgDescr = rs.getString(4);
			      System.out.println("descrition=" + lgDescr);
			      String managerFirstName = rs.getString(5);
			      System.out.println(" first name manager=" + managerFirstName);
			      String managerLastName = rs.getString(6);
			      System.out.println(" first name manager=" + managerLastName);
			      listAllActivities.add(new Activity(id,actName, managerFirstName+" "+managerLastName, shortDescr, lgDescr)); 
			}
			
			this.setListAllActivities(listAllActivities);
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	/**
     * Methode insertActivityJDBC 
     * @param unNomActivite (string), unIdResponsable (string), uneCourteDescription (string), uneLongueDescription (string)
     * insere une Activite dans la BD
     */
	
	public void insertActivityJDBC(String actName, int managerId, String shortDescription, String lgDescription) throws SQLException{

		jdbc.openConnection();
		String query = "INSERT INTO activity (activityName, shortActivityDesc, detailedActivityDesc, manager)values ('" +actName+ "','" +shortDescription+ "','" +lgDescription+ "','" +managerId+ "' )"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	/**
     * Methode updateActivityJDBC 
     * @param un IDActivite, unNomActivite (string), unIdResponsable (string), uneCourteDescription (string), uneLongueDescription (string)
     * modifie une Activite dans la BD grace aux parametres
     */
	public void updateActivityJDBC(int idAct,String actName, int managerId, String shortDescription, String lgDescription) throws SQLException{

		jdbc.openConnection();
		String query = "UPDATE activity SET activityName = '" +actName+ "', shortActivityDesc='" +shortDescription+ "', detailedActivityDesc ='" +lgDescription+ "' , manager='" +managerId+ "'WHERE idActivity ='"+idAct+"' "; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	
	/**
     * Methode deleteActivityJDBC 
     * @param un IDActivite int
     * supprime l'activite --> IDActivite de la BD
     */
	public void deleteActivityJDBC(int idAct) throws SQLException{
		jdbc.openConnection();
		String query = "DELETE FROM activity WHERE idActivity='"+idAct+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	

	}
	
	/**
     * Methode getListManagersJDBC 
     * @return les Managers de la BD sous forme de liste de string 
     * 
     */
	public ArrayList<String> getListManagersJDBC (){
		 
		ArrayList<String> managers = new ArrayList<String>();
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			
			String query = "SELECT u.idUser, u.userFirstName, u.userLastName FROM mainuser u WHERE u.roleManager = true";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				int managerId = rs.getInt(1);
			    System.out.println("manager id =" + managerId);
			    String managerFirstName = rs.getString(2);
			    System.out.println(" first name manager=" + managerFirstName);
			    String managerLastName = rs.getString(3);
			    System.out.println(" first name manager=" + managerLastName);
			    managers.add(Integer.toString(managerId)); 
			    managers.add(managerFirstName+" "+managerLastName);  
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
		
		return managers;
	}
	
	
	
	
}
