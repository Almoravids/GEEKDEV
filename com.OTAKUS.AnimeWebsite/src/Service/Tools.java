package Service;

import java.sql.Timestamp;
import java.util.Date;

public class Tools {
	public static String dateToString(Timestamp date) {
		String dateStr = "";
		
		long interval = dateInterval(new Date(2016, 4, 12, 18, 52, 01), date);
		System.out.println(new Date(2016, 4, 12).getTime()+"   "+new Date().getTime());
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

	public static void main(String[] args) {
		dateToString(new Timestamp(new Date().getTime()));
	}
}
