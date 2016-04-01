package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoSeason<T, S> {
	public boolean insert(T Season) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(T Season) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(S seasonId) throws DataAccessException, ClassNotFoundException, SQLException;

	public T get(S seasonId) throws DataAccessException, ClassNotFoundException, SQLException;

	public List<T> getAll(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public int getLastSeasonNum(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	
}
