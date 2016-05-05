package controllers.filters;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Dao.AnimeDao;
import Dao.EpisodeDao;
import Dao.SeasonDao;
import Dao.TypeDao;
import Service.FavoriteImpl;
import beans.Anime;
import beans.Favorite;
import beans.Visitor;

/**
 * Servlet Filter implementation class animeFilter
 */
@WebFilter("/anime/*")
public class AnimeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AnimeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Matcher matcher = Pattern.compile("^/anime/(\\w*)/?$").matcher(httpRequest.getRequestURI());

		if (matcher.find()) {
			try {

				Anime anime = new AnimeDao().get(matcher.group(1).replace("_", " ").toLowerCase());
				request.setAttribute("anime", anime);
				TypeDao typeDao = new TypeDao();
				request.setAttribute("types", typeDao.get(anime.getAnimeId()));
				request.setAttribute("seasons", new SeasonDao().getAll(anime.getAnimeId()));
				request.setAttribute("episodes",
						new EpisodeDao().getAll(SeasonDao.switchNumSeasonToId(1, anime.getAnimeId())));
                
				Visitor user=(Visitor) httpRequest.getSession().getAttribute("user");
				if (user!=null){
				Favorite fav= new Favorite();
				fav.setAnimeId(anime.getAnimeId());
				fav.setUsername(user.getUserName());
				request.setAttribute("favorite",new FavoriteImpl().check(fav));
				}
				chain.doFilter(request, response);
			} catch (SQLException e) {
				httpResponse.sendError(500);
				e.printStackTrace();
			} catch (DataAccessException | ClassNotFoundException e) {
				httpResponse.sendError(404);
				e.printStackTrace();
			}

		} else
			httpResponse.sendError(404);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
