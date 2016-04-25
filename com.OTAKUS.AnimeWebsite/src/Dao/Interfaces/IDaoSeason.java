package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoSeason<T, S> {
	public boolean insert(T Season) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean update(T Season) throws DataAccessException, ClassNotFoundException, SQLException;

	public boolean delete(S seasonId) throws DataAccessException, ClassNotFoundException, SQLException;

	public T get(S seasonId) throws DataAccessException, ClassNotFoundException, SQLException;
	
	//TOADD public T findByEpisode( episodeId) throws DataAccessException, ClassNotFoundException, SQLException;
    //TOADD  public T findByUsername(String username) throws DataAccessException, ClassNotFoundException, SQLException;
	//select s.id_season from last_seen ls , episode e ,season s  where ls.id_episode=e.id_episode and e.id_season=s.id_season and ls.username='"+username+"'"
	public List<T> getAll(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	public int getLastSeasonNum(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;

	
}
