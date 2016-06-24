package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Episode;
import beans.Notification;

public interface IDaoNotification {
public List<Episode> watchingAnimesNotification(String username)throws DataAccessException, ClassNotFoundException, SQLException;
public List<Episode> notWatchedAnimesNotification(String username)throws DataAccessException, ClassNotFoundException, SQLException;
}
