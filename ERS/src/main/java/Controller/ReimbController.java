package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import Model.ErsReimbursement;
import Model.ErsReimbursementStatus;
import Service.ErsReimbursementService;
import Service.ErsReimbursementServiceImpl;

/**
 * Contains methods for receiving http requests related to the Ers Reimbursement table in the DB.
 * @author Dillon Meier
 */
public class ReimbController {
	
	/**
	* Recieves http request to create an entry in the DB for an ERS reimbursement ticket. Creates an upcasted object of the service layer. 
	* Stores the session attribute "loggedInUserId" as an int. Parses the received JSON and creates an object of the ErsReimbursement class, which 
	* has it's reimbAuthor variable overwritten with the session id and the object is sent to the service layer.
	* @author Dillon Meier
	*/
	public static void makeRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(req.getSession(false) !=null) {
		ErsReimbursementService myService = new ErsReimbursementServiceImpl();
		int userId = (int) req.getSession().getAttribute("loggedInUserId");
		ErsReimbursement eReimb = new ObjectMapper().readValue(req.getInputStream(), ErsReimbursement.class);
		eReimb.setReimbAuthor(userId);
		myService.newReimbursement(eReimb);
		}
	}
	
	/**
	 * Receives http request to return table rows from DB using the "loggedInUserId" session attribute.
	 * Sets the response type to be a JSON, creates an arraylist containing the queried results.
	 * Stringifies the JSON and uses printer.write to send it to back to the ajax request.
	 * @author Dillon Meier
	 */
	public static void pastrequests(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) !=null) {
		ErsReimbursementService myService = new ErsReimbursementServiceImpl();
		PrintWriter printer = resp.getWriter();
		int userId = (int) req.getSession().getAttribute("loggedInUserId");
		resp.setContentType("application/json");
			
		ArrayList<ErsReimbursement> reimbList = myService.getReimbursementsById(userId);
		String myJSON = new ObjectMapper().writeValueAsString(reimbList);
			
		printer.write(myJSON);	
		}
	}
	
	/**
	 * Gets an http request to return all rows from the Ers reimbursement table. Creates an object from the service layer, sets the response type, 
	 * uses a service layer method to send the request to the dao layer to return all data as an arraylist which is stringified and returned to the ajax request.
	 * @author Dillon Meier
	 */
	public static void allRequests(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("allrequests");
		if(req.getSession(false) !=null) {
		ErsReimbursementService myService = new ErsReimbursementServiceImpl();
		PrintWriter printer = resp.getWriter();
		resp.setContentType("application/json");
			
		ArrayList<ErsReimbursement> reimbList = myService.getAllReimbursements();
		String myJSON = new ObjectMapper().writeValueAsString(reimbList);
			
		printer.write(myJSON);
		}
	}
	
	/**
	 * Gets an http request to filter the request types. Saves the form parameter "requesttype" as a 
	 * string which is evaluated by 3 if statements. When one of them is true, the user is redirected to the corresponding url.
	 * @author Dillon Meier
	 */
	public static void filterRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) !=null) {
		String status = req.getParameter("requesttype");
		if(status.contentEquals("1")) {
			String myPath = "/Resource/html/pending.html";
			resp.sendRedirect(req.getContextPath()+myPath);
		}
		if(status.contentEquals("2")) {
			String myPath = "/Resource/html/approved.html";
			resp.sendRedirect(req.getContextPath()+myPath);
		}
		if(status.contentEquals("3")) {
			String myPath = "/Resource/html/denied.html";
			resp.sendRedirect(req.getContextPath()+myPath);
		}
		}
	}
	
	/**
	 * Parses JSON object into an Ers Reimbursement object and saves the status id as an int, which is then fed into the service 
	 * layer method to send a request to the dao layer to return all reimbursement requests, that have the same status id, as an arraylist.
	 * Response type is set and the arraylist is strinfied into a json which is sent back to the ajax request.
	 * @author Dillon Meier
	 */
	public static void filterRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) !=null) {
		ErsReimbursementStatus eReimb = new ObjectMapper().readValue(req.getInputStream(), ErsReimbursementStatus.class);
		ErsReimbursementService myService = new ErsReimbursementServiceImpl();
		int i = eReimb.getStatusId();
		
		ArrayList<ErsReimbursement> reimbList = myService.getFilteredReimbursements(i);
		resp.setContentType("application/json");
		String myJSON = new ObjectMapper().writeValueAsString(reimbList);
		PrintWriter printer = resp.getWriter();
		printer.write(myJSON);
		}
	}
	/**
	 * Receives a json object which is parsed into an Ers reimbursement object. The reimbursement id is saved as an int, 
	 * the attribute "loggedInUserRole" is set to an int, and another int is set to 3 which will replace the pending value in the DB.
	 * These values are fed into a service layer method which call the corresponding dao layer method to update the request in the db with 
	 * the resolver's id and the new status
	 * @author Dillon Meier
	 */
	public static void denyRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) !=null) {
		ErsReimbursement eReimb = new ObjectMapper().readValue(req.getInputStream(), ErsReimbursement.class);
		System.out.println(eReimb);
		ErsReimbursementService myService = new ErsReimbursementServiceImpl();
		int newstatus = 3;
		System.out.println(newstatus);
		int reimbid = eReimb.getReimbId();
		System.out.println(reimbid);
		int resolver = Integer.parseInt(req.getSession().getAttribute("loggedInUserRole").toString());
		myService.refreshReimbursement(newstatus, reimbid, resolver);
		}
	}
	
	/**
	 * Receives a json object which is parsed into an Ers reimbursement object. The reimbursement id is saved as an int, 
	 * the attribute "loggedInUserRole" is set to an int, and another int is set to 2 which will replace the pending value in the DB.
	 * These values are fed into a service layer method which call the corresponding dao layer method to update the request in the db with 
	 * the resolver's id and the new status
	 * @author Dillon Meier
	 */
	public static void approveRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) !=null) {
		ErsReimbursement eReimb = new ObjectMapper().readValue(req.getInputStream(), ErsReimbursement.class);
		System.out.println(eReimb);
		ErsReimbursementService myService = new ErsReimbursementServiceImpl();
		int newstatus = 2;
		System.out.println(newstatus);
		int reimbid = eReimb.getReimbId();
		System.out.println(reimbid);
		int resolver = Integer.parseInt(req.getSession().getAttribute("loggedInUserRole").toString());
		myService.refreshReimbursement(newstatus, reimbid, resolver);
		}
	}
}
