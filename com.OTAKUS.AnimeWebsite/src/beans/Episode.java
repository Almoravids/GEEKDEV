package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Episode implements RowMapper<Episode>{
private int Episodeid,episode,seasonId,type;
private String name,link,imageLink;


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
	Episodeid = episodeid;
	this.episode = episode;
	this.seasonId = seasonId;
	this.name = name;
	this.link = link;
	this.imageLink = imageLink;
	this.type = type;
}
public int getEpisodeid() {
	return Episodeid;
}
public void setEpisodeid(int episodeid) {
	Episodeid = episodeid;
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
@Override
public Episode mapRow(ResultSet rs, int arg1) throws SQLException {
	Episode episode=new Episode();
	episode.setEpisodeid(rs.getInt("id_episode"));
	episode.setEpisode(rs.getInt("num_episode"));
	episode.setName(rs.getString("name"));
	episode.setLink(rs.getString("link"));
	episode.setImageLink(rs.getString("image_link"));
	episode.setSeasonId(rs.getInt("id_season"));
	episode.setType(rs.getInt("type"));
	return episode;
}


}
