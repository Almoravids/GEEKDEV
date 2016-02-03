package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

public class Anime implements RowMapper<Anime>{
	private int animeId, statue;
	private String name, description, imageLink;
	private List<Type> genre;
	private List<Alias> alias;

	public Anime() {
		super();

	}

	public Anime(String name, int statue, String description, String imageLink, List<Alias> alias, List<Type> genre) {
		super();
		this.name = name;
		this.statue = statue;
		this.description = description;
		this.imageLink = imageLink;
		this.alias = alias;
		this.genre = genre;
	}

	public Anime(int animeId, int statue, String description, String imageLink, List<Alias> alias, List<Type> genre) {
		super();
		this.animeId = animeId;
		this.name = ((ArrayList<Alias>) alias).get(0).getAlias();
		this.statue = statue;
		this.description = description;
		this.imageLink = imageLink;
		this.alias = alias;
		this.genre = genre;
	}

	public int getAnimeId() {
		return animeId;
	}

	public void setId(int animeId) {
		this.animeId = animeId;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public int getStatue() {
		return statue;
	}

	public void setStatue(int statue) {
		this.statue = statue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public List<Alias> getAlias() {
		return alias;
	}

	public void setAlias(List<Alias> alias) {
		this.name = alias.get(0).getAlias();
		this.alias = alias;
	}

	public List<Type> getGenre() {
		return genre;
	}

	public void setGenre(List<Type> genre) {
		this.genre = genre;
	}

	@Override
	public Anime mapRow(ResultSet rs, int arg1) throws SQLException {
		Anime a = new Anime();
		a.setId(rs.getInt("id_anime"));
		a.setName(rs.getString("name"));
		a.setDescription(rs.getString("description"));
		a.setImageLink(rs.getString("image_link"));
		a.setStatue(rs.getInt("id_statue"));

		return a;
	}


}
