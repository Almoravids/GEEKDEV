package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import Service.Tools;
import Service.interfaces.IBeanToJS;

public class Episode implements RowMapper<Episode>,IBeanToJS {
	private int episodeid, episode, seasonId, type;
	private String name, link, imageLink;
	private Anime anime;
	private Season season;
	// FIXME WASSIM
	private Timestamp time;

	public Episode() {
		super();
	}

	public Episode(int episode, int seasonId, String name, String link, String imageLink, int type) {
		super();
		this.episode = episode;
		this.seasonId = seasonId;
		this.name = name;
		this.link = link;
		this.imageLink = imageLink;
		this.type = type;
	}

	public Episode(int episodeid, int episode, int seasonId, String name, String link, String imageLink, int type) {
		super();
		episodeid = episodeid;
		this.episode = episode;
		this.seasonId = seasonId;
		this.name = name;
		this.link = link;
		this.imageLink = imageLink;
		this.type = type;
	}

	public int getEpisodeid() {
		return episodeid;
	}

	public void setEpisodeid(int episodeid) {
		episodeid = episodeid;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Anime getAnime() {
		return anime;
	}

	
	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	
	public Season getSeason() {
		return season;
	}


	public void setSeason(Season season) {
		this.season = season;
	}

	@Override
	public Episode mapRow(ResultSet rs, int arg1) throws SQLException {
		Episode episode = new Episode();
		episode.setEpisodeid(rs.getInt("id_episode"));
		episode.setEpisode(rs.getInt("num_episode"));
		episode.setName(rs.getString("episode_name"));
		episode.setLink(rs.getString("link"));
		episode.setImageLink(rs.getString("episode_image_link"));
		episode.setSeasonId(rs.getInt("id_season"));
		episode.setType(rs.getInt("type"));
		episode.setTime(rs.getTimestamp("time_episode"));
		if (!rs.getMetaData().getColumnLabel(rs.getMetaData().getColumnCount()).equals("TYPE")){
		Anime anime=new Anime();
		anime=anime.mapRow(rs, arg1);
		episode.setAnime(anime);
			Season season=new Season();
			season=season.mapRow(rs, arg1);
			episode.setSeason(season);
		}
		return episode;
	}

	@Override
	public String toJSObject() {
		return "function Episode(id,episode,name,type,time,link,imagelink,seasonid){"
				+"this.id=id;this.episode=episode;this.name=name;this.type=type;this.time=time;this.link=link;this.imagelink=imagelink;this.seasonid=seasonid;};";
	}

	@Override
	public String toJSInstance() {
		return "new Episode ("+this.episodeid +","+this.episode+",\""+this.name+"\",\""+this.type+"\",\""+Tools.dateToString(this.time)+"\",\""+this.link+"\",\""+this.imageLink+"\","+this.seasonId+")";
	}

}
