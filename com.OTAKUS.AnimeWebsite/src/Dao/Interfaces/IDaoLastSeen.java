package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Episode;

public interface IDaoLastSeen {

	public void save(int id_episode,int id_season,String username) throws DataAccessException, ClassNotFoundException, SQLException;
	public List<Episode> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException ;

}
