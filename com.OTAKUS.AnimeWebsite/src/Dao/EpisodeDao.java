package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoEpisode;
import beans.Episode;

public class EpisodeDao implements IDaoEpisode<Episode, Integer>{
     @Override
	public boolean update(Episode episode) throws DataAccessException, ClassNotFoundException, SQLException {

		int rs = DaoConnection.getConnection().update(
				"update episode set name=?,link=?,image_link=?,type=? where episode.id_episode =? and episode.id_season =? ",
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
		int rs = DaoConnection.getConnection().update("delete from episode e where e.id_episode=?",
				episodeId);
		return DaoTools.getResult(rs);
	}
     @Override
	public List<Episode> getAll(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {

		return DaoConnection.getConnection()
				.query("select e.* from episode e" + " where e.id_season='" + seasonId + "'", new Episode());
	}
     @Override
	public Episode get(Integer id_episode) throws ClassNotFoundException, SQLException {

		return DaoConnection.getConnection().queryForObject(
				"select e.* from episode e " + " where  " + " e.id_episode=" + id_episode, new Episode());
	}

	public static int switchNumEpisodeToId(Integer seasonId, int episode_num)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject("select e.id_episode from episode e where e.num_episode="
				+ episode_num + " and e.id_season=" + seasonId, Integer.class);
	}
}
