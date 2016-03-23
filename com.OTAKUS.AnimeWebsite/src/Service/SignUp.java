package Service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Dao.VisitorDao;
import beans.Visitor;

/**
 * Servlet implementation class SignUP
 */

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.sendRedirect("/");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	VisitorDao visitorDao=new VisitorDao();
	
		if (request.getParameter("username")!=null){
			Visitor visitor=new Visitor();
			visitor.setUserName(request.getParameter("username"));
			visitor.setFirstName(request.getParameter("firstName"));
			visitor.setLastName(request.getParameter("lastName"));
			visitor.setEmail(request.getParameter("email"));
			visitor.setPassword(request.getParameter("password"));
			
			if (request.getParameter("avatar")!=null)
			visitor.setImageLink(request.getParameter("avatar"));
			else if (request.getParameter("upload")!=null)
			visitor.setImageLink(request.getParameter("upload"));
			else if (request.getParameter("link")!=null)
				visitor.setImageLink(request.getParameter("link"));
			
			
			visitor.setType(request.getParameter("type"));
			try {
				if (visitorDao.insert(visitor))doGet(request, response);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
