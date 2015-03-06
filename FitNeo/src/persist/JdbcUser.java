package persist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import core.User;

public class JdbcUser extends User{
	Connection con=null;

	public JdbcUser(String login){
		try{
			con = JdbcConnection.openConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		user = this;
		this.getUser(login);
	}
	
	public void getUser(String login){
		Statement statement = null;
		ResultSet rs = null;
		try{
			statement = con.createStatement();
			// Execute a SELECT query on Oracle
            rs = statement.executeQuery("SELECT username, password FROM mainuser WHERE username ='" + login + "'");
            if (rs.next()){
            	this.setName(rs.getString("UserName"));
            	this.setPassword(rs.getString("Password"));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			JdbcConnection.close(statement);
			JdbcConnection.close(rs);
			JdbcConnection.closeConnection();
		}
	}
}
