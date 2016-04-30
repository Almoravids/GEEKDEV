package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.EpisodeDao;
import Service.interfaces.IEpisode;
import beans.Episode;

public class EpisodeImpl implements IEpisode<Episode, Integer> {
     EpisodeDao episodeDao;
     {
    	 episodeDao=new EpisodeDao();
     }
	@Override
	public boolean insert(Episode episode) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=episodeDao.insert(episode);
		return rs;
	}

	@Override
	public boolean update(Episode episode) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=episodeDao.update(episode);
		return rs;
	}

	@Override
	public boolean delete(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=episodeDao.delete(episodeId);
		return rs;
	}

	@Override
	public Episode get(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return episodeDao.get(episodeId);
	}

	@Override
	public List<Episode> getAll(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {
		return episodeDao.getAll(seasonId);
	}

	public static int switchNumEpisodeToId(Integer seasonId, int episode_num)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return EpisodeDao.switchNumEpisodeToId(seasonId, episode_num);
	}

	@Override
	public Episode getLast(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return episodeDao.getLast(animeId);
	}

	@Override
	public List<Episode> getRecent() throws DataAccessException, ClassNotFoundException, SQLException {
		return episodeDao.getRecent();
	}
}
