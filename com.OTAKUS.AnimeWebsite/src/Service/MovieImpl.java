package Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import Dao.MovieDao;
import Dao.Interfaces.IMovieDao;
import Service.interfaces.IMovie;
import beans.Movie;


public class MovieImpl implements IMovie {
	MovieDao movieDao;

	
	{
		movieDao=new MovieDao();
	}
	@Override
	public boolean insert(Movie movie) throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.insert(movie);
	}

	@Override
	public boolean update(Movie movie) throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.update(movie);
	}

	@Override
	public boolean delete(Integer movieId) throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.delete(movieId);
	}

	@Override
	public Movie get(Integer movieId, Integer movieNum)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.get(movieId, movieNum);
	}

	@Override
	public List<Movie> searchByAllias(String name) throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.searchByAllias(name);
	}

	@Override
	public List<Movie> searchByType(String type) throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.searchByType(type);
	}

	@Override
	public List<Movie> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.getAll();
	}

	@Override
	public List<Movie> getWatched(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.getWatched(username);
	}

	@Override
	public List<Movie> getRecommanded() throws DataAccessException, ClassNotFoundException, SQLException {
		return movieDao.getRecommanded();
	}
	

}
