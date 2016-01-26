package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public interface IDaoUpdate<T,M> {
    public JdbcTemplate getConnection() throws ClassNotFoundException, SQLException;
	public  List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> get(T t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean insert(T t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean insertAll(List<T> t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean update(T t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean updateAll(List<T> t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(T t) throws DataAccessException, ClassNotFoundException, SQLException;
}
