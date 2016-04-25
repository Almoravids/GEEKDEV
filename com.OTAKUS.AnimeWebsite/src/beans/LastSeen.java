package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;


public class LastSeen implements RowMapper<LastSeen>{
	private int episode;
	private String username;
	private Timestamp time;

	public LastSeen() {
		super();
	}

	public LastSeen(int episode, String username) {
		this.episode=episode;
		this.username=username;
	}

	
	public LastSeen(int episode, String username, Timestamp time) {
		this.episode = episode;
		this.username = username;
		this.time = time;
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

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public LastSeen mapRow(ResultSet rs, int arg1) throws SQLException {
		LastSeen lastSeen = new LastSeen();
		lastSeen.setEpisode(rs.getInt("id_episode"));
		lastSeen.setUsername(rs.getString("username"));
		lastSeen.setTime(rs.getTimestamp("last_seen_time"));
		return lastSeen;
	}

	

}
