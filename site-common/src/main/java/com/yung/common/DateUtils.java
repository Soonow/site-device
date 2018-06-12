package com.yung.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 日期工具类
 *
 * @author XIONGXING
 */
public class DateUtils {

	public static final String DATE_FORMAT_TYPE1 = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_TYPE2 = "yyyy-MM-dd HH:mm:ss:SSS";
	public static final String DATE_FORMAT_TYPE3 = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYYMMDDHH = "yyyyMMddHH";
	public static final String YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";

	/**
	 * 比较两个时间的差
	 *
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	public static String compareDate(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return "";
		}

		StringBuffer date = new StringBuffer();
		long time = Math.abs(endDate.getTime() - startDate.getTime());
		int hour = (int) (time / (1000 * 3600));
		if (hour > 0 || date.length() > 0) {
			date = date.append(hour).append(" 时  ");
		}

		time = time - hour * (1000 * 3600);
		int minute = (int) (time / (1000 * 60));
		if (minute > 0 || date.length() > 0) {
			date = date.append(minute).append(" 分 ");
		}

		time = time - minute * (1000 * 60);
		int second = (int) (time / (1000));
		if (second > 0 || date.length() > 0) {
			date = date.append(second).append(" 秒 ");
		} else {
			date = date.append(0).append(" 秒 ");
		}
		return date.toString();
	}

	/**
	 * 取两个日期中较早的一个日期
	 *
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Date getEarlierDate(Date d1, Date d2) {
		if (d1.after(d2)) {
			return d2;
		} else {
			return d1;
		}
	}

	/**
	 * 取两个日期中较晚的一个日期
	 *
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Date getLaterDate(Date d1, Date d2) {
		if (d1.before(d2)) {
			return d2;
		} else {
			return d1;
		}
	}

	/**
	 * 根据"yyyymmdd"格式的日期返回日期所属的“yyyymm”格式的月份
	 *
	 * @param date
	 * @return
	 */
	public static long dateToMon(long date) {
		String mon = String.valueOf(date).substring(0, 6);
		return Long.parseLong(mon);
	}

	/**
	 * 取与当前月份相间隔指定月份数的月份
	 *
	 * @param month
	 *            格式为 "yyyymm"
	 * @param offset
	 *            间隔月份数,正负均可
	 */
	public static long addMonth(long month, int offset) {
		int year = Integer.parseInt(String.valueOf(month).substring(0, 4));
		int mon = Integer.parseInt(String.valueOf(month).substring(4, 6));
		if (offset >= 0) {
			for (int i = 1; i <= offset; i++) {
				mon++;
				if (mon > 12) {
					mon = 1;
					year++;
				}
			}
		} else {
			for (int i = -1; i >= offset; i--) {
				mon--;
				if (mon < 1) {
					mon = 12;
					year--;
				}
			}
		}
		return year * 100 + mon;
	}

	/**
	 * 取与指定时间间隔若干天的时间
	 *
	 * @param offset
	 * @return
	 */
	public static Date addDay(String dateStr,int offset){
		DateTime dt = DateTime.parse(dateStr,DateTimeFormat.forPattern(DATE_FORMAT_TYPE1));
		return dt.plusDays(offset).toDate();
	}
	public static Date addDay(Date date , int offset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusDays(offset).toDate();
	}
	public static Date addYear(Date date, int offset) {
    	DateTime dt = new DateTime(date.getTime());
		return dt.plusYears(offset).toDate();
	}
    public static Date addMonth(Date date, int offset) {
    	DateTime dt = new DateTime(date.getTime());
		return dt.plusMonths(offset).toDate();
	}
    public static Date addWeek(Date date, int offset) {
    	DateTime dt = new DateTime(date.getTime());
		return dt.plusWeeks(offset).toDate();
	}
	public static DateTime addDay(DateTime date, int offset) {
		
		return date.plusDays(offset);
	}
	
	
	/**
	 * 取与指定时间间隔若干小时的时间
	 *
	 * @param offset
	 * @return
	 */
	public static Date addHour(String dateStr,int offset){
		DateTime dt = DateTime.parse(dateStr);
		return dt.plusHours(offset).toDate();
	}
	public static Date addHour(Date date , int offset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusHours(offset).toDate();
	}
	public static DateTime addHour(DateTime date, int offset) {
		return date.plusHours(offset);
	}
	

