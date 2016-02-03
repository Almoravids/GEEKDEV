package Dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Dao.Interfaces.IDaoID;
import beans.Anime;
import beans.Type;

public class TypeDao implements IDaoID<Type, String>{

	@Override
	public boolean insert(Type t) throws DataAccessException, ClassNotFoundException, SQLException {
		int rs =DaoConnection.getConnection().update("insert into type values(type_seq.nextval,?)",t.getType());
		return DaoTools.getResult(rs);
	}
	
    public boolean insertKind(Anime anime) throws DataAccessException, ClassNotFoundException, SQLException{
    	int rs=0;
    	  if (anime.getAnimeId()==0)
    		anime.setId(DaoConnection.getConnection().queryForInt("select max(id_anime) from anime"));
    	  for(Type type : anime.getGenre())
    		rs=  DaoConnection.getConnection().update("insert into kind values(?,?)",anime.getAnimeId(),DaoConnection.getConnection().queryForInt("select id_type from type where type=?",type.getType()));
              return DaoTools.getResult(rs);    
    }
	@Override
	public boolean delete(String type) throws DataAccessException, ClassNotFoundException, SQLException {
		 int rs= DaoConnection.getConnection().update("delete from type where type=?",type);
		return DaoTools.getResult(rs);
	}
	public boolean deleteKind(int idAnime) throws DataAccessException, ClassNotFoundException, SQLException{
		 int rs= DaoConnection.getConnection().update("delete from kind where id_anime="+idAnime);
			return DaoTools.getResult(rs);
	}  
	
	public List<Type> get(int idAnime) throws DataAccessException, ClassNotFoundException, SQLException {
		 return (List<Type>)DaoConnection.getConnection().query("select t.* from kind k,type t where k.id_type=t.id_type and k.id_anime="+idAnime,new Type()); 
	}
     
	public List<Type> getAll() throws DataAccessException, ClassNotFoundException, SQLException { 
		return (List<Type>)DaoConnection.getConnection().query("select * from type order by type",new Type()); 
	}
}
