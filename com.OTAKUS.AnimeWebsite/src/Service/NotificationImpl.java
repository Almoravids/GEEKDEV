package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.NotificationDao;
import Service.interfaces.INotification;
import beans.Episode;

public class NotificationImpl implements INotification{
	NotificationDao notificationDao;
	{
		notificationDao=new NotificationDao();	
	}
	@Override
	public List<Episode> watchingAnimesNotification(String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return notificationDao.watchingAnimesNotification(username);
	}

	@Override
	public List<Episode> notWatchedAnimesNotification(String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return notificationDao.notWatchedAnimesNotification(username);
	}

}
