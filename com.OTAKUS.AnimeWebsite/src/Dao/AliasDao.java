package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sun.glass.ui.GestureSupport;

import Dao.interfaceClasses.DaoUpdate;
import Object.Alias;
import Object.Anime;

public class AliasDao extends DaoUpdate<Alias,Integer>{

	@Override
	public List<Alias> get(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		return (List<Alias>)getConnection().query("select * from alias where id_anime="+alias.getAliasId(),new Alias());
	}

	@Override
	public List<Alias> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		return (List<Alias>) getConnection().query("select * from alias",new Alias());
	}



	@Override
	public boolean insert(Alias Alias) throws DataAccessException, ClassNotFoundException, SQLException {
	       int rs=getConnection().update("insert into alias values(alias_seq.nextval,?,?)",Alias.getAliasId(),Alias.getAnimeId());
           return getResult(rs);
	}

	

	@Override
	public boolean delete(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=getConnection().update("delete from alias where id_anime="+alias.getAnimeId());
	    return getResult(rs);
	}

	@Override
	public boolean update(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs=false;
		if(delete(alias)&&insert(alias))
			rs=true;
		return rs;
	}



}
