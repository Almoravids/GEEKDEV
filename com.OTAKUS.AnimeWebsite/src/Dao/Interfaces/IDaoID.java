package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public interface IDaoID<T,M> {
    

	public  boolean insert(T t) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(M m) throws DataAccessException, ClassNotFoundException, SQLException;
}
