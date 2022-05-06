package Model;

import Service.ErsUserService;
import Service.ErsUserServiceImpl;
/**
 * Contains variables that correspond to the columns in the Ers Reimbursement table in the DB, constructors, getters and setters, 
 * and an overridden toString method
 * @author Dillon Meier
 */
public class ErsReimbursement {

	int reimbId;
	int reimbAuthor;
	float reimbAmt;
	String reimbSumbitted;
	String reimbResolved;
	String reimbDescription;
	int resolvedBy;
	int requestType;
	int requestStatus;

	public ErsReimbursement(int reimbId, int reimbAuthor, float reimbAmt, String reimbSumbitted, String reimbResolved,
			String reimbDescription, int resolvedBy, int requestType, int requestStatus) {
		super();
		this.reimbId = reimbId;
		this.reimbAuthor = reimbAuthor;
		this.reimbAmt = reimbAmt;
		this.reimbSumbitted = reimbSumbitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.resolvedBy = resolvedBy;
		this.requestType = requestType;
		this.requestStatus = requestStatus;
	}

	public ErsReimbursement(int reimbAuthor, float reimbAmt, String reimbSumbitted, String reimbResolved,
			String reimbDescription, int resolvedBy, int requestType, int requestStatus) {
		super();
		this.reimbAuthor = reimbAuthor;
		this.reimbAmt = reimbAmt;
		this.reimbSumbitted = reimbSumbitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.resolvedBy = resolvedBy;
		this.requestType = requestType;
		this.requestStatus = requestStatus;
	}

	public ErsReimbursement(float reimbAmt, String reimbSumbitted, String reimbResolved, String reimbDescription,
			int resolvedBy, int requestType, int requestStatus) {
		super();
		this.reimbAmt = reimbAmt;
		this.reimbSumbitted = reimbSumbitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.resolvedBy = resolvedBy;
		this.requestType = requestType;
		this.requestStatus = requestStatus;
	}

	public ErsReimbursement(float reimbAmt, String reimbDescription, int requestType) {
		this.reimbAmt = reimbAmt;
		this.reimbDescription = reimbDescription;
		this.requestType = requestType;
	}

	public ErsReimbursement(int requestStatus, int reimbId) {
		this.reimbId = reimbId;
		this.requestStatus = requestStatus;
	}

	public ErsReimbursement() {

	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public String getReimbAuthor() {
		ErsUserService myService = new ErsUserServiceImpl();

		return myService.getEmpFnLn(reimbAuthor);
	}

	public int getIntReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public float getReimbAmt() {
		return reimbAmt;
	}

	public void setReimbAmt(float reimbAmt) {
		this.reimbAmt = reimbAmt;
	}

	public String getReimbSumbitted() {
		return reimbSumbitted;
	}

	public void setReimbSumbitted(String reimbSumbitted) {
		this.reimbSumbitted = reimbSumbitted;
	}

	public String getReimbResolved() {
		if (reimbResolved == null) {
			return "Unresolved";
		} else {
			return reimbResolved;
		}
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getResolvedBy() {
	  ErsUserService myService = new ErsUserServiceImpl();
	  if (resolvedBy == 0) {
		  return "N/A"; }
		  
	  else { 
		  return myService.getFMFnLn(resolvedBy); 
	  }
	}

	public void setResolvedBy(int resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getRequestType() {
		if (requestType == 1) {
			return "Lodging";
		} else if (requestType == 2) {
			return "Travel";
		} else if (requestType == 3) {
			return "Food";
		} else {
			return "Other";
		}
	}

	public int getIntRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		if (requestType == "Lodging") {
			this.requestType = 1;
		} else if (requestType == "Travel") {
			this.requestType = 2;
		} else if (requestType == "Food") {
			this.requestType = 3;
		} else {
			this.requestType = 4;
		}
	}

	public String getRequestStatus() {
		if (requestStatus == 1) {
			return "Pending";
		} else if (requestStatus == 2) {
			return "Approved";
		} else {
			return "Denied";
		}
	}

	public int getIntRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		if (requestStatus == "Pending") {
			this.requestStatus = 1;
		} else if (requestStatus == "Approved") {
			this.requestStatus = 2;
		} else if (requestStatus == "Denied") {
			this.requestStatus = 3;
		}
	}

	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", reimbAuthor=" + reimbAuthor + ", reimbAmt=" + reimbAmt
				+ ", reimbSumbitted=" + reimbSumbitted + ", reimbResolved=" + reimbResolved + ", reimbDescription="
				+ reimbDescription + ", resolvedBy=" + resolvedBy + ", requestType=" + requestType + ", requestStatus="
				+ requestStatus + "]";
	}

}
