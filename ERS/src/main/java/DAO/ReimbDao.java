package DAO;

import java.util.ArrayList;

import Model.ErsReimbursement;
/**
 * Interface creates methods to be overridden in a class that implements this interface.
 * @author Dillon Meier
 */
public interface ReimbDao {

	//create
	public void createReimbursement(ErsReimbursement eReimb);
	//Retrieve
	public ArrayList<ErsReimbursement> retrieveReimbursementsById(int accountId);
	public ArrayList<ErsReimbursement> retrieveAllReimbursements();
	public ArrayList<ErsReimbursement> retrieveFilteredReimbursements(int reqStatus);
	//update
	public void updateReimbursement(int reqStatus, int reqId, int resolverid);
}