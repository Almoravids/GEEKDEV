package Object;

import java.sql.Timestamp;

public class Season {
private int seasonId,season,animeId,statueId;
private Timestamp time;

public Season() {
	// TODO Auto-generated constructor stub
}

public Season(int seasonId, int season, int animeId, int statueId, Timestamp time) {
	super();
	this.seasonId = seasonId;
	this.season = season;
	this.animeId = animeId;
	this.statueId = statueId;
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

public int getStatueId() {
	return statueId;
}

public void setStatueId(int statueId) {
	this.statueId = statueId;
}

public Timestamp getTime() {
	return time;
}

public void setTime(Timestamp time) {
	this.time = time;
}

}
