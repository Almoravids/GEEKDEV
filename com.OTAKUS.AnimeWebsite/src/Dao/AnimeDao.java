package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoAnime;
import beans.Anime;

public class AnimeDao implements IDaoAnime<Anime, String> {
	// FIXME lookAt Service IAnime
	@Override
	public boolean update(Anime anime) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update(
				"update anime set name=? description=? , anime_image_link=? , anime_status=? where id_anime=?",
				anime.getName(), anime.getDescription(), anime.getImageLink(), anime.getStatus(), anime.getAnimeId());
		return DaoTools.getResult(rs);
	}

	@Override
	public Anime get(String animename) throws DataAccessException, ClassNotFoundException, SQLException {
		Anime anime = (Anime) DaoConnection.getConnection()
				.queryForObject("select a.* from anime a where a.anime_name='" + animename + "' ", new Anime());
		AliasDao alias = new AliasDao();
		anime.setAlias(alias.get(anime.getAnimeId()));

		TypeDao type = new TypeDao();
		anime.setGenre(type.get(anime.getAnimeId()));
		return anime;
	}

	@Override
	public boolean insert(Anime anime) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("insert into anime values(?,?,?,?,?)", anime.getAnimeId(),
				anime.getName(), anime.getDescription(), anime.getImageLink(), anime.getStatus());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("delete from anime where id_anime=" + animeId);
		return DaoTools.getResult(rs);
	}

	@Override
	public List<Anime> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		List<Anime> listAnime = (List<Anime>) DaoConnection.getConnection()
				.query("select a.* from anime a where not anime_status=1 order by a.anime_name", new Anime());
		return listAnime;
	}

	/*
	 * AliasDao alias; TypeDao type; for (Anime anime : listAnime) { alias = new
	 * AliasDao(); anime.setAlias(alias.get(anime.getAnimeId())); type = new
	 * TypeDao(); anime.setGenre(type.get(anime.getAnimeId())); }
	 */
	@Override
	public int getAnimeId() throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject("select anime_seq.nextval from dual", Integer.class);
	}

	@Override
	public List<Anime> getAllByAlias(String alias) throws DataAccessException, ClassNotFoundException, SQLException {
		return (List<Anime>) DaoConnection
				.getConnection().query(
						"select a.* from anime a inner join  alias al on  a.id_anime=al.id_anime   where a.anime_name like '%"
								+ alias.toLowerCase() + "%' or al.alias like '%" + alias.toLowerCase() + "%'",
						new Anime());
	}

	@Override
	public List<Anime> getAllByType(String type) throws DataAccessException, ClassNotFoundException, SQLException {
		return (List<Anime>) DaoConnection.getConnection()
				.query("select a.* from anime a,kind k,type t where a.id_anime=k.id_anime and k.id_type=t.id_type and t.type like'%"
						+ type + "%'", new Anime());
	}

	@Override
	public List<Anime> getRecommanded(String username)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select distinct an.* from  anime an , season se , episode ep where exists (select a.id_anime , max(ls.id_episode) from anime a,last_seen ls ,episode e ,season s where  ls.id_episode=e.id_episode and e.id_season=s.id_season and s.id_anime=a.id_anime and ls.username=? and a.id_anime=an.id_anime  and an.id_anime=se.id_anime and se.id_season=ep.id_season group by a.id_anime having ep.id_episode > max(ls.id_episode))",
				new Anime(), username);
	}

	@Override
	public List<Anime> getPopular() throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select a.* ,count(*) as watched from anime a,season s,episode e ,last_seen ls where a.id_anime=s.id_anime and s.id_season=e.id_season and e.id_episode=ls.id_episode and rownum<=4 group by a.id_anime,a.anime_name,a.description,a.anime_image_link,a.anime_status order by watched desc",
				new Anime());
	}

	@Override
	public List<Anime> getRecently() throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select a.* from anime a where not anime_status =1 and rownum <4 order by a.id_anime desc",
				new Anime());
	}

	@Override
	public List<Anime> getByStatus(Integer status) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select a.* from anime a where anime_status ="+status,new Anime());
	}

	@Override
	public List<Anime> getWatched(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select distinct an.* from    anime an , season se , episode ep ,last_seen ls where exists (select max(e.id_episode) from anime a , season s , episode e "
				+ "where an.id_anime=s.id_anime and se.id_season=e.id_season and an.id_anime=se.id_anime and se.id_season=ep.id_season and ep.id_episode=ls.id_episode and ls.username=?"
				+ " and an.anime_status=3 and an.id_anime=a.id_anime having ls.id_episode=max(e.id_episode))",
				new Anime(),username);
	}

	@Override
	public List<Anime> getWatching(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select distinct an.* from    anime an , season se , episode ep ,last_seen ls "
				+ "where exists (select a.anime_status,max(e.id_episode) "
				+ "from anime a , season s , episode e"
				+ " where an.id_anime=s.id_anime and se.id_season=e.id_season and an.id_anime=se.id_anime and se.id_season=ep.id_season and ep.id_episode=ls.id_episode and ls.username=? and not an.anime_status=1 and an.id_anime=a.id_anime"
				+ " group by anime_status having ls.id_episode<=max(e.id_episode)and a.anime_status=2 or ls.id_episode<max(e.id_episode)and a.anime_status=3)",
				new Anime(),username);
	}

	@Override
	public List<Anime> getQueued(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query("select distinct an.* "
				+ "from anime an ,favorite fa "
				+ "where an.id_anime=fa.id_anime and an.id_anime not in (select distinct an.id_anime from anime an , season se , episode ep ,last_seen ls "
				+ "where an.id_anime=se.id_anime and se.id_season=ep.id_season and ep.id_episode=ls.id_episode and ls.username=?"
				+ ")and fa.username=?",new Anime(),username,username);
	}
}
