package core;

import persist.PersistKit;

public abstract class User {
	private String userName;
	private String password;
	
	private static User user = null;
	
	public User(){
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
		
    /**
     * Methode isPassOK
     * @param pwd le mot de passe donnée par l'utilisateur
     * @return un boolean true si le mot de passe correspond
     * au mot de passe en base de donnée. Renvoi false sinon.
     */
	public boolean isPassOK(String pwd){
		return this.password.equals(pwd);
	}
	
    /**
     * Methode login, essaye d'initialiser un user 
     * avec les informations données par l'utilisateur puis fais une comparaison
     * @param login le login donné par l'utilisateur
     * @param pwd le mot de passe donné par l'utilisateur
     */
	public User login(String login, String pwd){
		setUser(login);
		if((user.getName() != null) && (user.isPassOK(pwd))){
			return user;
		}
		else{
			return null;
		}
	}
	
    /**
     * Methode isMailAvailable, verifie que le mail n'est pas déjà utilisé 
     * par un compte existant dans la base
     * @param mail, le mail à verifier
     * @return vrai si le mail est libre, false sinon
     */
	public boolean isMailAvailable(String mail){
		return verifyMail(mail);
	}
	
	public abstract void setUser(String login);
	public abstract boolean verifyMail(String mail);
	
	public static User getInstance(int persistType){
		if (user == null)
			user = PersistKit.createKit(persistType).createUser();
		return user;
	}
	
}
