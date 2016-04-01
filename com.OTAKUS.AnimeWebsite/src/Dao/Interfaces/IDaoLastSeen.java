package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoLastSeen <T,S>{

	public  boolean insert(T Comment) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(S commentId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> get(S username) throws DataAccessException, ClassNotFoundException, SQLException;
}