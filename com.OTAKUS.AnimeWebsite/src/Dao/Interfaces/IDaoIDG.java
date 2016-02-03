package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Anime;

public interface IDaoIDG<T,M> extends IDaoID<T,M> {
	public  T get(M m) throws DataAccessException, ClassNotFoundException, SQLException;

}
