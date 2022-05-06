package FrontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ErsUserDao;
import DAO.ErsUserDaoImpl;
/**
 * Receives http requests and sends GET and POST requests to the dispatcher.
 * @author Dillon Meier
 */
@WebServlet(name="MasterServlet", urlPatterns= {"/master/*", "/json/*", "/forwarding/*", "/redirecting/*", "/login/*"})
public class MasterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Dispatcher.virtualRouter(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Dispatcher.virtualRouter(req, resp);
	}
}
