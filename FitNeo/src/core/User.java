package core;

import persist.PersistKit;
import persist.UserJDBC;
import persist.UserSerializable;
import persist.UserXML;

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
	public void login(String login, String pwd){
		setUser(login);
		if((user.getName() != null) && (user.isPassOK(pwd))){
			System.out.println("Connection autorisée pour " + login);
		}
		else
			System.out.println("Mauvais identifiants pour " + login);
	}
	
	public abstract void setUser(String login);
	
    /**
     * Methode getInstance
     * @param type le type de persistance que l'on desire
     * @return une instance de User correspondant au type de persistance choisi
     */
	public static User getInstance(int type) {

        if (user == null) {

            if (type == PersistKit.JDBC) {
            	
            	user = new UserJDBC();

            } else if (type == PersistKit.SERIALIZABLE) {

            	user = new UserSerializable();

            } else if (type == PersistKit.XML) {

            	user = new UserXML();
            }
        }

        return user;
    }
}
