package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Anime;

public interface IDaoAnime<T, S> {
	public boolean insert(Anime Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(Anime Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public T get(String animeName) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByAlias(String alias) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByType(String typeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getByStatus(Integer status) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getPopular() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getRecently() throws DataAccessException, ClassNotFoundException, SQLException;

	List<Anime> getRecommanded(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getWatched(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getWatching(String username) throws DataAccessException, ClassNotFoundException, SQLException;
	
	public List<T> getQueued(String username) throws DataAccessException, ClassNotFoundException, SQLException;

	public int getAnimeId() throws DataAccessException, ClassNotFoundException, SQLException;
}
