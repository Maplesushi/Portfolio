package Service;

import java.util.ArrayList;

import Model.ErsReimbursement;
/**
 * Interface creates methods to be overridden in a class that implements this interface.
 * @author Dillon Meier
 */
public interface ErsReimbursementService {
	//create
	public void newReimbursement(ErsReimbursement eReimb);
	//retrieve
	public ArrayList<ErsReimbursement> getReimbursementsById(int accountId);
	public ArrayList<ErsReimbursement> getAllReimbursements();
	public ArrayList<ErsReimbursement> getFilteredReimbursements(int reqStatus);
	//update
	public void refreshReimbursement(int reqStatus, int reqId, int resolverid);
}
