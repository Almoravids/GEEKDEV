package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Service.Tools;
import Service.interfaces.IBeanToJS;

public class Type implements RowMapper<Type> ,IBeanToJS{
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
	type.setType(rs.getString("type"));
	return type;
}
@Override
public String toJSObject() {
	return "function Type(id,type){this.id=id;this.type=type;};";
}
@Override
public String toJSInstance() {
	return "new Type ("+this.typeId+",\""+this.Type+"\")" ;
}

}
