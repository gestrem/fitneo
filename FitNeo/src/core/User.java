package core;

import persist.PersistKit;

public abstract class User {
	
	private String userFirstName;
	private String userLastName;
	private String userAdresse;
	private String userCity;
	private String userCP;
	private String userEmail;
	private String passwordUser;
	private String userAnswer;
	private int idquestion;
	
	private boolean roleAdmin;
	private boolean roleManager;
	private boolean roleMember;
	private boolean roleParticipant;
	
	private static User user = null;
	
	public User(){
	}
		
    public boolean isRoleParticipant() {
		return roleParticipant;
	}

	public void setRoleParticipant(boolean roleParticipant) {
		this.roleParticipant = roleParticipant;
	}

	public boolean isRoleMember() {
		return roleMember;
	}

	public void setRoleMember(boolean roleMember) {
		this.roleMember = roleMember;
	}

	public boolean isRoleManager() {
		return roleManager;
	}

	public void setRoleManager(boolean roleManager) {
		this.roleManager = roleManager;
	}

	public boolean isRoleAdmin() {
		return roleAdmin;
	}

	public void setRoleAdmin(boolean roleAdmin) {
		this.roleAdmin = roleAdmin;
	}

	public int getIdquestion() {
		return idquestion;
	}

	public void setIdquestion(int idquestion) {
		this.idquestion = idquestion;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getUserCP() {
		return userCP;
	}

	public void setUserCP(String userCP) {
		this.userCP = userCP;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserAdresse() {
		return userAdresse;
	}

	public void setUserAdresse(String userAdresse) {
		this.userAdresse = userAdresse;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	/**
     * Methode isPassOK
     * @param pwd le mot de passe donnée par l'utilisateur
     * @return un boolean true si le mot de passe correspond
     * au mot de passe en base de donnée. Renvoi false sinon.
     */
	public boolean isPassOK(String pwd){
		return this.passwordUser.equals(pwd);
	}
	
    /**
     * Methode login, essaye d'initialiser un user 
     * avec les informations données par l'utilisateur puis fais une comparaison
     * @param login le login donné par l'utilisateur
     * @param pwd le mot de passe donné par l'utilisateur
     */
	public User login(String login, String pwd){
		setUser(login);
		if((user.getUserEmail() != null) && (user.isPassOK(pwd))){
			return user;
		}
		else{
			return null;
		}
	}
	
	public void signin(String userLastName, String userFirstName, String userAdresse, String userCity, String userCP, String userEmail, String passwordUser, String userAnswer, int idquestion){
		registerUser(userLastName, userFirstName, userAdresse, userCity, userCP, userEmail, passwordUser, userAnswer, idquestion);
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
	
	public String reinitializePassword(String mail){
		return changePassword(mail);
	}
	
	public static User getInstance(int persistType){
		if (user == null)
			user = PersistKit.createKit(persistType).createUser();
		return user;
	}
	
	public abstract String changePassword(String mail);
	public abstract void setUser(String login);
	public abstract boolean verifyMail(String mail);
	public abstract void registerUser(String userLastName, String userFirstName, String userAdresse, String userCity, String userCP, String userEmail, String passwordUser, String userAnswer, int idquestion);
	
}
