package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import beans.Alias;

public interface IAlias<T,S> {
	public  boolean insert(T alias) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean update(T alias) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(S aliasId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> get(S animeId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean insertAll(List<Alias> listAlias) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean updateAll(List<Alias> listAlias) throws DataAccessException, ClassNotFoundException, SQLException;
}
