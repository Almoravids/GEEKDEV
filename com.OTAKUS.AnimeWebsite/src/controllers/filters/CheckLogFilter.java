package controllers.filters;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Service.UserImpl;


public class CheckLogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLogFilter() {
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
	HttpServletRequest httpRequest=(HttpServletRequest) request;
	HttpServletResponse httpResponse=(HttpServletResponse) response;
	if(httpRequest.getSession().getAttribute("user")==null){
	Cookie[] cookies=httpRequest.getCookies();
	String user = null,secureUser=null;
	for (Cookie cookie:cookies){
		if (cookie.getName().equals("username"))
			user=cookie.getValue();
		else if (cookie.getName().equals("id"))
			secureUser=cookie.getValue();
	}
	if (user!=null&&!user.equals("no Content")&&secureUser!=null&&!secureUser.equals("no Content")){
		try {
			MessageDigest dig=MessageDigest.getInstance("MD5");
			dig.digest(user.getBytes());
			if (new BigInteger(dig.digest()).toString(16).equals(secureUser)){
				UserImpl userImpl=new UserImpl();
				httpRequest.getSession().setAttribute("user",userImpl.get(user));
				System.out.println("Connected");
			}
		
		} catch (NoSuchAlgorithmException | DataAccessException | ClassNotFoundException e) {
			httpResponse.sendError(404);
			e.printStackTrace();
		}catch(SQLException e){
			httpResponse.sendError(500);
			e.printStackTrace();
		}
	}
	}
	System.out.println();
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
