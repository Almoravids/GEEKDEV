package Service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VisitorDao;
import beans.Visitor;

/**
 * Servlet implementation class SignIn
 */

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && username != "" && password != null)
			try {
				if (logIn(request, request.getParameter("username"), request.getParameter("password")))
					doGet(request, response);
				else
					response.sendRedirect("/signin");
			} catch (Exception e) {
				response.sendRedirect("/signin");
			}

	}

	public boolean logIn(HttpServletRequest request, String user, String password)
			throws ClassNotFoundException, SQLException {
		VisitorDao visitorDao = new VisitorDao();
		Visitor visitor = visitorDao.get(user);
		if (visitor != null && visitor.getPassword().equals(password)) {
			request.getSession().setAttribute("user", visitor);
			return true;
		} else
			return false;
	}
}
