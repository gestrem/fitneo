package persist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Activity;
import core.CategoryProduct;
import core.ListActivity;
import core.ListCategory;

public class ListActivityJDBC extends ListActivity {
	private JdbcConnection jdbc = null;

	public ListActivityJDBC(){
		jdbc = new JdbcConnection();
	}
	/* On recupere toutes les activités cad un ensemble de (int idAct, string activityName, string activityDesc, int idManager)
	 * pour instancier une categorie de type CategorieProduct, il nous faut(int idAct, string activityName, string activityDesc, User Manager)
	 * si le Manager n'est pas nul on utilise l'int idManager pour acceder a l'instance de User grace a la methode searchWithId
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
	
	public void insertActivityJDBC(String actName, int managerId, String shortDescription, String lgDescription) throws SQLException{

		jdbc.openConnection();
		ResultSet rs = null; 
		
		String query = "INSERT INTO activity (activityName, shortActivityDesc, detailedActivityDesc, manager)values ('" +actName+ "','" +shortDescription+ "','" +lgDescription+ "','" +managerId+ "' )"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	public void updateActivityJDBC(int idAct,String actName, int managerId, String shortDescription, String lgDescription) throws SQLException{

		jdbc.openConnection();
		ResultSet rs = null; 
		
		String query = "UPDATE activity SET activityName = '" +actName+ "', shortActivityDesc='" +shortDescription+ "', detailedActivityDesc ='" +lgDescription+ "' , manager='" +managerId+ "'WHERE idActivity ='"+idAct+"' "; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	public void deleteActivityJDBC(int idAct) throws SQLException{
		jdbc.openConnection();
		ResultSet rs = null; 
		
		
		String query = "DELETE FROM activity WHERE idActivity='"+idAct+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	

	}
	
	public ArrayList<String> getListManagersJDBC (){
		 
		ArrayList<String> managers = new ArrayList<String>();
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			
			int i =0; 
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
			    i++; 
			}
			
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
		
		return managers;
	}
	
	
	
	
}
