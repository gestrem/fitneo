package persist;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.User;

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
	public void setUser(String login){
		
		jdbc.openConnection();
		ResultSet rs = null;
		
		try{
			String query = "SELECT username, password FROM mainuser WHERE username ='" + login + "'";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
            	this.setName(rs.getString("UserName"));
            	this.setPassword(rs.getString("Password"));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
}
