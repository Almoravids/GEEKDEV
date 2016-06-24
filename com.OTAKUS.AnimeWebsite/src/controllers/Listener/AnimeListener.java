package controllers.Listener;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Service.AnimeImpl;
import Service.EpisodeImpl;
import Service.SeasonImpl;
import Service.Tools;
import beans.Alias;
import beans.Anime;
import beans.Episode;
import beans.Season;
import beans.Type;

/**
 * Servlet implementation class AnimeListener
 */
@WebServlet("/Animes")
public class AnimeListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnimeListener() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Anime anime=new Anime();
		// AnimeImpl animeImpl=new AnimeImpl();
		String animeName = null;
		if (Objects.nonNull(request.getParameter("anime")))
			animeName = request.getParameter("anime");
		try {

			String jsObjects = "", jsInstance = "";

			AnimeImpl animeImpl = new AnimeImpl();
			SeasonImpl seasonImpl = new SeasonImpl();
			EpisodeImpl episodeImpl = new EpisodeImpl();
			Anime anime;

			anime = animeImpl.get(animeName);
			anime.setSeasons(seasonImpl.getAll(anime.getAnimeId()));
			for (Season season : anime.getSeasons())
				season.setEpisodes(episodeImpl.getAll(season.getSeasonId()));
			jsObjects = anime.toJSObject();
			jsObjects += "\n" + new Season().toJSObject();
			jsObjects += "\n" + new Episode().toJSObject();
			jsObjects += "\n" + new Type().toJSObject();
			jsObjects += "\n" + new Alias().toJSObject();
			
			jsInstance += "var anime=" + anime.toJSInstance();

			response.getWriter().println(jsObjects + " \n" + jsInstance);
			// response.getWriter().println("function
			// Anime(id,name,description,imageLink,status,genre,alias,seasons){this.id=id;this.name=name,this.description=description;this.imageLink=imageLink;this.status=status;this.genre=genre;this.alias=alias,this.seasons=seasons}
			// var anime=new Anime(5,'attack on titan,Several hundred years ago,
			// humans were nearly exterminated by titans. Titans are typically
			// several stories tall, seem to have no intelligence, devour human
			// beings and, worst of all, seem to do it for the pleasure rather
			// than as a food source. A small percentage of humanity survived by
			// enclosing themselves in a city protected by extremely high walls,
			// even taller ...','/Image/Animes/attackOnTitan.jpg',2,[new Type
			// (1,Action),new Type (5,Adventure),new Type (6,Comedy)],[new
			// Alias(5,Shingeki no Kyojin)],[new Season(5,1,2016-05-27
			// 12:33:53.474,5,[new Episode (0,1,attack on titan s1 1,2016-05-27
			// 12:34:01.341,'https://www.youtube.com/embed/BtOoD5o_ql0,/Image/Animes/attackOnTitan.jpg',5);,new
			// Episode (0,2,attack on titan s1 2,2016-05-27
			// 12:34:01.349,'https://www.youtube.com/embed/okPWN6SEWLw,/Image/Animes/attackOnTitan.jpg',5);,]),new
			// Season(5,2,2016-05-27 12:33:53.492,5,[new Episode (0,1,attack on
			// titan s2 1,2016-05-27
			// 12:34:01.357,'https://www.youtube.com/embed/BtOoD5o_ql0,/Image/Animes/attackOnTitan.jpg',6);,new
			// Episode (0,2,attack on titan s2 2,2016-05-27
			// 12:34:01.366,'https://www.youtube.com/embed/okPWN6SEWLw','/Image/Animes/attackOnTitan.jpg',6)])]);");
		} catch (DataAccessException | ClassNotFoundException | SQLException e) {
			response.setStatus(404);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
