package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Service.CommentImpl;
import beans.Comment;
import beans.Visitor;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentMessage=request.getParameter("comment");
		boolean inserting=Boolean.valueOf(request.getParameter("op"));
		int episode=1,id=0;
		if (request.getParameter("episode")!=null)
		episode=Integer.parseInt(request.getParameter("episode"));
		System.out.println(episode);
		
		Visitor visitor=(Visitor)request.getSession().getAttribute("user");
		CommentImpl commentImpl=new CommentImpl();
		Comment comment =new Comment();
		try {
		if (request.getParameter("id")!=null)
			id=Integer.parseInt(request.getParameter("id"));
		else
		comment.setId(commentImpl.getNextCommentId());
		comment.setComment(commentMessage);
		comment.setUser(visitor);
		comment.setEpisode(episode);
		
			if(inserting)
			commentImpl.insert(comment);
			else{
				comment.setId(id);
				commentImpl.update(comment);
			}
			comment.setTime(new Timestamp(System.currentTimeMillis()));
		response.getWriter().print("true");
		} catch (DataAccessException | ClassNotFoundException  e) {
			e.printStackTrace();
			response.sendError(404);
		}catch( SQLException e){
			response.sendError(500);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
