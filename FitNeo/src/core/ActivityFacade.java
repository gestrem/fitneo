package core;

public class ActivityFacade {
	private Activity activity;
	
	public ActivityFacade(int persistType){
		//On cr�e une room du type de persistance choisi
		activity = Activity.getInstance(persistType);
	}
}
