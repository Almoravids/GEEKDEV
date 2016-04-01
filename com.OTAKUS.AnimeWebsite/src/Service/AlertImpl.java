package Service;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import Service.interfaces.IAlert;
import beans.Alert;

public class AlertImpl implements IAlert {

	@Override
	public boolean insert(Alert Alert) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int episodeId, String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
