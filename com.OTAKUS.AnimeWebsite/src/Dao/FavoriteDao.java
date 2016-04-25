package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoFavorite;
import beans.Anime;
import beans.Favorite;

public class FavoriteDao implements IDaoFavorite{

	@Override
	public boolean insert(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=DaoConnection.getConnection().update("insert into favorite values(?,?)",favorite.getAnimeId(),favorite.getUsername());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(Favorite favorite)
			throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=DaoConnection.getConnection().update("delete from favorite where username=? and id_anime=?",favorite.getUsername(),favorite.getAnimeId());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean check(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=DaoConnection.getConnection().queryForObject("select count(*) from favorite where username=? and id_anime=?", Integer.class,favorite.getUsername(),favorite.getAnimeId());
		return DaoTools.getResult(rs);
	}

	@Override
	public List<Anime> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query("select a.* from anime a , favorite f where a.id_anime=f.id_anime and f.username='"+username+"'", new Anime());
	}

}
