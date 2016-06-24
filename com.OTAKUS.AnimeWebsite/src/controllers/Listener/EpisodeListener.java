package controllers.Listener;

import java.io.IOException;
import java.sql.SQLException;

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
import beans.Episode;
@WebServlet("/Episodes")
public class EpisodeListener extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EpisodeImpl episodeImpl = new EpisodeImpl();
		String anime = req.getParameter("anime");
		String season = req.getParameter("season");
		String jsObject=Tools.toJSObject(new Episode());
		if (season.matches("\\d*"))
			try {
				resp.getWriter().println(jsObject+" "+Tools.listJSInstance(episodeImpl.getAll(SeasonImpl.switchNumSeasonToId(Integer.parseInt(season), new AnimeImpl().get(anime).getAnimeId()))));
						
			} catch (DataAccessException | NumberFormatException | ClassNotFoundException e) {
				resp.sendError(404);
				e.printStackTrace();
			} catch (SQLException e) {
				resp.sendError(500);
				e.printStackTrace();
			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
