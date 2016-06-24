package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IMovieDao;
import beans.Movie;

public class MovieDao implements IMovieDao {

	@Override
	public boolean insert(Movie movie) throws DataAccessException, ClassNotFoundException, SQLException {
		return false;
	}

	@Override
	public boolean update(Movie movie) throws DataAccessException, ClassNotFoundException, SQLException {
		return false;
	}

	@Override
	public boolean delete(Integer movieId) throws DataAccessException, ClassNotFoundException, SQLException {
		return false;
	}

	@Override
	public Movie get(Integer movieId,Integer movieNum) throws DataAccessException, ClassNotFoundException, SQLException {
		return (Movie) DaoConnection.getConnection().queryForObject("select m.* from movie m where m.id_anime=? and m.mv_num=?",new Movie(),movieId,movieNum);
	}

	public List<Movie> searchByAllias(String name) throws DataAccessException, ClassNotFoundException, SQLException{
		return DaoConnection.getConnection().query("select distinct m.* from anime a, movie m where a.id_anime=m.id_anime and (m.mv_name like '%"+name+"%' or a.anime_name like '%"+name+"%')",new Movie());
	}

	public List<Movie> searchByType(String type) throws DataAccessException, ClassNotFoundException, SQLException{
		return DaoConnection.getConnection().query("select m.* from movie m,genre g,type t where m.id_movie=g.id_movie and g.id_type=t.id_type and t.type=?",new Movie(),type);
	}

	@Override
	public List<Movie> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public List<Movie> getWatched(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public List<Movie> getRecommanded() throws DataAccessException, ClassNotFoundException, SQLException {
		return null;
	}

}
