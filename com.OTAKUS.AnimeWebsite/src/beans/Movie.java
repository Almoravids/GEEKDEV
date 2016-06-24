package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class Movie implements RowMapper<Movie>{
private int movieId,animeId,movie;
private String name,link,imageLink,description;
private Timestamp time;
private List<Type> genre;

public Movie() {
}

public Movie(int movieId, int animeId, String name, String link, String imageLink,String description, Timestamp time) {
	super();
	this.movieId = movieId;
	this.animeId = animeId;
	this.name = name;
	this.link = link;
	this.imageLink = imageLink;
	this.description=description;
	this.time = time;
}

public Movie(int animeId, String name, String link, String imageLink,String description) {
	super();
	this.animeId = animeId;
	this.name = name;
	this.link = link;
	this.imageLink = imageLink;
	this.description=description;
}

public int getMovieId() {
	return movieId;
}


public void setMovieId(int movieId) {
	this.movieId = movieId;
}


public int getAnimeId() {
	return animeId;
}


public void setAnimeId(int animeId) {
	this.animeId = animeId;
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


public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Timestamp getTime() {
	return time;
}


public void setTime(Timestamp time) {
	this.time = time;
}

public int getMovie() {
	return movie;
}

public void setMovie(int movie) {
	this.movie = movie;
}


public List<Type> getGenre() {
	return genre;
}

public void setGenre(List<Type> genre) {
	this.genre = genre;
}

@Override
public Movie mapRow(ResultSet rs, int arg1) throws SQLException {
	Movie movie=new Movie();
	movie.setMovieId(rs.getInt("id_movie"));
	movie.setAnimeId(rs.getInt("id_anime"));
	movie.setMovie(rs.getInt("mv_num"));
	movie.setName(rs.getString("mv_name"));
	movie.setDescription(rs.getString("mv_description"));
	movie.setTime(rs.getTimestamp("mv_time"));
	movie.setLink(rs.getString("mv_link"));
	movie.setImageLink(rs.getString("mv_image_link"));
	
	return movie;
}


}
