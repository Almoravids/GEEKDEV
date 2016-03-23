package pack;

import Dao.VisitorDao;
import beans.Visitor;

public class TEST {
public static void main(String[] args) {

	
	VisitorDao visitorDao =new VisitorDao();
	try {
		Visitor visitor=visitorDao.get("Mr Mahdi");
		visitor.setFirstName("oussim");
		boolean visit=visitorDao.update(visitor);
		System.out.println(visit);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
}
                            