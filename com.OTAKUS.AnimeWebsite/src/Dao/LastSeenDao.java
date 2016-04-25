package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoLastSeen;
import beans.Anime;
import beans.Episode;
import beans.LastSeen;

public class LastSeenDao implements IDaoLastSeen<LastSeen, String> {

	@Override
	public boolean insert(LastSeen lastSeen) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("insert into last_seen values(?,?,systimestamp)",
				lastSeen.getUsername(), lastSeen.getEpisode());
		return DaoTools.getResult(rs);
	}

	public boolean update(LastSeen lastSeen) throws DataAccessException, ClassNotFoundException, SQLException {
		 	int rs = DaoConnection.getConnection().update("update last_seen set id_episode =? where ",lastSeen.getEpisode());
		 	return DaoTools.getResult(rs);
	}
	
//	@Override
//	public List<Anime> get(LastSeen lastSeen) throws DataAccessException, ClassNotFoundException, SQLException {
//
//		return DaoConnection.getConnection().query("select a.* from last_seen ls , episode e ,season s ,anime a where ls.id_episode=e.id_episode and e.id_season=s.id_season and s.id_anime=a.id_anime and ls.username='"+lastSeen.getUsername()+"' and id_episode='"+lastSeen.getEpisode()+"'", new Anime());
//	}
	
	@Override
	public List<Episode> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query("select e.* from last_seen ls , episode e ,season s ,anime a where ls.id_episode=e.id_episode and ls.username='"+username+"'", new Episode());
	}


	@Override
	public boolean delete(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return false;
	}

}
