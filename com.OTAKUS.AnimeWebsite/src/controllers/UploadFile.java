package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.dao.DataAccessException;

import Service.Tools;
import Service.UserImpl;
import beans.Visitor;

/**
 * Servlet implementation class UpdateImgProfile
 */
@WebServlet("/UploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Visitor visitor=(Visitor) request.getSession().getAttribute("user");
		UserImpl userImpl=new UserImpl();
		Part filePart=request.getPart("fileUpload");
		try {
		if (Objects.nonNull(visitor)){ 
			if (Objects.nonNull(filePart)&&!filePart.getSubmittedFileName().equals("")){

				String imageLink="/Image/Avatars/Users/"+visitor.getUserName()+".png";
				filePart=request.getPart("fileUpload");
				if (Tools.saveImage(request.getRealPath(imageLink), filePart)){
					visitor.setImageLink(imageLink);
				
				}
				userImpl.update(visitor);
			}else if (Objects.nonNull(request.getParameter("link"))&&!request.getParameter("link").equals("")){
				visitor.setImageLink(request.getParameter("link"));
				userImpl.update(visitor);
			}else if (Objects.nonNull(request.getParameter("avatar"))&&!request.getParameter("avatar").equals("")){
				visitor.setImageLink(request.getParameter("avatar"));
				userImpl.update(visitor);
			}
		System.out.println("avatar"+request.getParameter("avatar"));
				
		}} catch (DataAccessException | ClassNotFoundException e) {
				response.sendError(404);
				e.printStackTrace();
			}	catch(SQLException e){
				response.sendError(500);
				e.printStackTrace();
			}

		doGet(request, response);
		}
	}


