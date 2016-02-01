package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoIUDGGA;
import beans.Alias;
import beans.Anime;

public class AnimeDao implements IDaoIUDGGA<Anime, Integer> {

	@Override
	public boolean update(Anime Anime) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Anime get(Integer idAnime) throws DataAccessException, ClassNotFoundException, SQLException {
		Anime anime = (Anime) DaoConnection.getConnection().queryForObject(
				"select a.* from anime a where id_anime=" + idAnime + "order by id_alias asc", new Anime());
		AliasDao alias = new AliasDao();
		anime.setAlias(alias.get(anime.getAnimeId()));

		TypeDao type = new TypeDao();
		anime.setGenre(type.get(anime.getAnimeId()));
		return anime;
	}

	@Override
	public boolean insert(Anime Anime) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer idAnime) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Anime> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		List<Anime> listAnime = (List<Anime>) DaoConnection.getConnection().query(
				"select a.* from anime a order by id_alias asc", new Anime());
		AliasDao alias;
		TypeDao type;
		for (Anime anime : listAnime) {
			
		}

		
		return listAnime;
	}

}
