package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoAlias;
import beans.Alias;

public class AliasDao implements IDaoAlias<Alias,Integer>{

	@Override
	public List<Alias> get(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return (List<Alias>)DaoConnection.getConnection().query("select * from alias where id_anime="+animeId,new Alias());
	}



	@Override
	public boolean insert(Alias Alias) throws DataAccessException, ClassNotFoundException, SQLException {
	       int rs=DaoConnection.getConnection().update("insert into alias values(?,?)",Alias.getAnimeId(),Alias.getAlias());
           return DaoTools.getResult(rs);
	}

	

	@Override
	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=DaoConnection.getConnection().update("delete from alias where id_anime="+animeId);
	    return DaoTools.getResult(rs);
	}

	@Override
	public boolean update(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs=false;
		if(delete(alias.getAnimeId())&&insert(alias))
			rs=true;
		return rs;
	}




	


}