	/**
	 * 取与指定时间间隔若干分钟的时间
	 *
	 * @param offset
	 * @return
	 */
	public static Date addMinute(String dateStr,int offset){
		DateTime dt = DateTime.parse(dateStr);
		return dt.plusMinutes(offset).toDate();
	}
	public static Date addMinute(Date date , int offset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusMinutes(offset).toDate();
	}
	public static DateTime addMinute(DateTime date, int offset) {
		return date.plusMinutes(offset);
	}
	public static Date add(Date date,int dayOffset,int hourOffset,int minuteOffset,int secondOffset,int millisOffset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusDays(dayOffset).plusHours(hourOffset).plusMinutes(minuteOffset).plusSeconds(secondOffset).plus(millisOffset).toDate();
	}
	public static Date add(Date date,int dayOffset,int hourOffset,int minuteOffset,int secondOffset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusDays(dayOffset).plusHours(hourOffset).plusMinutes(minuteOffset).plusSeconds(secondOffset).toDate();
	}
	public static Date add(Date date,int dayOffset,int hourOffset,int minuteOffset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusDays(dayOffset).plusHours(hourOffset).plusMinutes(minuteOffset).toDate();
	}
	public static Date add(Date date,int dayOffset,int hourOffset){
		DateTime dt = new DateTime(date.getTime());
		return dt.plusDays(dayOffset).plusHours(hourOffset).toDate();
	}
	/**
	 * 取与指定时间间隔若干秒的时间
	 *
	 * @param offset
	 * @return dateTime
	 */
	public static Date addSecond(String dateStr,int offset){
		DateTime dt = DateTime.parse(dateStr);
		return dt.plusSeconds(offset).toDate();
	}
	public static Date addSecond(Date date , int offset){
		DateTime dt = new DateTime(date);
		return dt.plusSeconds(offset).toDate();
	}
	public static DateTime addSecond(DateTime date, int offset) {
		return date.plusSeconds(offset);
	}
	
	/**
	 * 取与指定时间间隔若干秒的时间
	 *
	 * @param date
	 * @param offset
	 * @return date
	 */
	public static Date addSecondReturnDate(DateTime date, int offset) {
		DateTime dt = date.plusSeconds(offset);
		String dtStr = getStrDate(dt);
		return getDateByStr(dtStr);
	}
	
	/**
	 * 取与指定时间间隔若干秒的时间
	 *
	 * @param offset
	 * @return date
	 */
	public static Date addSysSecondReturnDate(int offset) {
		String dtStr = getStrDate(new DateTime().plusSeconds(offset));
		return getDateByStr(dtStr);
	}

	public static Date getStrToDate(String date) {
		DateFormat format = new SimpleDateFormat(DATE_FORMAT_TYPE1);
		Date d = null;
		if(StringUtils.isEmpty(date)){
			return d;
		}
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	/**
	 * 几天前的日期
	 *
	 * @param d
	 * @param day
	 *            0 为当前时间 正数为之前的时间 负数是之后的时间
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date da = null;
		try {
			da = format.parse(sdf.format(now.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}

	/**
	 * 比较2个字符串日期的大小
	 *
	 * @param strDate1
	 *            日期1
	 * @param strDate2
	 *            日期2
	 * @return 大于0: 日期1大于等于日期2； 小于0：日期1小于日期2；等于0：日期1和日期2相等；null：字符串输入不正确
	 */
	public static Integer compare2Date(String strDate1, String strDate2) {
		if (StringUtils.isEmpty(strDate1) || StringUtils.isEmpty(strDate2)
				|| strDate1.length() != strDate2.length())
			return null;
		return strDate1.compareTo(strDate2);
	}

	/**
	 * 取得当前日期(格式为：2012-07-05 14:23:30 )
	 *
	 * @return String
	 */
	public static String getSysDate() {
		return DateTimeFormat.forPattern(DATE_FORMAT_TYPE1).print(
				new DateTime());
	}
	
	/**
	 * 取得当前日期(格式为：2012-07-05)
	 * @return
	 */
	public static String getNYRSysDate(){
		return DateTimeFormat.forPattern(DATE_FORMAT_TYPE3).print(
				new DateTime());
	}

	/**
	 * 取得当前日期(格式为：2012-07-05 14:23:30:111 )
	 *
	 * @return String
	 */
	public static String getSysDateHM() {
		return DateTimeFormat.forPattern(DATE_FORMAT_TYPE2).print(
				new DateTime());
	}

	/**
	 * 取得指定日期(格式为：2012-07-05 14:23:30 )
	 *
	 * @param
	 *            date 指定的日期
	 * @return String
	 */
	public static String getStrDate(Date date) {
		return new SimpleDateFormat(DATE_FORMAT_TYPE1).format(date);
	}

	/**
	 * 取得指定日期(格式为：2012-07-05 14:23:30 )
	 *
	 * @param
	 *            date 指定的日期
	 * @return String
	 */
	public static String getStrDate(DateTime date) {
		return DateTimeFormat.forPattern(DATE_FORMAT_TYPE1).print(date);
	}

	/**
	 * 得到字符串日期的年月日(格式为：2012-07-05 14:23:30 )
	 *
	 * @return
	 */
	public static String getYMDbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(0, 10);
	}

