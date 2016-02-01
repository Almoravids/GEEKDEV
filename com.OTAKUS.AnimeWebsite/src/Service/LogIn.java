package Service;

import java.sql.SQLException;


import Dao.VisitorDao;
import beans.Visitor;

public class LogIn {
public boolean Login(String user,String password) throws ClassNotFoundException, SQLException{
	VisitorDao visitorDao=new VisitorDao();
	Visitor visitor=visitorDao.get(user);
	if (visitor!=null&&visitor.getPassword().equalsIgnoreCase(password))
	return true;
	else 
    return false;
};

public boolean LogOut(Session session){
		session.g
	return true;
}; 
}
