package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Service.interfaces.IAlias;
import beans.Alias;

public class AliasImpl implements IAlias<Alias,Integer> {

	@Override
	public boolean insert(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer aliasId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Alias> get(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  boolean insertAll(List<Alias> listAlias)  throws DataAccessException, ClassNotFoundException, SQLException {
		int rs=0;
		for (Alias alias:listAlias)
			if(insert(alias))
				rs++;
		if (rs==listAlias.size())
		return true;
		else 
		return false;
	}

	@Override
	public  boolean updateAll(List<Alias> listAlias)  throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs=false;
		for (Alias alias :listAlias)
			delete(alias.getAnimeId());
			if(insertAll(listAlias))
				rs=true;
			return rs;
	}






	
}
