package pack;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import Service.FavoriteImpl;
import beans.Favorite;

public class TEST {

public static void main(String[] args) {
Favorite fav=new Favorite();
fav.setAnimeId(2);
fav.setUsername("Mr Mahdi");
FavoriteImpl favImpl=new FavoriteImpl();
try {
	System.out.println(favImpl.delete(fav));
	System.out.println(favImpl.check(fav));
	
	System.out.println(favImpl.getAll(fav.getUsername()).size());
} catch (DataAccessException | ClassNotFoundException | SQLException e) {
}
}
}
                            