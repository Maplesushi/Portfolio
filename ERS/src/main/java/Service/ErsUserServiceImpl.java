package Service;

import DAO.ErsUserDao;
import DAO.ErsUserDaoImpl;
import Model.ErsUser;
/**
 * Class implements the ErsUserService interface and overrides methods to give them logic which calls 
 * methods from an upcasted ErsUserDaoImpl object.
 * @author Dillon Meier
 */
public class ErsUserServiceImpl implements ErsUserService {
	ErsUserDao myDao = new ErsUserDaoImpl();
	/**
	 * Returns value return by the ErsUserDaoImpl method "retrieveAccount()"
	 * @author Dillon Meier
	 */
	@Override
	public ErsUser getAccount(String username, String password) {
		return myDao.retrieveAccount(username, password);
	}
	/**
	 * Returns value return by the ErsUserDaoImpl method "retrieveFMFnLn()"
	 * @author Dillon Meier
	 */
	@Override
	public String getFMFnLn(int resolvedBy) {
		return myDao.retrieveFMFnLn(resolvedBy);
	}
	/**
	 * Returns value return by the ErsUserDaoImpl method "retrieveEmpFnLn()"
	 * @author Dillon Meier
	 */
	@Override
	public String getEmpFnLn(int authoredBy) {
		return myDao.retrieveEmpFnLn(authoredBy);
	}

}
