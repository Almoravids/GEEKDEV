package controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VisitorDao;
import Service.UserImpl;
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
				if (logIn(request,response, request.getParameter("username"), request.getParameter("password")))
					doGet(request, response);
				else
					response.sendRedirect("/signin");
			} catch (SQLException | ClassNotFoundException e) {
				response.sendError(404);
			}catch (Exception e) {
				response.sendRedirect("/signin");
			}

	}

	public boolean logIn(HttpServletRequest request, HttpServletResponse response, String user, String password)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		UserImpl visitorImpl = new UserImpl();
		Visitor visitor = visitorImpl.get(user);
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("md5");

			digest.update(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (visitor != null && visitor.getPassword().equals(new BigInteger(digest.digest()).toString(16))) {
			request.getSession().setAttribute("user", visitor);
			Cookie cookieUsername=new Cookie("username", visitor.getUserName());
			cookieUsername.setMaxAge(60*60*60*7);
			response.addCookie(cookieUsername);
			digest.digest(visitor.getUserName().getBytes());
		
			Cookie cookieSecureUsername=new Cookie("id",new BigInteger(digest.digest()).toString(16));
			cookieSecureUsername.setMaxAge(60*60*60*7);
			response.addCookie(cookieSecureUsername);
			return true;
		} else
			return false;
	}
}
