package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Contains variables that can be used to connect to a DB and a method to create a connection to that DB using the variables.
 * @author Dillon Meier
 */
public class ConnectionFactory {
	private static String url = "jdbc:postgresql://"+System.getenv("AWS_URL")+"/mydatabase";
	private static String username = System.getenv("DB_USER");
	private static String password = System.getenv("DB_PASS");
	
	/**
	 * Uses variables in ConnectionFactory to open a connection to the DB.
	 * @author Dillon Meier
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username,password);
	}
	
}
