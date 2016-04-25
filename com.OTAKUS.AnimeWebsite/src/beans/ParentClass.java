package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public abstract class ParentClass implements RowMapper<ParentClass>{
	private int episode;
	private String username;
	
	public ParentClass() {
		super();
	}
	public ParentClass(int episode, String username) {
		super();
		this.episode = episode;
		this.username = username;
	}
	
	public int getEpisode() {
		return episode;
	}
	public void setEpisode(int episode) {
		this.episode = episode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	abstract public  ParentClass mapRow(ResultSet rs, int arg1) throws SQLException ;

	
	
}
