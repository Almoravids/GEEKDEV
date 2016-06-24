package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Notification implements RowMapper<Notification>{
private Anime anime;
private Episode episode;


public Anime getAnime() {
	return anime;
}

public void setAnime(Anime anime) {
	this.anime = anime;
}

public Episode getEpisode() {
	return episode;
}

public void setEpisode(Episode episode) {
	this.episode = episode;
}

@Override
public Notification mapRow(ResultSet rs, int arg1) throws SQLException {
	Notification notification=new Notification();
	Anime anime = new Anime();
	anime.setAnimeId(rs.getInt("id_anime"));
	anime.setName(rs.getString("anime_name"));
	anime.setDescription(rs.getString("description"));
	anime.setImageLink(rs.getString("anime_image_link"));
	anime.setStatus(rs.getInt("anime_status"));
	notification.setAnime(anime);
	Episode episode = new Episode();
	episode.setEpisodeid(rs.getInt("id_episode"));
	episode.setEpisode(rs.getInt("num_episode"));
	episode.setName(rs.getString("episode_name"));
	episode.setLink(rs.getString("link"));
	episode.setImageLink(rs.getString("episode_image_link"));
	episode.setSeasonId(rs.getInt("id_season"));
	episode.setType(rs.getInt("type"));
	episode.setTime(rs.getTimestamp("time_episode"));
	notification.setEpisode(episode);
	return notification;
}


}
