package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Favorite implements RowMapper<Favorite>{
      private int animeId;
      private String username;
      
	public int getAnimeId() {
		return animeId;
	}

	public void setAnimeId(int animeId) {
		this.animeId = animeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Favorite mapRow(ResultSet rs, int arg1) throws SQLException {
		Favorite fav=new Favorite();
		fav.setAnimeId(rs.getInt("id_Anime"));
		fav.setUsername(rs.getString("username"));
		return fav;
	}

}
