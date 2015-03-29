package core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


public class ActivityFacade {
	private ListActivity listActivity;
	
	public ActivityFacade(int persistType){
		//On cr�e une liste d'activite du type de persistance choisi
		listActivity = listActivity.getInstance(persistType);
	}

	public ArrayList<Activity> getListAllActivities() {
		return listActivity.getListAllActivities();
	}
	
	public void loadListActivities(){
		listActivity.getListActivities();
	}
	
	public void createActivityFacade(String actName, int managerId, String shortDescription, String lgDescription) throws SQLException{
		listActivity.insertActivityJDBC(actName, managerId, shortDescription, lgDescription);
	}
	public void updateActivityFacade(int idAct, String actName, int managerId, String shortDescription, String lgDescription) throws SQLException{
		listActivity.updateActivityJDBC(idAct, actName, managerId, shortDescription, lgDescription);
	}
	public void deleteActivity(int actId)throws SQLException{
		listActivity.deleteActivityJDBC(actId); 
	}	
	
	public String[] loadManagers(){
		  
		ArrayList<String> managers = new ArrayList<String>(); 
		managers = listActivity.getListManagersJDBC(); 
		/*ArrayList to Array Conversion */
		String managersString[]=managers.toArray(new String[managers.size()]);

		return managersString; 

	}

}
