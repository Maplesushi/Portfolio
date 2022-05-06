package Service;

import Model.ErsUser;
/**
 * Interface creates methods to be overridden in a class that implements this interface.
 * @author Dillon Meier
 */
public interface ErsUserService {
	// retrieve
	public ErsUser getAccount(String username, String password);
	public String getFMFnLn(int resolvedBy);
	public String getEmpFnLn(int authoredBy);
}
