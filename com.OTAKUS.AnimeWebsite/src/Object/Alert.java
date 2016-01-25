package Object;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Alert extends ParentClass{

	@Override
	public ParentClass mapRow(ResultSet rs, int arg1) throws SQLException {
		ParentClass parentClass=new Alert();
		parentClass.setId(rs.getInt("id_episode"));
		parentClass.setUsername(rs.getString("username"));
		return parentClass;
	}

}
