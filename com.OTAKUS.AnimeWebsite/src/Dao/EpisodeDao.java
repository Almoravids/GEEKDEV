package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoEpisode;
import beans.Episode;

public class EpisodeDao implements IDaoEpisode<Episode, Integer> {
	@Override
	public boolean update(Episode episode) throws DataAccessException, ClassNotFoundException, SQLException {

		int rs = DaoConnection.getConnection().update(
				"update episode set name=?,link=?,episode_image_link=?,type=? where episode.id_episode =? and episode.id_season =? ",
				episode.getName(), episode.getLink(), episode.getImageLink(), episode.getType(), episode.getEpisode(),
				episode.getEpisodeid());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean insert(Episode episode) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("insert into episode values(episode_seq.nextval,?,?,?,?,?,?)",
				episode.getEpisode(), episode.getName(), episode.getLink(), episode.getImageLink(),
				episode.getSeasonId(), episode.getType());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(Integer episodeId) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("delete from episode e where e.id_episode=?", episodeId);
		return DaoTools.getResult(rs);
	}

	@Override
	public List<Episode> getAll(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {

		return DaoConnection.getConnection().query("select e.* from episode e  where e.id_season=" + seasonId,
				new Episode());
	}

	@Override
	public Episode get(Integer id_episode) throws ClassNotFoundException, SQLException {

		return DaoConnection.getConnection()
				.queryForObject("select e.* from episode e  where  e.id_episode=" + id_episode, new Episode());
	}

	public static int switchNumEpisodeToId(Integer seasonId, int episode_num)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject("select e.id_episode from episode e where e.num_episode="
				+ episode_num + " and e.id_season=" + seasonId, Integer.class);
	}

	@Override
	public Episode getLast(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject(
				"select e.* from episode e , season s ,anime a"
				+ " where e.id_season=s.id_season and s.id_anime=a.id_anime and e.num_episode=("
				+ " select Max(ep.num_episode) from episode ep , season se , anime an where ep.id_season =se.id_season and se.id_anime =an.id_anime) and s.num_season = ("
				+ "select max(s.num_season) from season s, anime a where a.id_anime=s.id_anime and a.id_anime="+animeId
				+ ")and s.season_status=1 and a.id_anime="+animeId
				+ "order by e.time_episode desc",
				new Episode());
	}

	@Override
	public List<Episode> getRecent() throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query(
				"select  e.* ,s.*,a.* from episode e , season s ,anime a where e.id_season=s.id_season and s.id_anime=a.id_anime and rownum<=12 order by e.id_episode",
				new Episode());
	}


}
