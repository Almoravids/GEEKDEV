package Service.filters;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.dao.DataAccessException;

import Dao.AnimeDao;
import Dao.EpisodeDao;
import Dao.SeasonDao;
import beans.Anime;
import beans.Episode;
import beans.Season;

/**
 * Servlet Filter implementation class WatchFilter
 */

public class WatchFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WatchFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		int seasonNmb=1;
		Matcher matcher=Pattern.compile("^/watch/(\\w*)(/season_(\\d*))?/episode_(\\d*)$").matcher(httpRequest.getRequestURI());
		if (matcher.find()){
			if (matcher.group(2)!=null)
				seasonNmb=Integer.parseInt(matcher.group(3));
			try {
				Anime anime=new AnimeDao().get(matcher.group(1).replace("_", " "));
				request.setAttribute("anime", anime);
				
				
				Season season=new SeasonDao().get(seasonNmb);
				request.setAttribute("season", season);
				
				EpisodeDao episodeDao=new EpisodeDao();
				Episode episode=episodeDao.get(EpisodeDao.switchNumEpisodeToId(seasonNmb,Integer.parseInt(matcher.group(4))));
				request.setAttribute("episode", episode);
				
				chain.doFilter(httpRequest, response);
			} catch (DataAccessException | ClassNotFoundException | SQLException e) {

				httpResponse.sendError(404);
			}
		}else 
		httpResponse.sendError(404);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}