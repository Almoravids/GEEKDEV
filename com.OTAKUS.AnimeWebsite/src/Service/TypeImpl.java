package Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.TypeDao;
import Service.interfaces.IType;
import beans.Type;

public class TypeImpl implements IType {
  TypeDao typeDao;
  {
	  typeDao=new TypeDao();
  }
	@Override
	public boolean insert(Type type) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=typeDao.insert(type);
		return rs;
	}

	@Override
	public boolean insertKind(List<Type> types, int animeId)
			throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=typeDao.insertKind(types, animeId);
		return rs;
	}

	@Override
	public boolean delete(String typeName) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=typeDao.delete(typeName);
		return rs;
	}

	@Override
	public boolean deleteKind(int typeId) throws DataAccessException, ClassNotFoundException, SQLException {
		boolean rs;
		rs=typeDao.deleteKind(typeId);
		return rs;
	}

	@Override
	public List<Type> get(int animeId) throws DataAccessException, ClassNotFoundException, SQLException {
		List<Type> typeList;
		typeList=typeDao.get(animeId);
		return typeList;
	}

	@Override
	public List<Type> getAll() throws DataAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
