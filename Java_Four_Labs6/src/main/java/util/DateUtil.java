package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static DateUtil getInstance() {

		DateUtil d = null;
		if (d == null) {
			d = new DateUtil();
		}
		return d;
	}

	public Date toDate(String param, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(param);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
