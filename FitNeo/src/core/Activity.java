package core;

import java.util.ArrayList;

import persist.PersistKit;

public abstract class Activity {
	
	private String activityName; 
	private String activityDescription;  
	private User activityManager;  
	private Event[] activityEvents; 
	
	private static Activity activity = null;
	private ArrayList<Activity> listActivity = null;  
	
	public Activity(){	
	}
	
	
	public static Activity getInstance(int persistType){
		if (activity == null)
			activity = PersistKit.createKit(persistType).createActivity();
		return activity;
	}

}
