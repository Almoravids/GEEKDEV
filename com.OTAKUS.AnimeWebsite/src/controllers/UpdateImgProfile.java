package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Service.UserImpl;
import beans.Visitor;

/**
 * Servlet implementation class UpdateImgProfile
 */
@WebServlet("/UpdateImgProfile")
public class UpdateImgProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateImgProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserImpl userImpl = new UserImpl();
		Visitor visitor = (Visitor) request.getSession().getAttribute("user");
		System.out.println(visitor.getEmail());
			visitor.setImageLink(request.getParameter("img"));
		request.getSession().setAttribute("user", visitor);
		try {
			userImpl.update(visitor);
		} catch (DataAccessException | ClassNotFoundException | SQLException e) {
			response.sendError(500);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
