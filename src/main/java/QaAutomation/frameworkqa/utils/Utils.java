package QaAutomation.frameworkqa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Common utils
 * @author vinothkumar
 *
 */
public class Utils {

	public static String getCurrentTime()  {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		Date localDate = new Date();
		return localSimpleDateFormat.format(localDate);
	}
}

