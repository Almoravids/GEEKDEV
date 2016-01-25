package pack;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TEST {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Method method=(Method)Method.getcontext();
try {
	System.out.println(Inet4Address.getLocalHost());
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//	List<Type> visitor=method.getTypes();
//	System.out.println(visitor.get(0).getType());
	}

}
