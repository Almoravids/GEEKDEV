package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoNotification;
import beans.Episode;

public class NotificationDao implements IDaoNotification{

	@Override
	public List<Episode> watchingAnimesNotification(String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query("select distinct * "
				+ "from  episode ep , season se , anime an   "
				+ "where exists (select a.id_anime , max(ls.id_episode) "
				+ "from anime a,favorite f,last_seen ls ,episode e ,season s "
				+ "where a.id_anime=f.id_anime and f.username=ls.username and ls.id_episode=e.id_episode and e.id_season=s.id_season and s.id_anime=a.id_anime and ls.username='"+username
				+ "' and a.id_anime=an.id_anime  and an.id_anime=se.id_anime and se.id_season=ep.id_season"
				+ " group by a.id_anime"
				+ " having ep.id_episode > max(ls.id_episode))",new Episode());
	}

	@Override
	public List<Episode> notWatchedAnimesNotification(String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return null;
	}

}
