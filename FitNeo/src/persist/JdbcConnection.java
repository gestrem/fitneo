package persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection implements JdbcConstants {	
    private static Connection con = null;

    public static Connection openConnection(){
    	try {
    		// Load Oracle JDBC Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            // Connect to Oracle Database
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } 
    	catch(Exception e) {  System.out.println("Cannot access database at : " +DBURL);  } 
    	
    	return con;
    }
    
    public static void closeConnection(){
    	if(con!=null) {
    		try { con.close(); } 
    		catch (SQLException e) { e.printStackTrace(); }
    	}
    }
    
    public static Connection getConnection() { return con;}

	public static void close(Statement stmt) {
		if(stmt!=null) {
			try { stmt.close(); } 
			catch (SQLException e) { e.printStackTrace(); }
		}		
	}

	public static void close(ResultSet rs) {
		if(rs!=null) {
			try { rs.close(); } 
			catch (SQLException e) { e.printStackTrace(); }
		}	
	}
}

