package Service.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IComment <T,S>{
	public  boolean insert(T Comment) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(S commentId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean update(T Comment) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<T> get(S episodeId) throws DataAccessException, ClassNotFoundException, SQLException;
}
