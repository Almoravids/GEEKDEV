package Service;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import Dao.AlertDao;
import Service.interfaces.IAlert;
import beans.Alert;

public class AlertImpl implements IAlert {
   AlertDao alertDao;
   {
	   alertDao=new AlertDao();
   }
	@Override
	public boolean insert(Alert Alert) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=alertDao.insert(Alert);
		return rs;
	}

	@Override
	public boolean delete(int episodeId, String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=alertDao.delete(episodeId, username);
		return rs;
	}

}
