package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IDaoIUDGGA<T,M> extends IDaoIUDG<T,M> {
	public  List<T> getAll() throws DataAccessException, ClassNotFoundException, SQLException;
}
