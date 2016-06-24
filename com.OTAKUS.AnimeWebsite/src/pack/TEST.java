package pack;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.dao.DataAccessException;
import org.springframework.test.context.TestContextManager;

import com.sun.javafx.scene.control.skin.SeparatorSkin;

import Dao.SeasonDao;
import Service.AnimeImpl;
import Service.EpisodeImpl;
import Service.SeasonImpl;
import beans.Alias;
import beans.Anime;
import beans.Episode;
import beans.Season;
import beans.Type;

public class TEST {
	public URL link;
public TEST() {
	link=getClass().getResource("");
}
public static void main(String[] args) {
//	NotificationImpl n=new NotificationImpl();
//	try {
//		System.out.println(Tools.listJSInstance(new MovieDao().searchByType("Adventure")));
//	} catch (DataAccessException | ClassNotFoundException | SQLException e) {
//		e.printStackTrace();
//	}
	TEST t=new TEST();
	System.out.println(t.link.getHost());
	
	}
static void checkObj(Object object){
	if (object instanceof List){
		List list =(List)object;
		for (Object obj: list)
			if (Objects.nonNull(obj))
				System.out.println(obj.toString());
		}
				
}
}

 