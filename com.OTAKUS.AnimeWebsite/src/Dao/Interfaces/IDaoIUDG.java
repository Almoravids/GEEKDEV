package Dao.Interfaces;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public interface IDaoIUDG<T,M> extends IDaoIDG<T,M>{
	public  boolean update(T t) throws DataAccessException, ClassNotFoundException, SQLException;
}
