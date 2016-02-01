package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public abstract class ParentClass implements RowMapper<ParentClass>{
	private int id;
	private String username;
	
	public ParentClass() {
		super();
	}
	public ParentClass(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	abstract public  ParentClass mapRow(ResultSet rs, int arg1) throws SQLException ;

	
	
}
