package core;

public class UserFacade {
	private User user;
	
	public UserFacade(int persistType){
		//On crée un user du type de persistance choisi
		user = User.getInstance(persistType);
	}
	
	public User login(String login, String pwd){
		return user.login(login, pwd);
	}
	
	public boolean isMailAvailable(String mail){
		return user.isMailAvailable(mail);
	}
}
