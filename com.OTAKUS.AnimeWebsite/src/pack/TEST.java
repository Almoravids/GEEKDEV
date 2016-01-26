package pack;

import java.sql.SQLException;

import Dao.AliasDao;
import Object.Alias;

public class TEST {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	AliasDao alias=new AliasDao();
	for (Alias ab:alias.getAll())
	for (Alias a:alias.get(ab))
		System.out.println("AAA"+a.getAlias());
	}

}
                            