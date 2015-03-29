package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Inscription;
import core.User;

/**
 * class UserJDBC.java
 * @author Florent Guillaume
 */
public class UserJDBC extends User{
	
	private JdbcConnection jdbc = null;

	public UserJDBC(){
		jdbc = new JdbcConnection();
	}
	
    /**
     * Methode setUser qui essaye d'initialiser le singleton user 
     * en allant chercher les infos sur l'user dans la base de donnée.
     * Si l'user n'existe pas, l'user est null.
     * @param login le login donné par l'user
     */
	@Override
	public void setUser(String login){
		
		jdbc.openConnection();
		ResultSet rs = null;

		
		try{
			String query = "SELECT * FROM mainuser WHERE userEmail ='" + login + "'";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				this.setIdUser(rs.getInt("idUser"));
				this.setUserFirstName(rs.getString("userFirstName"));
            	this.setUserLastName(rs.getString("userLastName"));
            	this.setUserAdresse(rs.getString("userAdresse"));
            	this.setUserCity(rs.getString("userCity"));
            	this.setUserCP(rs.getString("userCP"));
            	this.setUserEmail(rs.getString("userEmail"));
            	this.setPasswordUser(rs.getString("passwordUser"));
            	this.setRoleAdmin(rs.getBoolean("roleAdmin"));
            	this.setRoleParticipant(rs.getBoolean("roleParticipant"));
            	this.setRoleMember(rs.getBoolean("roleMember"));
            	this.setRoleManager(rs.getBoolean("roleManager"));
            	this.setUserAnswer(rs.getString("answer"));
            	this.setIdquestion(rs.getInt("idquestion"));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
    /**
     * Methode verifyMail qui verifie si le mail passé en parametre existe en base
     * @param mail, le mail a verifier
     * @return result, vrai si mail inconnu, false sinon
     */
	@Override
	public boolean verifyMail(String mail){
		jdbc.openConnection();
		boolean result = true;
		try{
			String query ="SELECT userEmail from mainuser WHERE userEmail ='" + mail + "'";
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(jdbc.nbResponse() != 0)
			result = false;
		jdbc.close();
		return result;
	}
	
    /**
     * Methode registerUser qui insere un nouvel utilisateur dans la base
     * @param userLastname
     * @param userFirstName
     * @param userAdresse
     * @param userCity
     * @param userCP
     * @param userEmail
     * @param passwordUser
     * @param userAnswer
     * @param idquestion
     */
	@Override
	public void registerUser(String userLastName, String userFirstName, String userAdresse, String userCity, String userCP, String userEmail, String passwordUser, String userAnswer, int idquestion){
		jdbc.openConnection();
		try{
			String query1 ="INSERT INTO mainuser(userFirstName, userLastName, userAdresse, userCity, userCP, userEmail, passwordUser, roleAdmin, roleParticipant, rolemember, roleManager, answer, idquestion) "
					+ "values('"+userFirstName+"','"+userLastName+"','"+userAdresse+"','"+userCity+"','"+userCP+"','"+userEmail+"','"+passwordUser+"', 0, 0, 0, 0, '"+userAnswer+"','"+idquestion+"')";
			jdbc.executeRequest(query1);
			String query2 = "INSERT INTO basket(idUser, active_basket) values("+getUserId(userEmail)+",true)";
			jdbc.executeRequest(query2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}

    /**
     * Methode getUserId qui renvoi l'id d'un user en fonction de son mail
     * @param mail, le mail de l'user
     * @return id, l'id de l'user qui possede cet email
     */
	public int getUserId(String mail){
		jdbc.openConnection();
		int id=0;
		ResultSet rs = null;
		try{
			String query ="SELECT idUser from mainuser WHERE userEmail ='" + mail + "'";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				id = rs.getInt("idUser");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
		return id;
	}
	
    /**
     * Methode changePassword, change le mot de passe de l'utilisateur. 
     * La methode genere un nouveau mot de passe, l'insere dans la base et le renvoi a l'utilisateur
     * @param mail, le mail de l'utilisateur
     * @return newpass, le nouveau mot de passe
     */
	@Override
	public String changePassword(String mail) {
		jdbc.openConnection();
		String newpass=null;
		ResultSet rs = null;
		try{
			String query ="SELECT passwordUser from mainuser WHERE userEmail ='" + mail + "'";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				newpass=rs.getString("passworduser");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
		return newpass;
	}

    /**
     * Methode loadInscription, charge la liste des inscriptions aux evenement
     */
	@Override
	public void loadInscription() {
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			ArrayList<Inscription> listInscription = new ArrayList<Inscription>();
			String query = "SELECT eventName, dateinscription, event.eventDate, event.idEvent FROM inscription, event WHERE event.idEvent=inscription.idevent AND idmember="+this.getIdUser();
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				listInscription.add(new Inscription(rs.getString("eventName"), rs.getString("eventDate"), rs.getString("dateinscription"), rs.getInt("idEvent"))); 	
			}
			this.setInscriptions(listInscription);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
    /**
     * Methode subscribeEvent, methode qui permet a un utilisateur de s'inscrire a un evenement
     * @param idevent, l'id de l'evenement auquel on s'inscrit
     */
	public void subscribeEvent(int idevent){
		jdbc.openConnection();		
		try{
			String query = "INSERT INTO inscription VALUES ("+this.getIdUser()+","+idevent+",curdate())";
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
    /**
     * Methode unscribeEvent, methode qui permet a un utilisateur de se desinscrire d'un evenement
     * @param idevent, l'id de l'evenement auquel on se desinscrit
     */
	public void unscribeEvent(int idevent){
		jdbc.openConnection();		
		try{
			String query = "DELETE FROM inscription WHERE idmember="+this.getIdUser()+" AND idevent="+idevent;
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jdbc.close();
	}
}
