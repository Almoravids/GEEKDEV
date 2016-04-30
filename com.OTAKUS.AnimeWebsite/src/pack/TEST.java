package pack;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import Service.AnimeImpl;
import Service.EpisodeImpl;
import beans.Anime;

public class TEST {

public static void main(String[] args) {

AnimeImpl animeImpl=new AnimeImpl();
List<Anime> animes;
char startWith='a';
List<Character> letters=new ArrayList<>(); 
try {
	animes=animeImpl.getAll();
	Anime mAnime=new Anime();
	mAnime.setName("2LM");
	animes.add(0,mAnime);
	for (Anime anime :animes){
		if (!anime.getName().startsWith(startWith+"")){
			if (anime.getName().matches("^[a-zA-Z].*")){
			startWith=anime.getName().charAt(0);
			letters.add(startWith);
			}
			else{
				startWith='#';
				letters.add(startWith);	
			}
			
				System.out.println(startWith);
		}
			
		System.out.println(anime.getName());
		
		
	}
	
	for (int a='a';a<'z';a++){
		System.out.println((char)a);
	}
	System.out.println(letters+"	"+letters.size());
	
	System.out.println(new AnimeImpl().get("dragon ball z"));

} catch (DataAccessException | ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
                            