package project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author cxw
 * 
 */
public final class DateUtil {
	public static final String FORMATE_STYLE_DATA_SHORT = "yyyy-MM-dd";

	public static final String FORMATE_STYLE_DATA_LONG = "yyyy-MM-dd HH:mm:ss";

	private static DateUtil instance = null;

	public static DateUtil getInstance() {
		if (instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}

	private DateUtil() {
	}

	/**
	 * 当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}
	
	/**
	 * convert string to date, with default pattern,throws ParseException
	 * 
	 * @param strDate
	 *            the str date
	 * @return date
	 */
	public static Date strToDate(String strDate) {
		return strToDate(strDate, FORMATE_STYLE_DATA_SHORT);
	}

	public static Date toSimpleDateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATE_STYLE_DATA_LONG);
		return strToDate(sdf.format(date), FORMATE_STYLE_DATA_LONG);
	}

	/**
	 * convert string to date ,with custom pattern,throws
	 * IllegalArgumentException
	 * 
	 * @param strDate
	 * @param format
	 *            format style such as yyyy-MM-dd
	 * @return the date.
	 */
	public static Date strToDate(String strDate, String format) {
		if (strDate == null || "".equals(strDate)) {
			return null;
		}
		Date result = null;
		try {
			SimpleDateFormat formater = new SimpleDateFormat(format);
			result = formater.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("String To Date Convert Error", e);
		}
		return result;
	}

	/**
	 * Date to String format as CEMConstants.FORMATE_STYLE_DATA("yyyy-MM-dd").
	 * 
	 * @param date
	 * @return the string value format as
	 *         CEMConstants.FORMATE_STYLE_DATA("yyyy-MM-dd").
	 */
	public static String dateToShortStr(Date date) {
		return dateToStr(date, FORMATE_STYLE_DATA_SHORT);
	}

	public static String dateToLongStr(Date date) {
		return dateToStr(date, FORMATE_STYLE_DATA_LONG);
	}

	public static String dateToLongStr(Date date, Integer hour, Integer minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour == null ? 0 : hour);
		cal.set(Calendar.MINUTE, minute == null ? 0 : minute);
		cal.set(Calendar.SECOND, 0);

		return dateToLongStr(cal.getTime());
	}

	/**
	 * Date to String accroding to the format.
	 * 
	 * @param date
	 *            date
	 * @param format
	 *            format
	 * @return the string format of the data value.
	 */
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date);
	}

	/**
	 * 获得给定时间的00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dealwithDateNull(date));

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startTime = calendar.getTime();
		return startTime;
	}

	/**
	 * 获得当天的开始时间00:00:00
	 * 
	 * @return
	 */
	public static Date getTodayStart() {
		return getStartTime(now());
	}

	/**
	 * 获得当天的结束时间23:59:59
	 * 
	 * @return
	 */
	public static Date getTodayEnd() {
		return getEndTime(now());
	}

	/**
	 * 获得给定时间的23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dealwithDateNull(date));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date startTime = calendar.getTime();
		return startTime;
	}

	/**
	 * Deal with the date -- if the date is null then return the current time
	 * otherwise return itself.
	 * 
	 * @param date
	 *            date
	 * @return date
	 */
	public static Date dealwithDateNull(Date date) {
		if (date == null) {
			return new Date();
		}
		return date;
	}

	/**
	 * 获得当前年份，例如2012
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		SimpleDateFormat yearFm = new SimpleDateFormat("yyyy");
		return Integer.parseInt(yearFm.format(date));
	}
    /**
     * 获得当前月份，例如08
     * @param date
     * @return
     */
	public static String getMonth(Date date) {
		SimpleDateFormat monthFm = new SimpleDateFormat("MM");
		return monthFm.format(date);
	}
    /**
     * 获得当前日期（不包括年月），例如17
     * @param date
     * @return
     */
	public static int getDay(Date date) {
		SimpleDateFormat dayFm = new SimpleDateFormat("DD");
		return Integer.parseInt(dayFm.format(date));
	}
	
	/**
	 * 传进数字返回**小时**分钟
	 * 
	 */
	public static String getHHMM(Integer ss)
	{
		String str="";
		if(ss!=null)
		{
			int HH=ss/(60*60);
			int MM=(ss-HH*60*60)/60;
			str=HH+"小时"+MM+"分钟";
		}
		else
		{
			str="0小时0分钟";
		}
		return str;
	}
	//java获取当前时间的前后N天
	public static Date getDay(Date date,Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 判断时间是否在时间段内
	 * 
	 * @param date
	 *            当前时间 yyyy-MM-dd HH:mm:ss
	 * @param strDateBegin
	 *            开始时间 00:00:00
	 * @param strDateEnd
	 *            结束时间 00:05:00
	 * @return
	 * @throws ParseException 
	 */
	public static boolean isInDate(String strDate, String strDateBegin,String strDateEnd){
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String strDate = sdf.format(date);
		
		//对时间毫秒值进行判断
		Date d = new Date();  
        System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(d);  
        System.out.println("格式化后的日期：" + dateNowStr); 
		
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		try {
			c1.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate));
			c2.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateNowStr+" "+strDateBegin));
			c3.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateNowStr+" "+strDateEnd));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("strDate时间转化后的毫秒数为："+c1.getTimeInMillis());
		System.out.println("strDateBegin时间转化后的毫秒数为："+c2.getTimeInMillis());
		System.out.println("strDateEnd时间转化后的毫秒数为："+c3.getTimeInMillis());
		
		//时间区间判断
		if(c1.getTimeInMillis()<c3.getTimeInMillis() && c1.getTimeInMillis()>c2.getTimeInMillis()){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static void main(String args[])
	{
		
		System.out.println(getHHMM(360000));
	}

}
