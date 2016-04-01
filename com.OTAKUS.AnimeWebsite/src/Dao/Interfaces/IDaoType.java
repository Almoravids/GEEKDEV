package Dao.Interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.Type;

public interface IDaoType {
	public  boolean insert(Type Type) throws DataAccessException, ClassNotFoundException, SQLException;
	public boolean insertKind(List<Type> types,int animeId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  boolean delete(String typeName) throws DataAccessException, ClassNotFoundException, SQLException;
    public boolean deleteKind(int typeId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<Type> get(int animeId) throws DataAccessException, ClassNotFoundException, SQLException;
	public  List<Type> getAll() throws DataAccessException, ClassNotFoundException, SQLException;
}
