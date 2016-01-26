package Dao.interfaceClasses;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import Dao.DaoConnection;
import Dao.Interfaces.IDaoUpdate;

public  abstract class DaoUpdate<C> implements IDaoUpdate<C>{

	@Override
	public JdbcTemplate getConnection() throws ClassNotFoundException, SQLException {
		DaoConnection connection=(DaoConnection)DaoConnection.getcontext();
		connection.getConnection();
		return connection.getJdbcT();
	}

	public abstract  List<C> getAll() throws DataAccessException, ClassNotFoundException, SQLException;
	public abstract List<C> get(C id) throws DataAccessException, ClassNotFoundException, SQLException;
	public abstract boolean delete(C id) throws DataAccessException, ClassNotFoundException, SQLException;

	
	public abstract boolean insert(C t) throws DataAccessException, ClassNotFoundException, SQLException;
	public abstract boolean insertAll(List<C> t) throws DataAccessException, ClassNotFoundException, SQLException;
//	@Override
//	public boolean insertAll(List<C> t) throws DataAccessException, ClassNotFoundException, SQLException{
//		int rs=0;
//		for (C c :t)
//			if(insert(c))
//				rs++;
//		if (rs==t.size())
//		return true;
//		else 
//		return false;
//	}

	@Override
	public abstract boolean update(C t) throws DataAccessException, ClassNotFoundException, SQLException ;
	@Override
	public abstract boolean updateAll(List<C> t) throws DataAccessException, ClassNotFoundException, SQLException;
//	@Override
//	public boolean updateAll(List<C> t) throws DataAccessException, ClassNotFoundException, SQLException {
//		boolean rs=false;
//		for (C c :t)
//			delete(c);
//			if(insertAll(t))
//				rs=true;
//			return rs;
//	}
	
    protected boolean getResult(int rs){
    	boolean result=false;
    	if (rs!=0)
    		return true;
		return result;
    	
    }
}
