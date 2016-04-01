package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.AnimeDao;
import Service.interfaces.IAnime;
import beans.Anime;

public class AnimeImpl implements IAnime<Anime,Integer>{
    private AnimeDao animeDao;
    
    {
    	animeDao=new AnimeDao();
    }
	@Override
	public boolean insert(Anime Anime) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Anime Anime) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Anime get(Integer animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anime> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		List<Anime> list;
		list=animeDao.getAll();
		return list;
	}

	@Override
	public List<Anime> getAllByAlias(Integer aliasId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anime> getAllByType(Integer aliasId) throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
