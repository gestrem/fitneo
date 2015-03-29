package core;

import java.sql.SQLException;
import java.util.ArrayList;


public class ActivityFacade {
	private ListActivity listActivity;
	
	public ActivityFacade(int persistType){
		//On creee une liste d'activite du type de persistance choisi
		listActivity = ListActivity.getInstance(persistType);
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
	
	
	public ArrayList<String> loadManagers(){
		   
		return listActivity.getListManagersJDBC(); 

	}

}
