package DAO;

import Model.ErsUser;
/**
 * Interface creates methods to be overridden in a class that implements this interface.
 * @author Dillon Meier
 */
public interface ErsUserDao {
	// crud
	// create
	
	// retrieve
	public ErsUser retrieveAccount(String username, String password);
	public String retrieveFMFnLn(int resolvedBy);
	public String retrieveEmpFnLn(int authoredBy);
	// update
	
	// delete
	
}
