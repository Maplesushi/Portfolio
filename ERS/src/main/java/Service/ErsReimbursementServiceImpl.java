package Service;

import java.util.ArrayList;

import DAO.ReimbDao;
import DAO.ReimbDaoImpl;
import Model.ErsReimbursement;
/**
 * Class implements the ErsReimbursementService interface and overrides methods to give them logic which calls 
 * methods from an upcasted ReimbDaoImpl object.
 * @author Dillon Meier
 */
public class ErsReimbursementServiceImpl implements ErsReimbursementService {

	ReimbDao myDao = new ReimbDaoImpl();
	/**
	 * Returns value returned by the ReimbDaoImpl method "retrieveReimbursementsById()"
	 * @author Dillon Meier
	 */
	@Override
	public ArrayList<ErsReimbursement> getReimbursementsById(int accountId) {
		return myDao.retrieveReimbursementsById(accountId);
	}
	/**
	 * Calls ReimbDaoImpl method "createReimbursement()"
	 * @author Dillon Meier
	 */
	@Override
	public void newReimbursement(ErsReimbursement eReimb) {
		myDao.createReimbursement(eReimb);
	}
	/**
	 * Returns value returned by the ReimbDaoImpl method "retrieveAllReimbursements()"
	 * @author Dillon Meier
	 */
	@Override
	public ArrayList<ErsReimbursement> getAllReimbursements() {
		return myDao.retrieveAllReimbursements();
	}
	/**
	 * Returns value returned by the ReimbDaoImpl method "retrieveFilteredReimbursements()"
	 * @author Dillon Meier
	 */
	@Override
	public ArrayList<ErsReimbursement> getFilteredReimbursements(int reqStatus) {
		return myDao.retrieveFilteredReimbursements(reqStatus);
	}
	/**
	 * Calls ReimbDaoImpl method "updateReimbursement()"
	 * @author Dillon Meier
	 */
	@Override
	public void refreshReimbursement(int reqStatus, int reqId, int resolverid) {
		myDao.updateReimbursement(reqStatus, reqId, resolverid);
	}
}
