package persist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import core.User;

public class JdbcUser extends JdbcConnection{

	public User getUser(String login){
		Connection con = null;
		User user = null;
		Statement statement = null;
		ResultSet rs = null;
		try{
			con = openConnection();
			
			statement = con.createStatement();
			// Execute a SELECT query on Oracle
            rs = statement.executeQuery("SELECT username, password FROM mainuser WHERE username ='"+login+"'");
            if (rs.next())
            	user = new User(rs.getString("UserName"), rs.getString("Password"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			close(statement);
			close(rs);
			closeConnection();
		}
		return user;
	}
}
