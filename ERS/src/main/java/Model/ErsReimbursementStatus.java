package Model;

public class ErsReimbursementStatus {

	int statusId;

	public ErsReimbursementStatus(int statusId) {
		super();
		this.statusId = statusId;
	}
	public ErsReimbursementStatus() {
		
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "ErsReimbursementStatus [statusId=" + statusId + "]";
	}
	
	
}
