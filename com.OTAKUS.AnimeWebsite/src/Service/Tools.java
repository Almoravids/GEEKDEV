package Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Part;

public class Tools {
	
	public static boolean saveImage(String link,Part part) {
		boolean rs=false;
		
//		if (!link.endsWith("/"))
//			link+="/";
		try{
			String fileName=part.getSubmittedFileName();
			InputStream streamIn=part.getInputStream();
			
		OutputStream streamOut=new FileOutputStream(link);
		byte[] bytes=new byte[(int) part.getSize()];
		int read=0;
		while((read=streamIn.read(bytes))!=-1){
			streamOut.write(bytes, 0, read);
		}
		rs=true;
		}catch(IOException e){
			e.printStackTrace();
		}
		return rs;
	}
	public static String dateToString(Date date) {
		String dateStr = "";
		
		long interval = dateInterval(new Date(), date);
		System.out.println(date+"   "+new Date());
		if (interval / (60 * 60 * 24 * 30 * 12) > 0) {
			interval /= (60 * 60 * 24 * 30 * 12);
			dateStr = "year";
		} else if (interval / (60 * 60 * 24 * 30) > 0) {
			interval /= (60 * 60 * 24 * 30);
			dateStr = "month";
		} else if (interval / (60 * 60 * 24) > 0) {
			interval /= (60 * 60 * 24);
			dateStr = "day";
		} else if (interval / (60 * 60) > 0) {
			interval /= (60 * 60);
			dateStr = "hour";
		} else if (interval / (60) > 0) {
			interval /= (60);
			dateStr = "min";
		} else
			dateStr = "sec";

		if (interval > 1)
			dateStr += "s";
		System.out.println(interval + " " + dateStr + " ago");

		return interval + " " + dateStr + " ago";
	}

	static long dateInterval(Date supDate, Date minDate) {
		return (supDate.getTime() - minDate.getTime()) / (1000);
	}

	public static String toJSObject(Object obj) {
		String js;
		Class c = obj.getClass();
		Method[] methods = c.getDeclaredMethods();
		int counter = 0;
		js = "function " + c.getSimpleName() + "(";
		for (Method m : methods)
			if (m.getName().startsWith("get")) {
				if (counter > 0)
					js += ",";
				js += m.getName().substring(3, m.getName().length()).toLowerCase();
				counter++;
			}
		js += "){";
		counter = 0;
		for (Method m : methods)
			if (m.getName().startsWith("get")) {
				js += "this." + m.getName().substring(3, m.getName().length()).toLowerCase() + "="
						+ m.getName().substring(3, m.getName().length()).toLowerCase() + ";";
			}
		js += "};";
		return js;
	}

	public static String toJSInstance(Object obj) {
		String js;
		Class c = obj.getClass();
		js = "var " + c.getSimpleName().toLowerCase() + "=[new " + c.getSimpleName() + "(";
		java.lang.reflect.Method[] methods = c.getDeclaredMethods();
		int counter = 0;
		for (Method m : methods)
			if (m.getName().startsWith("get")) {

				try {
					if (counter > 0)
						js += ",";
					js += "'"+m.invoke(obj)+"'";
					counter++;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		js += ")];";
		return js;
	}
	
	public static String listJSInstance(List listObj) {
		String js;
		js = "var " + listObj.get(0).getClass().getSimpleName().toLowerCase() + "s=[";
		for(Object obj :listObj){
		Class c = obj.getClass();
		if (js.endsWith(")"))
				js+=",";
		js+="new " + c.getSimpleName() + "(";
		java.lang.reflect.Method[] methods = c.getDeclaredMethods();
		int counter = 0;
		for (Method m : methods)
			if (m.getName().startsWith("get")) {

				try {
					if (counter > 0)
						js += ",";
					if (m.invoke(obj) instanceof Timestamp)
					js += "'"+Tools.dateToString((Date)m.invoke(obj))+"'";
					else
						js += "'"+m.invoke(obj)+"'";
					counter++;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		js+=")";
		}
		js += "];";
		return js;
	}
	boolean saveImage(String link,String file,Part part) {
		boolean rs=false;

		String fileName=part.getSubmittedFileName();
		if (fileName.matches(".*\\.(png|jpg|png|jpeg)")){
		if (!link.endsWith("/"))
			link+="/";
		try{
			InputStream streamIn=part.getInputStream();
		OutputStream streamOut=new FileOutputStream(link+file);
		byte[] bytes=new byte[(int) part.getSize()];
		int read=0;
		while((read=streamIn.read(bytes))!=-1){
			streamOut.write(bytes, 0, read);
		}
		rs=true;
		streamIn.close();
		streamOut.flush();
		streamOut.close();
		}catch(IOException e){
			e.printStackTrace();
		}}
		else{
			rs=false;
		}
		
		return rs;
	}
}
