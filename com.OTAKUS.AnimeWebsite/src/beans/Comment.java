package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Comment extends LastSeen {
private String comment;
public Comment() {
	super();
}


public Comment(int episode, String username, Timestamp time,String comment) {
	super(episode, username, time);
	this.comment=comment;
}


public String getComment() {
	return comment;
}


public void setComment(String comment) {
	this.comment = comment;
}


@Override
public Comment mapRow(ResultSet rs, int arg1) throws SQLException {
	Comment comment=new Comment();
	comment.setId(rs.getInt("id_episode"));
	comment.setUsername(rs.getString("username"));
	comment.setComment(rs.getString("message"));
	comment.setTime(rs.getTimestamp("comment_time"));
	return comment;
}

}
