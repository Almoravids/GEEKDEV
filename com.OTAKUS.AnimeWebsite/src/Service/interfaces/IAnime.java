package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Anime;

public interface IAnime<T, S> {
	public boolean insert(T Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(T Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public T get(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByAlias(S alias) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByType(S type) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getByStatus(Integer status) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Anime> getRecommanded(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Anime> waiting(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getPopular() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getWatched(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getWatching(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Anime> getQueued(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getRecently() throws DataAccessException, ClassNotFoundException, SQLException;
}
