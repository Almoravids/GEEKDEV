package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Favorite;

public interface IFavorite {
	public  boolean insert(Favorite Favorite) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(int animeId,String username) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean get(int animeId,String username) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<Favorite> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException;

}
