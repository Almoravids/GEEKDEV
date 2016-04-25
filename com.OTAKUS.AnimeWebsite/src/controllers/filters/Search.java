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
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Service.AnimeImpl;

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
		AnimeImpl animeImpl = new AnimeImpl();
		try {
			if (request.getParameter("search") != null)

				request.setAttribute("animes", animeImpl.getAllByAlias(request.getParameter("search")));

			else if (request.getParameter("tag") != null)

				request.setAttribute("animes", animeImpl.getAllByType(request.getParameter("tag")));
		} catch (DataAccessException | ClassNotFoundException e) {
			httpResponse.sendError(404);
		} catch (SQLException e) {
			httpResponse.sendError(500);
		}
		System.out.println("In");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
