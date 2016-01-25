package Object;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Type implements RowMapper<Type> {
private int typeId;
private String Type;
public Type() {
	super();
}
public Type(String type) {
	super();
	Type = type;
}
public Type(int typeId, String type) {
	super();
	this.typeId = typeId;
	Type = type;
}
public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
@Override
public Type mapRow(ResultSet rs, int arg1) throws SQLException {
	Type type=new Type();
	type.setTypeId(rs.getInt("id_type"));
	type.setType(rs.getString("name"));
	return type;
}

}
