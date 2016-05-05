package pack;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import Service.AnimeImpl;
import beans.Favorite;

public class TEST {

public static void main(String[] args) {
	Favorite fav= new Favorite();
	fav.setAnimeId(3);
	fav.setUsername("Mr Mahdi");
try {
	System.out.println(new AnimeImpl().getQueued("Mr Anas"));
} catch (DataAccessException | ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}
}

}

