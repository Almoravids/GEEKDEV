package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IEpisode<T,S> {
	public  boolean insert(T Episode) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean update(T Episode) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(S episodeId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  T get(S episodeId) throws DataAccessException, ClassNotFoundException, SQLException;	
	public  T getLast(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> getAll(S seasonId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> getRecent() throws DataAccessException, ClassNotFoundException, SQLException;
}
