package persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection implements JdbcConstants {	
	
    private Statement streamConnection;
    private ResultSet streamResponse;

    public boolean openConnection(){
    	try {
    		// Charge le driver JDBC pour mysql
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            // Creation de la connection à la base
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            this.streamConnection = con.createStatement();
        } 
    	catch(Exception e) {  
    		System.out.println("Cannot access database at : " +DBURL); 
    		return false;  
    	} 
    	
    	return true;
    }
    
    /**
     * Methode close qui ferme la connexion SQL
     */
	public void close() {
		try{
			if(this.streamResponse != null) 
				this.streamResponse.close();
			this.streamConnection.close();
		}
		catch (SQLException e) { e.printStackTrace(); }		
	}
	
    /**
     * Methode executeRequest
     * @param sqlRequest la requete
     * @return true si l'execution c'est bien passe, false sinon
     */
	public boolean executeRequest(String sqlRequest) {
        try {
        	//s'il s'agit d'une requete SELECT il faut utiliser executeQuery()
            if (sqlRequest.substring(0, 6).equalsIgnoreCase("SELECT")) {
                this.streamResponse = this.streamConnection.executeQuery(sqlRequest);
            } 
            //sinon pour tout autre requete (DELETE, UPDATE, INSERT) on utilise executeUpdate()
            else {
                this.streamConnection.executeUpdate(sqlRequest);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();           
            return false;
        }
        return true;
    }
	
    /**
     * Methode fetchArray
     * @return le tuple sous forme d'un ResultSet
     */
	public ResultSet fetchArray() {  
        try {
            if (this.streamResponse.next()) {
            	System.out.println("hello");
            	return this.streamResponse;              
            } 
            else {
                return null;
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
    /**
     * Methode nbResponse
     * @return le nombre de tuple de la requete
     */
	public int nbResponse() {      
        ResultSet resultSet = this.streamResponse;
        int size = 0;
        try {
            resultSet.last();
            size = resultSet.getRow();        
        } catch (SQLException e) {
            return 0;
        }
        return size;
    }	
}

