package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Alert extends LastSeen{

	@Override
	public Alert mapRow(ResultSet rs, int arg1) throws SQLException {
		Alert alert=new Alert();
		alert.setId(rs.getInt("id_episode"));
		alert.setUsername(rs.getString("username"));
		alert.setTime(rs.getTimestamp("alert_time"));
		return alert;
	}

}
 