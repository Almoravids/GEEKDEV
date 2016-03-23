package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoIUDGGA;
import beans.Anime;

public class AnimeDao implements IDaoIUDGGA<Anime, String> {

	@Override
	public boolean update(Anime anime) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update(
				"update anime set name=? description=? , image_link=? , id_statue=? where id_anime=?", anime.getName(),
				anime.getDescription(), anime.getImageLink(), anime.getStatue(), anime.getAnimeId());
		if (DaoTools.getResult(rs)) {
			AliasDao alias = new AliasDao();
			if (!anime.getAlias().equals(alias.get(anime.getAnimeId()))) {
				alias.delete(anime.getAnimeId());
				alias.insertAll(anime.getAlias());
			}
			TypeDao type = new TypeDao();
			if (!anime.getGenre().equals(type.deleteKind(anime.getAnimeId()))) {
				type.deleteKind(anime.getAnimeId());
				type.insertKind(anime);
			}
		}
		return DaoTools.getResult(rs);
	}

	@Override
	public Anime get(String animename) throws DataAccessException, ClassNotFoundException, SQLException {
		Anime anime = (Anime) DaoConnection.getConnection()
				.queryForObject("select a.* from anime a where a.name='" + animename+"'", new Anime());
		AliasDao alias = new AliasDao();
		anime.setAlias(alias.get(anime.getAnimeId()));

		TypeDao type = new TypeDao();
		anime.setGenre(type.get(anime.getAnimeId()));
		return anime;
	}

	@Override
	public boolean insert(Anime anime) throws DataAccessException, ClassNotFoundException, SQLException {
		int animeId=getId();
		int rs = DaoConnection.getConnection().update("insert into anime values(?,?,?,?,?)",anime.getAnimeId(),
				anime.getName(), anime.getDescription(), anime.getImageLink(), anime.getStatue());
		if (rs != 0) {
			AliasDao alias = new AliasDao();
			alias.insertAll(anime.getAlias());
			TypeDao type = new TypeDao();
			type.insertKind(anime);
		}
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(String animename) throws DataAccessException, ClassNotFoundException, SQLException {
		Anime anime = get(animename);
		AliasDao alias = new AliasDao();
		alias.delete(anime.getAnimeId());
		TypeDao type = new TypeDao();
		type.deleteKind(anime.getAnimeId());
		int rs = DaoConnection.getConnection().update("delete from anime where id_anime=" + anime.getAnimeId());
		return DaoTools.getResult(rs);
	}

	@Override
	public List<Anime> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		List<Anime> listAnime = (List<Anime>) DaoConnection.getConnection()
				.query("select a.* from anime a", new Anime());
		AliasDao alias;
		TypeDao type;
		for (Anime anime : listAnime) {
			alias = new AliasDao();
			anime.setAlias(alias.get(anime.getAnimeId()));
			type = new TypeDao();
			anime.setGenre(type.get(anime.getAnimeId()));
		}

		return listAnime;
	}
 public int getId() throws DataAccessException, ClassNotFoundException, SQLException{
	 return  DaoConnection.getConnection().queryForObject("select anime_seq.nextval from dual",Integer.class);
 }
}
