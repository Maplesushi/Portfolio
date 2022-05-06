package Model;
/**
 * Contains variables that correspond to the columns in the Ers User table in the DB, constructors, getters and setters, 
 * and an overridden toString method
 * @author Dillon Meier
 */
public class ErsUser {

	int ers_users_id;
	String ersUsername;
	String ersPassword;
	String ersFirstName;
	String ersLastName;
	String ersEmail;
	int user_role_id;
	
	public ErsUser(int ers_users_id, String ersUsername, String ersPassword, String ersFirstName, String ersLastName,
			String ersEmail, int user_role_id) {
		super();
		this.ers_users_id = ers_users_id;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = ersFirstName;
		this.ersLastName = ersLastName;
		this.ersEmail = ersEmail;
		this.user_role_id = user_role_id;
	}
	public ErsUser(String ersUsername, String ersPassword) {
		super();
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
	}
	
	public ErsUser() {
		
	}
	public int getErs_users_id() {
		return ers_users_id;
	}
	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}
	public String getErsUsername() {
		return ersUsername;
	}
	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}
	public String getErsPassword() {
		return ersPassword;
	}
	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}
	public String getErsFirstName() {
		return ersFirstName;
	}
	public void setErsFirstName(String ersFirstName) {
		this.ersFirstName = ersFirstName;
	}
	public String getErsLastName() {
		return ersLastName;
	}
	public void setErsLastName(String ersLastName) {
		this.ersLastName = ersLastName;
	}
	public String getErsEmail() {
		return ersEmail;
	}
	public void setErsEmail(String ersEmail) {
		this.ersEmail = ersEmail;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	@Override
	public String toString() {
		return "ErsUser [ers_users_id=" + ers_users_id + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", ersFirstName=" + ersFirstName + ", ersLastName=" + ersLastName + ", ersEmail=" + ersEmail
				+ ", user_role_id=" + user_role_id + "]";
	}
	
	
}
