package Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Dao.AnimeDao;
import beans.Alias;
import beans.Anime;
import beans.Type;

/**
 * Servlet implementation class UpdateAnime
 */
@WebServlet("/UpdateAnime")
public class UpdateAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("name")!=null){
			Anime anime=null;
			AnimeDao animeDao=new AnimeDao();
			try {
				anime =animeDao.get(request.getParameter("name"));
			
			} catch (DataAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List list=new ArrayList<Alias>();
			String[] alias=request.getParameter("allias").split(",");
			for (String alia : alias)
				list.add(new Alias(anime.getAnimeId(),alia));
			anime.setAlias(list);
			
				list=new ArrayList<Type>();
				String[] types=request.getParameter("types").split(",");
				for (String type : types)
				list.add(new Type(type));
				anime.setGenre(list);
				anime.setDescription(request.getParameter("desc"));
				anime.setImageLink(request.getParameter("imgLink"));
				anime.setStatue(Integer.parseInt(request.getParameter("statue")));
				
				try {
					animeDao.update(anime);
				} catch (DataAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		doGet(request, response);
	}

	}}
