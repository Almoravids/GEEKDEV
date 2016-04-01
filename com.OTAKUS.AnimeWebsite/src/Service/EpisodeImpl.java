package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Service.interfaces.IEpisode;
import beans.Episode;

public class EpisodeImpl implements IEpisode<Episode, Integer> {

	@Override
	public boolean insert(Episode Episode) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Episode Episode) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Episode get(Integer espideId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Episode> getAll(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public static int switchNumEpisodeToId(Integer seasonId, int episode_num)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return 0;
	}
}
