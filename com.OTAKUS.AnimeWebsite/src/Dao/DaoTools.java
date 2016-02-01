package Dao;

public class DaoTools {
public static boolean getResult(int rs){
	boolean brs=true;
	if (rs==0)
		brs=false;
	return brs;
}
}