	/**
	 * 得到字符串日期的年(格式为：2012-07-05 14:23:30 )
	 *
	 * @return
	 */
	public static String getYbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(0, 4);
	}

	/**
	 * 得到字符串日期的月(格式为：2012-07-05 14:23:30 )
	 *
	 * @return
	 */
	public static String getMbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(5, 7);
	}

	/**
	 * 得到字符串日期的天(格式为：2012-07-05 14:23:30 )
	 *
	 * @return
	 */
	public static String getDbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(8, 10);
	}

	/**
	 * 得到字符串日期的小时(格式为：2012-07-05 14:23:30 )
	 *
	 * @return
	 */
	public static String getHbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(11, 13);
	}

	/**
	 * 得到字符串日期的分钟(格式为：2012-07-05 14:23:30 )
	 *
	 * @return
	 */
	public static String getMIbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(14, 16);
	}

	/**
	 * 得到字符串日期的分钟(格式为：2012-07-05 14:23:30 )
	 *
	 * @param strDate
	 *            字符串类型的日期,包括年月日时分秒
	 * @return
	 */
	public static String getSbyStrDate(String strDate) {
		if (StringUtils.isEmpty(strDate))
			return null;
		return strDate.substring(17);
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		String dateStr =  dtf.print(date.getTime());
		return dateStr;
	}

	/**
	 * 转化字符串为日期对象
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parse(String dateStr, String format) {
		if(dateStr==null || "".equals(dateStr)) return null;
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		Date date = dtf.parseDateTime(dateStr).toDate();
		return date;
	}

	/**
	 * 转化字符串为日期对象
	 *
	 * @param dateStr
	 * @return
	 */
	public static Date getDateByStr(String dateStr) {
		if(dateStr==null || "".equals(dateStr)) return null;
		DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT_TYPE1);
		Date date = dtf.parseDateTime(dateStr).toDate();
		return date;
	}

	/**
	 * 转化字符串为日期对象
	 *
	 * @return
	 */
	public static DateTime parseStrToDateTime(String dateStr) {
		if(dateStr==null || "".equals(dateStr)) return null;
		DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT_TYPE1);
		DateTime date = dtf.parseDateTime(dateStr);
		return date;
	}

	public static Date yyyyMMdd(Date date) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(YYYYMMDD);
		String dateStr =  dtf.print(date.getTime());
		Date newDate = dtf.parseDateTime(dateStr).toDate();
		return newDate;
	}
	public static String getYyyyMMddStr(Date date) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(YYYYMMDD);
		String dateStr =  dtf.print(date.getTime());
		return dateStr;
	}
	public static Date yyyyMMddHH(Date date) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(YYYYMMDDHH);
		String dateStr =  dtf.print(date.getTime());
		Date newDate = dtf.parseDateTime(dateStr).toDate();
		return newDate;
	}
	
	public static boolean compareToTodayZero(Date date){
		String toDayZeroStr = DateUtils.format(new Date(), "yyyy-MM-dd") + " 00:00:00";
		Date toDayZero =  DateUtils.getDateByStr(toDayZeroStr);
		return date.before(toDayZero);
	}
	
	/** 
     * 获取当月的 天数 
     * */  
    public static int getCurrentMonthDay() {  
          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  
  
    /** 
     * 根据年 月 获取对应的月份 天数 
     * */  
    public static int getDaysByYearMonth(int year, int month) {  
          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  
	
	public static void main(String[] args) throws InterruptedException {
//		Date date = add(new Date(), 0, 1, 17, 17, 17);
//		System.out.println(date);
//		Date d = new Date(1500536799430L);
//		System.out.println(DateOperateUtil.getStrDate(d));
		
//		Date d = DateUtils.getDateByStr("2014-01-14 12:22:22");
		Date d2 = DateUtils.getDateByStr("2014-04-14 12:22:22");
		System.out.println(DateUtils.getDaysByYearMonth(2015, 10));
//		System.out.println(DateOperateUtil.compareToTodayZero(d));
		
		
		
//		System.out.println(d.getTime());
		System.out.println(d2.getTime());
		System.out.println(getCurrentMonthDay());
	}
}
