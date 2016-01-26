package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.interfaceClasses.DaoUpdate;
import Object.Alias;

public class AliasDao extends DaoUpdate<Alias>{

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

	@Override
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

	@Override
	public boolean updateAll(List<Alias> ListAlias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs=false;
		for (Alias alias :ListAlias)
			delete(alias);
			if(insertAll(ListAlias))
				rs=true;
			return rs;
	}



}
