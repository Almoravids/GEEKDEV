package pack;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;

import Dao.AnimeDao;
import beans.Alias;
import beans.Anime;
import beans.Type;

public class TEST {
public static void main(String[] args) {
AnimeDao animeDao=new AnimeDao();
Anime anime=new Anime();
anime.setName("hunter");
anime.setDescription("desc");
anime.setImageLink("image");
anime.setStatue(1);
ArrayList<Alias> aliasList=new ArrayList<>();
aliasList.add(new Alias(anime.getAnimeId(),"HXH"));
anime.setAlias(aliasList);

ArrayList<Type> typesList=new ArrayList<>();
typesList.add(new Type("Horror"));
try {
	animeDao.insert(anime);
	
} catch (DataAccessException | ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}
                            