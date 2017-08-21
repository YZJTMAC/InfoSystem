package framelib.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title:DateUtil Description:
 * 
 * @Create_by:Vince Yu
 * @Create_date:2012-5-9
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class DateUtil {

	public static String dateFormat = "yyyy-MM-dd";
	public static String dateFormatNum = "yyyyMMdd";
	public static String timeFormatMinute = "HH:mm:ss";
	public static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
	public static String dateTimeFormatCH = "yyyy年MM月dd日";
	public static String dateFormatMinute = "yyyy-MM-dd HH:mm";
	public static String dateFormatMinuteSlash = "yyyy/MM/dd HH:mm";
	public static String dateFormatYmd = "yyyy/MM/dd";
	public static String dateFormatYear = "yyyy";
	public static String dateTimeFormatJoin = "yyyyMMddHHmmss";  //精确到秒，没有分割符
	/**
	 * Title:getSystemTime Description:获取系统时间
	 * 
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-9
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static Timestamp getSystemTime() throws IllegalAccessException,
			InvocationTargetException {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * Title:getSystemTime Description:根据类型获取系统时间
	 * 
	 * @param type
	 *            时间类型 date：日期，second：时间
	 * @Create_by:Vince Yu
	 * @Create_date:2012-5-9
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:178xf 1.0
	 */
	public static String getSystemTime(String type) {
		String formcat = "";
		if (type.equalsIgnoreCase("date")) {
			formcat = dateFormat;
		} else if (type.equalsIgnoreCase("second")) {
			formcat = dateTimeFormat;
		} else if (type.equalsIgnoreCase("minute")) {
			formcat = dateFormatMinute;
		} else if (type.equalsIgnoreCase("time")) {
			formcat = timeFormatMinute;
		} else if (type.equalsIgnoreCase("dayFile")) {
			formcat = dateFormatYmd;
		} else if (type.equalsIgnoreCase("year")) {
			formcat = dateFormatYear;
		} else if(type.equalsIgnoreCase("timeJoin")){
			formcat = dateTimeFormatJoin;
		}
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(formcat);
		Date date = new Date();
		return bartDateFormat.format(date).toString();
	}

	public static String getSystemTimeFormat(String format) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return bartDateFormat.format(date).toString();
	}

	/**
	 * 获得指定日期的前N天
	 */
	public static String getDayBeforeSomeDay(String theDate, int n) {
		return getDayBeforeSomeDay(theDate, DateUtil.dateTimeFormat, n);
	}

	/**
	 * 获得指定日期的前N天
	 */
	public static String getDayBeforeSomeDay(String theDate, String dateFormat,
			int n) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(dateFormat).parse(theDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - n);
		String dayBefore = format(c.getTime(), dateFormat);
		return dayBefore;
	}

	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		return format(date, getDatePattern());
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return returnValue;
	}

	public static String getDatePattern() {
		return dateFormat;
	}

	public static String getSystemTime4Name() throws IllegalAccessException,
			InvocationTargetException {
		String formcat = "";
		formcat = "yyyy-MM-dd-hh-mm-ss";
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(formcat);
		Date date = new Date();
		return bartDateFormat.format(date).toString();
	}
	/**
	 * 获取N月以后的系统时间
	 * @param months  月数
	 * @param format  格式比如： yyyy-MM-dd HH:mm:ss    yyyy/MM/dd HH:mm
	 * @return  当前时间和N月以后的时间，中间以逗号分割
	 */
	public static String getTimeAfterSomeMonths(int months,String format){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, months);
		Date date = calendar.getTime();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
		return bartDateFormat.format(new Date())+","+bartDateFormat.format(date);
	}
	/**
	 * 比较两个时间
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 * DATE1<DATE2 -1;DATE1>DATE 1;DATE1=DATE 0
	 */
	public static int compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
}
