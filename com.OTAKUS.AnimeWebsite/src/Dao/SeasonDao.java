package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoSeason;
import beans.Season;

public class SeasonDao implements IDaoSeason<Season, Integer> {

	@Override
	public boolean update(Season season) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update(
				"update season set num_season=? , time_season=? where id_seaosn=?", season.getTime(),
				season.getSeason(), season.getSeasonId());
		return DaoTools.getResult(rs);
	}

	@Override
	public Season get(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject("select s.* from season s where id_season=" + seasonId,
				new Season());

	}

	@Override
	public boolean insert(Season season) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("insert into season values(season.nextval,?,systimetamp)",
				getLastSeasonNum(season.getAnimeId()) + 1);
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("delete from season where id_season=?", seasonId);
		return DaoTools.getResult(rs);
	}

	public List<Season> getAll(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query("select s.* from season s where id_anime=" + animeId, new Season());
	}

	public int getLastSeasonNum(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject(
				"select nvl(max(s.num_season),0) from season s where s.id_anime=" + animeId, Integer.class);
	}

	public static int switchNumSeasonToId(Integer season_num, int animeId)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().queryForObject(
				"select s.id_season from season s where s.num_season=" + season_num + " and s.id_anime=" + animeId,
				Integer.class);
	}

}
