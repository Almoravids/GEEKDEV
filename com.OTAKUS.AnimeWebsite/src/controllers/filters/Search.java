package controllers.filters;

import java.io.IOException;
import java.sql.SQLException;

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

import Service.AnimeImpl;
import Service.FavoriteImpl;
import Service.LastSeenImpl;
import beans.Visitor;

/**
 * Servlet Filter implementation class Search
 */
@WebFilter("/search/*")
public class Search implements Filter {

	/**
	 * Default constructor.
	 */
	public Search() {
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
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		AnimeImpl animeImpl = new AnimeImpl();
		try {
			if (request.getParameter("search") != null){

				request.setAttribute("animes", animeImpl.getAllByAlias(request.getParameter("search")));

			}else if (request.getParameter("tag") != null){
				request.setAttribute("animes", animeImpl.getAllByType(request.getParameter("tag")));
			}else if (request.getParameter("action")!=null){
				String action=request.getParameter("action");
				Visitor user=(Visitor)httpRequest.getSession().getAttribute("user");
				if (action.equals("Last seen")){
                LastSeenImpl lastSeenImpl=new LastSeenImpl();
				request.setAttribute("episodes", lastSeenImpl.getAll(user.getUserName()));
				}else if (action.equals("Watching")){
					request.setAttribute("animes", animeImpl.getWatching(user.getUserName()));
					
				}else if (action.equals("Watched")){
					request.setAttribute("animes", animeImpl.getWatched(user.getUserName()));
					
				}else if (action.equals("Favorite")){
					FavoriteImpl fav=new FavoriteImpl();
					request.setAttribute("animes", fav.getAll(user.getUserName()));
					
				}else if (action.equals("Recommanded")){
					request.setAttribute("animes", animeImpl.getRecommanded(user.getUserName()));
					
				}else if (action.equals("Comingsoon")){
					request.setAttribute("animes", animeImpl.getByStatus(1));
					
				}else if (action.equals("Ongoing")){
					request.setAttribute("animes", animeImpl.getByStatus(2));
					
				}else if (action.equals("Completed")){
					request.setAttribute("animes", animeImpl.getByStatus(3));
					
				}else if (action.equals("Queued")){
					request.setAttribute("animes", animeImpl.getQueued(user.getUserName()));
				}
			}
		} catch (DataAccessException | ClassNotFoundException e) {
			httpResponse.sendError(404);
			e.printStackTrace();
		} catch (SQLException e) {
			httpResponse.sendError(500);
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
