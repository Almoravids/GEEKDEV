package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

public class Season implements RowMapper<Season>{
	private int seasonId, season, animeId;
	private Timestamp time;

	public Season() {
		// TODO Auto-generated constructor stub
	}

	public Season(int seasonId, int season, int animeId, int statueId, Timestamp time) {
		super();
		this.seasonId = seasonId;
		this.season = season;
		this.animeId = animeId;
		this.time = time;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getAnimeId() {
		return animeId;
	}

	public void setAnimeId(int animeId) {
		this.animeId = animeId;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public Season mapRow(ResultSet rs, int arg1) throws SQLException {
		Season season=new Season();
		season.setSeasonId(rs.getInt("id_season"));
		season.setSeason(rs.getInt("num_season"));
		season.setTime(rs.getTimestamp("time_season"));
		season.setAnimeId(rs.getInt("id_anime"));
		return  season;
	}

}
