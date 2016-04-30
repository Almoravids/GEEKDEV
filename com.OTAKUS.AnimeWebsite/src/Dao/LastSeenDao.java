package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoLastSeen;
import beans.Episode;

public class LastSeenDao implements IDaoLastSeen {

	//FIXME 
	@Override
	public  void save(int id_episode,int id_season,String username) throws DataAccessException, ClassNotFoundException, SQLException{
		DaoConnection.getConnection().update("call save(?,?,?)",id_episode,id_season,username);
	}

	
	

	
	@Override
	public List<Episode> getAll(String username) throws DataAccessException, ClassNotFoundException, SQLException {
		return DaoConnection.getConnection().query("select e.* from last_seen ls , episode e ,season s ,anime a where ls.id_episode=e.id_episode and ls.username='"+username+"'", new Episode());
	}


//	@Override
//	public boolean delete(String username) throws DataAccessException, ClassNotFoundException, SQLException {
//		return false;
//	}

}
