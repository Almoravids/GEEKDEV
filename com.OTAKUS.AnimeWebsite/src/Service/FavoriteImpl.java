package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.FavoriteDao;
import Service.interfaces.IFavorite;
import beans.Anime;
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
	public boolean delete(Favorite favorite)
			throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=favoriteDao. delete(favorite);
		return rs;
	}

//	@Override
//	public boolean get(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException {
//		return favoriteDao.get(favorite);
//	}

	@Override
	public List<Anime> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return favoriteDao.getAll(username);
	}

	@Override
	public boolean check(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException {
		return favoriteDao.check(favorite);
	}

}
