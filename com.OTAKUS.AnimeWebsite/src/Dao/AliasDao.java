package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoID;
import Dao.Interfaces.IDaoIUDG;
import Dao.Interfaces.IDaoIUDGGA;
import beans.Alias;

public class AliasDao implements IDaoID<Alias,Integer>{

	
	public List<Alias> get(Integer aliasId) throws DataAccessException, ClassNotFoundException, SQLException {
		return (List<Alias>)DaoConnection.getConnection().query("select * from alias where id_anime="+aliasId,new Alias());
	}



	@Override
	public boolean insert(Alias Alias) throws DataAccessException, ClassNotFoundException, SQLException {
	       int rs=DaoConnection.getConnection().update("insert into alias values(alias_seq.nextval,?,?)",Alias.getAlias(),Alias.getAnimeId());
           return DaoTools.getResult(rs);
	}

	

	@Override
	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=DaoConnection.getConnection().update("delete from alias where id_anime="+animeId);
	    return DaoTools.getResult(rs);
	}

	
	public boolean update(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs=false;
		if(delete(alias.getAnimeId())&&insert(alias))
			rs=true;
		return rs;
	}


	public boolean insertAll(List<Alias> ListAlias) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=0;
		for (Alias alias:ListAlias)
			if(insert(alias))
				rs++;
		if (rs==ListAlias.size())
		return true;
		else 
		return false;
	}


	public boolean updateAll(List<Alias> ListAlias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs=false;
		for (Alias alias :ListAlias)
			delete(alias.getAnimeId());
			if(insertAll(ListAlias))
				rs=true;
			return rs;
	}



}
