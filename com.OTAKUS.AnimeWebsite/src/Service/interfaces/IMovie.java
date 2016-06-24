package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Movie;

public interface IMovie {
	public boolean insert(Movie movie) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(Movie movie) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(Integer movieId) throws DataAccessException, ClassNotFoundException, SQLException;

	public Movie get(Integer animeId, Integer movieNum)
			throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Movie> searchByAllias(String name) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Movie> searchByType(String name) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Movie> getAll() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Movie> getWatched(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Movie> getRecommanded() throws DataAccessException, ClassNotFoundException, SQLException;
}
