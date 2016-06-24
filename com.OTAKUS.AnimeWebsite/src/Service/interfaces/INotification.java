package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Episode;

public interface INotification {

	public List<Episode> watchingAnimesNotification(String username)
			throws DataAccessException, ClassNotFoundException, SQLException;

	public List<Episode> notWatchedAnimesNotification(String username)
			throws DataAccessException, ClassNotFoundException, SQLException;
}
