package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.VisitorDao;
import Service.interfaces.IUser;
import beans.Visitor;

public class UserImpl implements IUser<Visitor,String>{
	VisitorDao visitorDao;
	{
		visitorDao=new  VisitorDao();
	}
	@Override
	public boolean insert(Visitor visitor) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean b=visitorDao.insert(visitor);
		return b;
	}

	@Override
	public boolean update(Visitor visitor) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean b=visitorDao.update(visitor);
		return b;
	}

	@Override
	public boolean delete(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean b=visitorDao.delete(username);
		return b;
	}

	@Override
	public Visitor get(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		Visitor visitor=visitorDao.get(username);
		return  visitor;
	}

	@Override
	public List<Visitor> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		List<Visitor> list=(List<Visitor>) visitorDao.getAll();
		return  list;
	}

	@Override
	public boolean grade(Visitor visitor) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean b=visitorDao.grade(visitor);
		return b;
	}

}
