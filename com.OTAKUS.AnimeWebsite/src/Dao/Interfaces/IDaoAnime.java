package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoAnime<T, S> {
	public boolean insert(T Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(T Anime) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public T get(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByAlias(S aliasId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAllByType(S typeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public int getAnimeId() throws DataAccessException, ClassNotFoundException, SQLException;
}
