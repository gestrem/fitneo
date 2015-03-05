package core;

public class UserFacade {
	User user;
	
	public UserFacade(){
		user = new User();
	}
	
	public void login(String login, String pwd){
		user.login(login, pwd);
	}
}
