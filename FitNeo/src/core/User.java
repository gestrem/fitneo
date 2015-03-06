package core;

import persist.JdbcUser;

public class User {
	private String userName;
	private String password;
	protected static User user = null;
	
	public User(){
		
	}
	
	public User(String login, String pwd){
		setName(login);
		setPassword(pwd);
	}
	
	public void setName(String name){
		userName=name;
	}
	
	public String getName(){
		return userName;
	}
	
	public void setPassword(String pwd){
		password=pwd;
	}
		
	public boolean isPassOK(String pwd){
		return this.password.equals(pwd);
	}
	
	public void login(String login, String pwd){
		JdbcUser userJdbc = new JdbcUser(login);
		if((user.getName() != null) && (user.isPassOK(pwd))){
			System.out.println("Connection autorisée pour " + login);
		}
		else
			System.out.println("Mauvais identifiants pour " + login);
	}
	
}
