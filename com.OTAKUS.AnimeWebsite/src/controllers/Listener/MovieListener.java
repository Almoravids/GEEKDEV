package controllers.Listener;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Service.MovieImpl;
import Service.Tools;
import beans.Movie;
import beans.Visitor;

/**
 * Servlet implementation class MovieListener
 */
@WebServlet("/Movies")
public class MovieListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 MovieImpl movieImpl = new MovieImpl();
		 Visitor user = (Visitor) request.getSession().getAttribute("user");
		 String search= request.getParameter("search");
		 String  jsObject=Tools.toJSObject(new Movie());
		try {
			if (request.getParameter("action").equals("recomanded")) {

				response.getWriter().println(jsObject+" "+Tools.listJSInstance(movieImpl.getRecommanded()));
			} else if (request.getParameter("action").equals("watched")) {

				response.getWriter().println(jsObject+" "+Tools.listJSInstance(movieImpl.getWatched(user.getUserName())));
			}else if (request.getParameter("action").equals("name")) {

				response.getWriter().println(jsObject+" "+Tools.listJSInstance(movieImpl.searchByAllias(search)));
				;
			}else if (request.getParameter("action").equals("tag")) {
				response.getWriter().println(jsObject+" "+Tools.listJSInstance(movieImpl.searchByType(search)));
			}

		} catch (DataAccessException | ClassNotFoundException e) {
			response.sendError(404);
			e.printStackTrace();
		} catch (SQLException e) {
			response.sendError(500);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
