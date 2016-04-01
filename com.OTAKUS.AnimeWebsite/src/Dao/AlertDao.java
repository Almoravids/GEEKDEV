package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoAlert;
import beans.Alert;

public class AlertDao implements IDaoAlert{

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

	@Override
	public List<Alert> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
