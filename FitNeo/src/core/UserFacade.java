package core;

import java.util.ArrayList;
/**
 * 
 * @author Florent
 *
 */
public class UserFacade {
	private User user;
	
	public UserFacade(int persistType){
		//On crée un user du type de persistance choisi
		user = User.getInstance(persistType);
		System.out.println(user.getUserEmail());
	}
	
	public User login(String login, String pwd){
		return user.login(login, pwd);
	}
	
	public boolean isMailAvailable(String mail){
		return user.isMailAvailable(mail);
	}
	
	public void signin(String userLastName, String userFirstName, String userAdresse, String userCity, String userCP, String userEmail, String passwordUser, String userAnswer, int idquestion){
		user.signin(userLastName, userFirstName, userAdresse, userCity, userCP, userEmail, passwordUser, userAnswer, idquestion);
	}
	
	public String reinitializePassword(String mail){
		return user.reinitializePassword(mail);
	}
	
	public String getUserCP(){
		return user.getUserCP();
	}
	
	public String getUserEmail() {
		return user.getUserEmail();
	}
	
	public String getUserCity() {
		return user.getUserCity();
	}
	
	public String getUserAdresse() {
		return user.getUserAdresse();
	}
	
	public String getUserLastName() {
		return user.getUserLastName();
	}
	
	public String getUserFirstName() {
		return user.getUserFirstName();
	}
	
	public boolean isRoleParticipant() {
		return user.isRoleParticipant();
	}
	
	public boolean isRoleMember() {
		return user.isRoleMember();
	}
	
	public boolean isRoleManager() {
		return user.isRoleManager();
	}
	
	public boolean isRoleAdmin() {
		return user.isRoleAdmin();
	}
	
	public int getIdUser(){
		return user.getIdUser();
	}
	
	public void loadInscriptions(){
		user.loadInscription();
	}
	
	public ArrayList<Inscription> getInscriptions(){
		return user.getInscriptions();
	}
	
	public void unscribeEvent(int idevent){
		user.unscribeEvent(idevent);
	}
	
	public void subscribeEvent(int idevent){
		user.subscribeEvent(idevent);
	}
	
}
