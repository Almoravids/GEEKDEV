package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Visitor implements RowMapper<Visitor>{
private String userName,firstName,lastName,imageLink,email,password,type;



public Visitor() {
	super();
}

public Visitor(String userName, String firstName, String lastName, String imageLink, String email, String password) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.imageLink = imageLink;
	this.email = email;
	this.password = password;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getImageLink() {
	return imageLink;
}

public void setImageLink(String imageLink) {
	this.imageLink = imageLink;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

@Override
public Visitor mapRow(ResultSet rs, int arg1) throws SQLException {
	Visitor visitor=new Visitor();
	visitor.userName = rs.getString("username");
	visitor.firstName = rs.getString("first_name");
	visitor.lastName = rs.getString("last_name");
	visitor.email = rs.getString("email");
	visitor.password = rs.getString("password");
	visitor.type=rs.getString("type");
	visitor.imageLink = rs.getString("image_link");
	return visitor;
}

}
