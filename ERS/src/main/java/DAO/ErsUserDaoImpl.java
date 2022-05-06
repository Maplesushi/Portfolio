package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.ErsUser;
/**
 * Class implements the ErsUserDao interface and overrides methods to give them logic to communicate with the DB
 * @author Dillon Meier
 */
public class ErsUserDaoImpl implements ErsUserDao {
	private static String url = "jdbc:postgresql://databass.cwytnxvdwcpq.us-east-2.rds.amazonaws.com:5432/mydatabase";
	private static String username = "DataBass";
	private static String password = "p4ssw0rd";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username,password);
	}
	
	static { //(this would normally go into your dao layer)
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Static block has failed me");
        }
	}
	/**
	 * Retrieves "Ers User" object from the Ers User table the has both "username" AND "password" matching table column "ers_username" and "ers_password" values.
	 * Returns null if the username/password does not match or does not exist in the table.
	 * @author Dillon Meier
	 */
	@Override
	public ErsUser retrieveAccount(String username, String password) {
			try(Connection connect = getConnection()){
				PreparedStatement ps = null;
				String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";
				ps = connect.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet resultSet = ps.executeQuery();
				resultSet.next();
					System.out.println(new ErsUser(resultSet.getInt("ers_users_id"), resultSet.getString("ers_username"), resultSet.getString("ers_password"), resultSet.getString("user_first_name"), resultSet.getString("user_last_name"), resultSet.getString("user_email"), resultSet.getInt("user_role_id")));
					int ers_users_id = resultSet.getInt("ers_users_id");
					String ers_username = resultSet.getString("ers_username");
					String ers_password = resultSet.getString("ers_password");
					String user_first_name = resultSet.getString("user_first_name");
					String user_last_name = resultSet.getString("user_last_name");
					String user_email = resultSet.getString("user_email");
					int user_role_id = resultSet.getInt("user_role_id");
					ErsUser found = new ErsUser(ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id);
					return found;
			}
			catch (SQLException d) {
				d.printStackTrace();
			}
			return null;
		}
	/**
	 * Uses "resolvedBy" parameter to query "ers_users" table for row where "ers_users_id" column value = "resolvedBy".
	 * A string is set to the value of the result set's "user_first_name" and "user_last_name" column values.
	 * The String gets returned.
	 * @author Dillon Meier
	 */
	@Override
	public String retrieveFMFnLn(int resolvedBy) {
		try(Connection connect = getConnection()){
			PreparedStatement ps = null;
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, resolvedBy);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			String fnLn = resultSet.getString("user_first_name") + " " + resultSet.getString("user_last_name");
			return fnLn;
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return null;
	}
	/**
	 * Uses "authoredBy" parameter to query "ers_users" table for row where "ers_users_id" column value = "authoredBy".
	 * A string is set to the value of the result set's "user_first_name" and "user_last_name" column values.
	 * The String gets returned.
	 * @author Dillon Meier
	 */
	@Override
	public String retrieveEmpFnLn(int authoredBy) {
		try(Connection connect = getConnection()){
			PreparedStatement ps = null;
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, authoredBy);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			String fnLn = resultSet.getString("user_first_name") + " " + resultSet.getString("user_last_name");
			return fnLn;
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return null;
	}
	
}

