package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.LastSeenDao;
import Service.interfaces.ILastSeen;
import beans.Episode;

public class LastSeenImpl implements ILastSeen{
    private LastSeenDao lastSeenDao;
    {
    	lastSeenDao=new LastSeenDao();
    }
	@Override
	public void save(int episodeId,int seasonId,String username) throws DataAccessException, ClassNotFoundException, SQLException{
		lastSeenDao.save(episodeId,seasonId,username);
	}

	

	@Override
	public List<Episode> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return lastSeenDao.getAll(username);
	}

}
