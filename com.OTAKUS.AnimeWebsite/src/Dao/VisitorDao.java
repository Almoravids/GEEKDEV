package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoIUDGGA;
import beans.Anime;
import beans.Visitor;

public class VisitorDao implements IDaoIUDGGA<Visitor, String> {

	@Override
	public boolean update(Visitor visitor) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("update visitor set first_name=?,last_name=?,password=?,email=?,image_link=? where username=?",
				visitor.getFirstName(),visitor.getLastName(),visitor.getPassword(),visitor.getEmail(),visitor.getImageLink(), visitor.getUserName());
		return DaoTools.getResult(rs);
	}

	@Override
	public Visitor get(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		Visitor visitor = DaoConnection.getConnection()
				.queryForObject("select * from visitor where username='" + username + "'", new Visitor());
		return visitor;
	}

	@Override
	public boolean insert(Visitor visitor) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("insert into visitor values(?,?,?,?,?,'user',?)",
				visitor.getUserName(), visitor.getFirstName(), visitor.getLastName(), visitor.getEmail(),
				visitor.getPassword(), visitor.getImageLink());
		return DaoTools.getResult(rs);
	}

	@Override
	public boolean delete(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("delete from visitor where username=?", username);
		return DaoTools.getResult(rs);
	}

	@Override
	public List<Visitor> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		List<Visitor> ListVisitor = DaoConnection.getConnection().query("select * from visitor", new Visitor());
		return (List<Visitor>) ListVisitor;
	}

	public boolean grade(Visitor visitor)
			throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = DaoConnection.getConnection().update("update visitor set type=? where username=?", visitor.getType(),
				visitor.getUserName());
		return DaoTools.getResult(rs);
	}

}
