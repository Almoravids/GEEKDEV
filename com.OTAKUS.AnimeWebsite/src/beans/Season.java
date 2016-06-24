package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import Service.EpisodeImpl;
import Service.Tools;
import Service.interfaces.IBeanToJS;

public class Season implements RowMapper<Season>,IBeanToJS{
	private int seasonId, season, animeId;
	private Timestamp time;
	private List<Episode>episodes;

	public Season() {
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

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
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

	@Override
	public String toJSObject() {
		return "function Season(id,season,time,anime,episodes){"
				+ "this.id=id;"
				+ "this.season=season;"
				+ "this.time=time;"
				+ "this.anime=anime;"
				+ "this.episodes=episodes;"
				+ "};";
	}

	@Override
	public String toJSInstance() {
		String jsInstance= "new Season("+this.animeId+","+this.season+",new Date(\""+this.time+"\"),"+this.animeId+",[";
		for (int i=0;i<episodes.size();i++){
			jsInstance+=episodes.get(i).toJSInstance();
		if (episodes.size()-i!=1)
			jsInstance+=",";}
				jsInstance+="])";
		return jsInstance;
	}
}
