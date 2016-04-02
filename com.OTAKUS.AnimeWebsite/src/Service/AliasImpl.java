package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.AliasDao;
import Service.interfaces.IAlias;
import beans.Alias;

public class AliasImpl implements IAlias<Alias, Integer> {
	AliasDao aliasDao;

	@Override
	public boolean insert(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=aliasDao.insert(alias);
		return rs;
	}

	@Override
	public boolean update(Alias alias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=aliasDao.update(alias);
		return rs;
	}

	@Override
	public boolean delete(Integer aliasId) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=aliasDao.delete(aliasId);
		return rs;
	}

	@Override
	public List<Alias> get(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		return aliasDao.get(animeId);
	}

	@Override
	public boolean insertAll(List<Alias> listAlias) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs = 0;
		for (Alias alias : listAlias)
			if (insert(alias))
				rs++;
		if (rs == listAlias.size())
			return true;
		else
			return false;
	}

	@Override
	public boolean updateAll(List<Alias> listAlias) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs = false;
		for (Alias alias : listAlias)
			delete(alias.getAnimeId());
		if (insertAll(listAlias))
			rs = true;
		return rs;
	}

}
