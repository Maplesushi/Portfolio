package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ErsUser;
import Service.ErsUserService;
import Service.ErsUserServiceImpl;
/**
 * Contains methods for receiving http requests related to the Ers User table in the DB.
 * @author Dillon Meier
 */
public class LoginController {
	
	/**
	* 	Gets http request containing a username and password. Checks to make sure the request was a post, if not then the user is redirected to the home page.
	*	Stores the username and password parameters as strings which are fed into a method which returns an account if the username AND the password match a row in the DB.
	*	If no account is retrieved then they are redirected to the home page. If they return an account, a session is created and their account information is saved as session attributes.
	*	Uses the "loggedInUserRole" attribute to determine which page to redirect them to and does so.
	*	@author Dillon Meier
	*	@return A redirect to another URL
	*/
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ErsUserService myService = new ErsUserServiceImpl();
		
		String myPath = null;

		if(!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			resp.sendRedirect(req.getContextPath()+myPath);
		}
		
		
		String username = req.getParameter("theirUsername");
		System.out.println(username);
		String password = req.getParameter("theirPassword");
		System.out.println(password);
		
		if(myService.getAccount(username, password) != null) {
			ErsUser myAccount = myService.getAccount(username, password);
			req.getSession().setAttribute("loggedInUserId", myAccount.getErs_users_id());
			req.getSession().setAttribute("loggedInUserRole", myAccount.getUser_role_id());
			if(Integer.parseInt(req.getSession().getAttribute("loggedInUserRole").toString()) == 1) {
				myPath = "/Resource/html/home.html";
				resp.sendRedirect(req.getContextPath()+myPath);
			}
			else if(Integer.parseInt(req.getSession().getAttribute("loggedInUserRole").toString()) == 2){
			myPath = "/Resource/html/fmhome.html";
			resp.sendRedirect(req.getContextPath()+myPath);	
			}
		}
		else {
			myPath = "/Resource/html/index.html";
			resp.sendRedirect(req.getContextPath()+myPath);	
		}
	}

	/**
	* 	Gets http request to "logout", redirects the user to the home page and invalidates the session.
	*	@author Dillon Meier
	*	@return A redirect to the home page
	*/
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myPath = "/index.html";
		resp.sendRedirect(req.getContextPath()+myPath);
		req.getSession().invalidate();
	}
}
