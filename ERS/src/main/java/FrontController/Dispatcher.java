package FrontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.LoginController;
import Controller.ReimbController;
/**
 * Contains a switch case statement to interpret requests based on URI's
 * @author Dillon Meier
 */
public class Dispatcher {
	/**
	 * Switch case method to dispatch the incoming http request to the correct controller and method within.
	 * @author Dillon Meier
	 */
	public static void virtualRouter(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		switch(req.getRequestURI()) {
		case "/ERS/login/login":
			System.out.println("case 1");
			LoginController.login(req, resp);
			break;
		case "/ERS/login/logout":
			System.out.println("case 2");
			LoginController.logout(req, resp);
			break;
		case "/ERS/json/pastrequests":
			System.out.println("case 3");
			ReimbController.pastrequests(req, resp);
			break;
		case "/ERS/json/newrequest":
			System.out.println("case 4");
			ReimbController.makeRequest(req, resp);
			break;
		case "/ERS/json/allrequests":
			System.out.println("case 5");
			ReimbController.allRequests(req, resp);
			break;
		case "/ERS/json/filterredirect":
			System.out.println("case 6");
			ReimbController.filterRedirect(req, resp);
			break;
		case "/ERS/json/filterrequest":
			System.out.println("case 7");
			ReimbController.filterRequest(req, resp);
			break;
		case "/ERS/json/approverequest":
			System.out.println("case 8");
			ReimbController.approveRequest(req, resp);
			break;
		case "/ERS/json/denyrequest":
			System.out.println("case 9");
			ReimbController.denyRequest(req, resp);
			break;
		default:
			String myPath = "/Resource/html/urlnogood.html";
			resp.sendRedirect(req.getContextPath()+myPath);
		}
	}
}
