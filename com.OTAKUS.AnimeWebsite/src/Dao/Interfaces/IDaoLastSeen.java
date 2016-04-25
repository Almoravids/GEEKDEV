package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Anime;
import beans.Episode;

public interface IDaoLastSeen <T,S>{

	public  boolean insert(T lastSeen) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(S username) throws DataAccessException, ClassNotFoundException, SQLException;
//	public List<Anime> get(T lastSeen) throws DataAccessException, ClassNotFoundException, SQLException ;
	public List<Episode> getAll(S username) throws DataAccessException, ClassNotFoundException, SQLException ;

}
