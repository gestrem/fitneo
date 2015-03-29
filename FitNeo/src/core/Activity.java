package core;

import java.util.ArrayList;
import java.util.Iterator;

public class Activity {
	
	private int activityId;
	private String activityName;; 
	private String shortActivityDescription;
	private String detailedActivityDescription;
	private String activityManager;  
	
	public Activity (){	
	}
	
	public Activity( int aActivityId,String aActivityName,String aActivityManager, String aShortActivityDescription, String aDetailedActivityDescription ){	
		this.activityId = aActivityId; 
		this.activityName = aActivityName;
		this.activityManager = aActivityManager;
		this.shortActivityDescription = aShortActivityDescription;
		this.detailedActivityDescription = aDetailedActivityDescription;
	}
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityShortDescription() {
		return shortActivityDescription;
	}
	public void setActivityShortDescription(String shortActivityDescription) {
		this.shortActivityDescription = shortActivityDescription;
	}
	public String getActivityDetailedDescription() {
		return detailedActivityDescription;
	}
	public void setActivityDetailedDescription(String detailedActivityDescription) {
		this.detailedActivityDescription = detailedActivityDescription;
	}
	public String getActivityManager() {
		return activityManager;
	}
	public void setActivityManager(String activityManager) {
		this.activityManager = activityManager;
	}
	
	
	public String toString(){
		return this.activityName;
	}

}
