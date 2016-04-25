package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.LastSeenDao;
import Service.interfaces.ILastSeen;
import beans.LastSeen;

public class LastSeenImpl implements ILastSeen<LastSeen,String> {
    private LastSeenDao lastSeenDao;
    {
    	lastSeenDao=new LastSeenDao();
    }
	@Override
	public boolean insert(LastSeen lastSeen) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=lastSeenDao.insert(lastSeen);
		return rs;
	}

	@Override
	public boolean delete(String commentId) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=lastSeenDao.delete(commentId);
		return rs;
	}

	@Override
	public List<LastSeen> get(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return lastSeenDao.get(username);
	}

}
