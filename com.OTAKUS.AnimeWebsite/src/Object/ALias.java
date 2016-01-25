package Object;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ALias implements RowMapper<ALias> {
private int aliasId,animeId;
private String alias;
public ALias() {
	super();
}
public ALias(int animeId, String alias) {
	super();
	this.animeId = animeId;
	this.alias = alias;
}
public ALias(int aliasId, int animeId, String alias) {
	super();
	this.aliasId = aliasId;
	this.animeId = animeId;
	this.alias = alias;
}
public int getAliasId() {
	return aliasId;
}
public void setAliasId(int aliasId) {
	this.aliasId = aliasId;
}
public int getAnimeId() {
	return animeId;
}
public void setAnimeId(int animeId) {
	this.animeId = animeId;
}
public String getAlias() {
	return alias;
}
public void setAlias(String alias) {
	this.alias = alias;
}
@Override
public ALias mapRow(ResultSet rs, int arg1) throws SQLException {
	ALias alias=new ALias();
	alias.setAliasId(rs.getInt("id_alias"));
	alias.setAlias(rs.getString("name"));
	alias.setAnimeId(rs.getInt("id_anime"));
	return alias;
}

}
