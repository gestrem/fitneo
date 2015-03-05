package persist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public interface IJdbcConnection extends JdbcConstants {
	Connection openConnection() throws SQLException;

	void closeConnection();

	Connection getConnection();

	void close(Statement stmt);
	
	void close(ResultSet rs);
}
