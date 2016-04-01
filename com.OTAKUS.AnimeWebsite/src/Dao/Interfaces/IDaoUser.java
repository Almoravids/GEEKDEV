package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoUser<T,S> {
	public  boolean insert(T t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean update(T t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(S s) throws DataAccessException, ClassNotFoundException, SQLException;
	public  T get(S s) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;
	public boolean grade(T t) throws DataAccessException, ClassNotFoundException, SQLException;
}
