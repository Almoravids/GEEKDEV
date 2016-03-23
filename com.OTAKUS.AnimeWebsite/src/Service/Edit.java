package Service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Dao.VisitorDao;
import beans.Visitor;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		httpResponse.sendRedirect("/edit");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisitorDao visitorDao=new VisitorDao();
		Visitor visitor=(Visitor)request.getSession().getAttribute("user");
		if (request.getParameter("firstName")!=null){
			if (request.getParameter("fpass").equals(visitor.getPassword())){
				visitor.setFirstName(request.getParameter("firstName"));
			try {
				visitorDao.update(visitor);
			} catch (DataAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
		else if (request.getParameter("lastName")!=null){
			if (request.getParameter("fpass").equals(visitor.getPassword())){
				visitor.setLastName(request.getParameter("lastName"));
			try {
				visitorDao.update(visitor);
			} catch (DataAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		else if (request.getParameter("email")!=null){
			if (request.getParameter("fpass").equals(visitor.getPassword())){
				visitor.setEmail(request.getParameter("email"));
			try {
				visitorDao.update(visitor);
			} catch (DataAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		else if (request.getParameter("Npass")!=null){
			if (request.getParameter("Opass").equals(visitor.getPassword())){
				visitor.setPassword(request.getParameter("Npass"));
			try {
				visitorDao.update(visitor);
			} catch (DataAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
		doGet(request, response);
	}

}
