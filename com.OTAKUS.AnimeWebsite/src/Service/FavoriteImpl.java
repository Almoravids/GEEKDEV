package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.FavoriteDao;
import Service.interfaces.IFavorite;
import beans.Favorite;

public class FavoriteImpl implements IFavorite {
    private FavoriteDao favoriteDao;
    {
    	favoriteDao=new FavoriteDao();
    }
	@Override
	public boolean insert(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=favoriteDao.insert(favorite);
		return rs;
	}

	@Override
	public boolean delete(int animeId, String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=favoriteDao. delete(animeId, username);
		return rs;
	}

	@Override
	public boolean get(int animeId, String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return favoriteDao.get(animeId, username);
	}

	@Override
	public List<Favorite> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return favoriteDao.getAll(username);
	}

}
