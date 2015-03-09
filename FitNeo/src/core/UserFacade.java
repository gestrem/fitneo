package core;

import persist.PersistKit;

public class UserFacade {
	private User user;
	
	public UserFacade(int persistType){
		//On charge le kit de persistance en fonction du type demandé
		user = PersistKit.getInstance(persistType).makeKit();
	}
	
	public void login(String login, String pwd){
		user.login(login, pwd);
	}
}
