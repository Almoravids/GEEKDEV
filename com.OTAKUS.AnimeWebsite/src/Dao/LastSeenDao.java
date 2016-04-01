package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoLastSeen;
import beans.LastSeen;

public class LastSeenDao implements IDaoLastSeen<LastSeen,String>{

	@Override
	public boolean insert(LastSeen Comment) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String commentId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LastSeen> get(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
