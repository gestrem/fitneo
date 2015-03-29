package core;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;

public abstract class ListActivity {
	
	protected static ListActivity listActivity = null;
	
	private ArrayList<Activity> listAllActivities = new ArrayList<Activity>();  
	
	public ListActivity(){
		
	}
	
	public void add(Activity act){
		listAllActivities.add(act); 
	}

	public ArrayList<Activity> getListAllActivities() {
		return listAllActivities;
	}

	public void setListAllActivities(ArrayList<Activity> listAllActivities) {
		this.listAllActivities = listAllActivities;
	}
	
	public static ListActivity getInstance(int persistType){
		if (listActivity == null)
			listActivity = PersistKit.createKit(persistType).createListActivity();
		return listActivity;
	}
	
	public abstract void getListActivities(); 
	public abstract void insertActivityJDBC(String actName, int managerId, String shortDescription, String lgDescription) throws SQLException; 
	public abstract void updateActivityJDBC(int idAct, String actName, int managerId, String shortDescription, String lgDescription) throws SQLException;
	public abstract void deleteActivityJDBC(int actId)throws SQLException;

	public Activity searchActivityWithId(int idact){
		Activity act = null; 
		Iterator<Activity> it =  this.getListAllActivities().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			if(it.next().getActivityId() == idact){
				find=true;
				act = ((Activity) it);
			}
		}
		return act; 
	}
	
	public abstract ArrayList<String> getListManagersJDBC (); 

	
}
