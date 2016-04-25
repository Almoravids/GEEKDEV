package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

public class Comment implements RowMapper<Comment> {
	private int id,episode;
	private String comment;
	private Visitor user;
	private Timestamp time;

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the episode
	 */
	public int getEpisode() {
		return episode;
	}


	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(int episode) {
		this.episode = episode;
	}


	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}


	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}


	/**
	 * @return the username
	 */
	public Visitor getUser() {
		return user;
	}


	/**
	 * @param username the username to set
	 */
	public void setUser(Visitor user) {
		this.user = user;
	}


	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}


	@Override
	public Comment mapRow(ResultSet rs, int arg1) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id_comment"));
		comment.setEpisode(rs.getInt("id_episode"));
		Visitor user=new Visitor(rs.getString("username"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("image_link"), rs.getString("email"), rs.getString("password"));
		comment.setUser(user);
		comment.setComment(rs.getString("message"));
		comment.setTime(rs.getTimestamp("comment_time"));
		return comment;
	}

}
