package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ErsReimbursement;
import Utility.ConnectionFactory;
/**
 * Class implements the ErsReimbursementService interface and overrides methods to give them logic to communicate with the DB
 * @author Dillon Meier
 */
public class ReimbDaoImpl implements ReimbDao {

	static { //(this would normally go into your dao layer)
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Static block has failed me");
        }
	}
	/**
	 * Uses parameter "accountId" to edit a sql statement that returns all rows in the "ers_reimbursement" table that 
	 * has a "reimb_author" column value of "accountId". The returned values are put into an arraylist which is then returned.
	 * @author
	 */
	@Override
	public ArrayList<ErsReimbursement> retrieveReimbursementsById(int accountId) {
		try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ? ORDER BY REIMB_SUBMITTED ASC";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			ArrayList<ErsReimbursement> list = new ArrayList<ErsReimbursement>();
			while(rs.next()) {
				ErsReimbursement emb = new ErsReimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_Author"), rs.getFloat("reimb_amount"), rs.getString("reimb_submitted"), rs.getString("reimb_resolved"), rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"), rs.getInt("reimb_type_id"), rs.getInt("reimb_status_id"));
				System.out.println(emb);
				list.add(emb);
			}	
			return list;
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return null;
	}
	/**
	 * Uses parameter "eReimb" to edit a sql statement that creates a row in the "ers_reimbursement" table.
	 * @author
	 */
	@Override
	public void createReimbursement(ErsReimbursement eReimb) {
		try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
			String sql = "INSERT INTO ers_reimbursement VALUES(DEFAULT, ROUND(CAST(? AS DECIMAL), 2), NOW(), NULL, ?, ?, NULL, ?, ?)";
			ps = connect.prepareStatement(sql);
			ps.setFloat(1, eReimb.getReimbAmt());
			ps.setString(2, eReimb.getReimbDescription());
			ps.setInt(3, eReimb.getIntReimbAuthor());
			ps.setInt(4, 1);
			ps.setInt(5, eReimb.getIntRequestType());
			ps.execute();
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
	}
	/**
	 * Returns all rows in the "ers_reimbursement" table. The returned values are put into an arraylist which is then returned.
	 * @author
	 */
	@Override
	public ArrayList<ErsReimbursement> retrieveAllReimbursements() {
		try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
			String sql = "SELECT * FROM ers_reimbursement ORDER BY REIMB_SUBMITTED ASC";
			ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<ErsReimbursement> list = new ArrayList<ErsReimbursement>();
			while(rs.next()) {
				list.add(new ErsReimbursement(rs.getInt("reimb_author"), rs.getFloat("reimb_amount"), rs.getString("reimb_submitted"), 
						rs.getString("reimb_resolved"), rs.getString("reimb_description"), rs.getInt("reimb_resolver"), 
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status_id")));
			}	
			return list;
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return null;
	}
	/**
	 * Uses parameter "reqStatus" to edit a sql statement that returns all rows in the "ers_reimbursement" table that 
	 * has a "reimb_status_id" column value of "reqStatus". The returned values are put into an arraylist which is then returned.
	 * @author
	 */
	@Override
	public ArrayList<ErsReimbursement> retrieveFilteredReimbursements(int reqStatus) {
		try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ? ORDER BY REIMB_SUBMITTED ASC";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, reqStatus);
			ResultSet rs = ps.executeQuery();
			ArrayList<ErsReimbursement> list = new ArrayList<ErsReimbursement>();
			while(rs.next()) {
				list.add(new ErsReimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_author"), rs.getFloat("reimb_amount"), rs.getString("reimb_submitted"), 
						rs.getString("reimb_resolved"), rs.getString("reimb_description"), rs.getInt("reimb_resolver"), 
						rs.getInt("reimb_type_id"), rs.getInt("reimb_status_id")));
			}	
			return list;
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return null;
	}
	/**
	 * Uses parameters "reqStatus, reqId, resolverid" to edit a sql statement that updates "REIMB_STATUS_ID, and reimb_resolver" vaules in the row in the "ers_reimbursement" table that 
	 * has a "REIMB_ID" column value of "reqId".
	 * @author
	 */
	@Override
	public void updateReimbursement(int reqStatus, int reqId, int resolverid) {
		try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?, reimb_resolver = ?, reimb_resolved = NOW() WHERE REIMB_ID = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, reqStatus);
			ps.setInt(2, resolverid);
			ps.setInt(3, reqId);
			ps.executeUpdate();
		}	
		catch (SQLException d) {
			d.printStackTrace();
		}
	}
}
