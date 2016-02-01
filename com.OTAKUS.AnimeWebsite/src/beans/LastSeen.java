package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class LastSeen extends ParentClass{

private Timestamp time;

public LastSeen() {
	super();
}

public LastSeen(int episode, String username,Timestamp time) {
	super(episode, username);
	this.time=time;
}

public Timestamp getTime() {
	return time;
}

public void setTime(Timestamp time) {
	this.time = time;
}

@Override
public ParentClass mapRow(ResultSet rs, int arg1) throws SQLException {
	LastSeen lastSeen=new LastSeen();
	lastSeen.setId(rs.getInt("id_episode"));
	lastSeen.setUsername(rs.getString("username"));
	lastSeen.setTime(rs.getTimestamp("last_seen_time"));
	return lastSeen;
}

}
