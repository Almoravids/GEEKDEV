package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sun.glass.ui.CommonDialogs.Type;

import Object.Alias;
import Object.Anime;
import Object.Visitor;

@Component
public class Method {

/********************************GetANiME*******************************/
  public List<Anime> getAnimes() throws SQLException, ClassNotFoundException{  
       getConnection();    
         List<Anime> list= (List<Anime>)j.query("select a.* from anime a",new Anime());
         for (Anime a:list){
        	 List<Alias> aliasList=new ArrayList<Alias>();
        	     for (Alias alias:getAlies())
        		if (alias.getAnimeId()==a.getAnimeId())
        			aliasList.add(alias);
        	    	a.setAlias(aliasList);
        	a.setGenre(getGenre(a.getAnimeId()));}
        
         return list;
   } 
  
  public Anime getAnime(String id_anime) throws SQLException, ClassNotFoundException{  
      getConnection();    
     Anime a=(Anime)j.queryForObject("select a.* from anime a where id_anime="+id_anime+"order by id_alias asc",new Anime());
   
		a.setAlias(getAlias(a.getAnimeId()));
    	
    
    	a.setGenre(getGenre(a.getAnimeId()));
    
     return a;
} 



public List<Type> getTypes() throws ClassNotFoundException, SQLException{
	getConnection();
	  
	return (List<Type>)j.query("select * from type order by name",new Type()); 
}

public List<String> getStatue() throws ClassNotFoundException, SQLException{
	getConnection();
	return j.queryForList("select statue from statue",String.class); 
}

public List<Type> getGenre(int idAnime)throws ClassNotFoundException, SQLException{
		getConnection();
		 return (List<Type>)j.query("select t.* from kind k,type t where k.id_type=t.id_type and k.id_anime="+idAnime,new Type()); 
	  }
public List<Visitor> getUsers() throws SQLException, ClassNotFoundException{  
    getConnection();    
   List<Visitor> visitor=(List<Visitor>)j.query("select * from visitor order by username",new Visitor());
   return visitor;
} 
public Visitor getUser(String username) throws SQLException, ClassNotFoundException{  
    getConnection();    
   Visitor visitor=(Visitor)j.queryForObject("select * from visitor where username='"+username+"'",new Visitor());

   return visitor;
}
  /********************************* .::| INSERTING |::. ************************/
  public int insertAnime(Anime anime) throws SQLException, ClassNotFoundException{
	  
	  getConnection();
    int a=  j.update("insert into anime values(anime_seq.nextval,?,?,?)",anime.getDesc(),anime.getImageLink(),anime.getStatue());
    if (a==1) {
   insertAlias(anime);
   insertKind(anime);
    }
    return a;
  }
  
  @SuppressWarnings("deprecation")
public void insertAlias(Anime anime) throws ClassNotFoundException, SQLException{
	  getConnection();
	  if (anime.getAnimeId()==0)
		  anime.setId(j.queryForInt("select max(id_anime) from anime"));
	  for(Alias alias : anime.getAlias())
		     j.update("insert into alias values(alias_seq.nextval,?,?)",alias.getAlias(),anime.getAnimeId());
  }
  
 
@SuppressWarnings("deprecation")
public void insertKind(Anime anime) throws ClassNotFoundException, SQLException{
	  getConnection();
	  if (anime.getAnimeId()==0)
		  anime.setId(j.queryForInt("select max(id_anime) from anime"));
	  for(Type type : anime.getGenre())
		     j.update("insert into kind values(?,?)",anime.getAnimeId(),j.queryForInt("select id_type from type where name=?",type.getType()));
  }
  
public void insertGenre(String genre) throws ClassNotFoundException, SQLException{
	getConnection();
	j.update("insert into type values(type_seq.nextval,?)",genre);
}
//insert into visitor values('Mr Mahdi','Mahdi','Rmila',to_date('26-dec-94'),'mehdi@gmail.com','123456','adminSup');

public void insertUser(Visitor visitor) throws ClassNotFoundException, SQLException{
	getConnection();
	j.update("insert into visitor values(?,?,?,?,?,'user',?)",visitor.getUserName(),visitor.getName(),visitor.getLastName(),
			visitor.getEmail(),visitor.getPassword(),visitor.getImageLink());
}
/*********************** .::| UPDATING |::. ******************/
  public void updateAnime(Anime anime) throws ClassNotFoundException, SQLException{
	  getConnection();
	    int a=  j.update("update anime set description=? , link_img=? , id_statue=? where id_anime=?",anime.getDesc(),anime.getImageLink(),anime.getStatue(),anime.getAnimeId());
	    if (a==1) {
	    	if (!anime.getAlias().equals(getAlias(anime.getAnimeId()))){
	    deleteAlias(anime.getAnimeId());
	     insertAlias(anime);}
	    	if (!anime.getGenre().equals(getGenre(anime.getAnimeId()))){
	     deleteKind(anime.getAnimeId());
	     insertKind(anime);}
	    }
	       
  }
  
  public void GradeUser(Visitor visitor) throws ClassNotFoundException, SQLException{
	  getConnection();
	    int a=  j.update("update visitor set type_user=? where username=?",visitor.getType(),visitor.getUserName());
  }
  
  /*************************** .::| DELETING |::. *****************************/
  public void deleteAnime(String animeName) throws ClassNotFoundException, SQLException{
	  getConnection();
	  int idAnime = j.queryForInt("select id_anime from alias where name=?",animeName);
	  deleteAlias(idAnime);
	  deleteKind(idAnime);
	  j.update("delete from anime where id_anime="+idAnime);
  }
  
  public void deleteKind(int idAnime) throws ClassNotFoundException, SQLException{
	  getConnection();
	  j.update("delete from kind where id_anime="+idAnime);
	  
  }
  public void deleteGenre(String genre) throws ClassNotFoundException, SQLException{
	  getConnection();
	  j.update("delete from type where name=?",genre);
	  
  }
  public void deleteUser(String userName) throws ClassNotFoundException, SQLException{
	  getConnection();
	    int a=  j.update("delete from visitor where username=?",userName);
  }
  }