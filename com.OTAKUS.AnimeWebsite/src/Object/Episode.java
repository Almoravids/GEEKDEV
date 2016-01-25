package Object;

public class Episode {
private int Episodeid,episode,seasonId;
private String name,link,imageLink,type;


public Episode() {
	super();
}
public Episode(int episode, int seasonId, String name, String link, String imageLink, String type) {
	super();
	this.episode = episode;
	this.seasonId = seasonId;
	this.name = name;
	this.link = link;
	this.imageLink = imageLink;
	this.type = type;
}
public Episode(int episodeid, int episode, int seasonId, String name, String link, String imageLink, String type) {
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}


}
