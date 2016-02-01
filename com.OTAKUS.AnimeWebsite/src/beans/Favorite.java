package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Favorite extends ParentClass{

	@Override
	public ParentClass mapRow(ResultSet rs, int arg1) throws SQLException {
		ParentClass parentClass=new Favorite();
		parentClass.setId(rs.getInt("id_Anime"));
		parentClass.setUsername(rs.getString("username"));
		return parentClass;
	}

}
