package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Anime;
import beans.Favorite;

public interface IDaoFavorite {
	public  boolean insert(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean check(Favorite favorite) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<Anime> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException;

}
