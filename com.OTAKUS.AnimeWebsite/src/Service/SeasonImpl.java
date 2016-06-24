package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.SeasonDao;
import Service.interfaces.ISeason;
import beans.Season;

public class SeasonImpl implements ISeason<Season, Integer> {
	private SeasonDao seasonDao;
	{
		seasonDao=new SeasonDao();
	}
	@Override
	public boolean insert(Season season) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs = seasonDao.insert(season);
		return rs;
	}

	@Override
	public boolean update(Season season) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs = seasonDao.update(season);
		return rs;
	}

	@Override
	public boolean delete(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs = seasonDao.delete(seasonId);
		return rs;
	}

	@Override
	public Season get(Integer seasonId) throws DataAccessException, ClassNotFoundException, SQLException {
		return seasonDao.get(seasonId);
	}

	@Override
	public List<Season> getAll(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return seasonDao.getAll(animeId);
	}
	@Override
	public int getLastSeason(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return seasonDao.getLastSeasonNum(animeId);
	}

	public static int switchNumSeasonToId(Integer season_num, int animeId)
			throws DataAccessException, ClassNotFoundException, SQLException {
		return SeasonDao.switchNumSeasonToId(season_num, animeId);
	}

}
