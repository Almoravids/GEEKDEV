package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoFavorite;
import beans.Favorite;

public class FavoriteDao implements IDaoFavorite{

	@Override
	public boolean insert(Favorite Favorite) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int animeId, String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean get(int animeId, String username) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Favorite> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
