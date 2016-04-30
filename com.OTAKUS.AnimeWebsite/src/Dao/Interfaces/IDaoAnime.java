package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoAnime<T, S> {
	public boolean insert(T Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(T Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public T get(String animeName) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByAlias(S aliasId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByType(S typeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getRecommended() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getPopular() throws DataAccessException, ClassNotFoundException, SQLException;
	
	public List<T> getRecently() throws DataAccessException, ClassNotFoundException, SQLException;

	public int getAnimeId() throws DataAccessException, ClassNotFoundException, SQLException;
}
