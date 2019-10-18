package com.ss;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static String getNowString(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
    	return sdf.format(new Date());
    }
    public static Date getNowDate(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
    	Date now=new Date();
    	try {
			now=sdf.parse(getNowString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return now;
    }
    public static Date addDiffDayForUser(Date date, int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, i);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
    /**
     * 获取当天的开始时间
     * @return
     */
	public static Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	 
	/**
	 * 获取当天的结束时间
	 * @return
	 */
	public static Date getDayEnd() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	

	/**
	 * 获取昨天的开始时间
	 * @return
	 */
  	public static Date getBeginDayOfYesterday() {
  		Calendar cal = new GregorianCalendar();
  		cal.setTime(getDayBegin());
  		cal.add(Calendar.DAY_OF_MONTH, -1);
  		return cal.getTime();
  	}
   
  	/**
  	 * 获取昨天的结束时间
  	 * @return
  	 */
  	public static Date getEndDayOfYesterDay() {
  		Calendar cal = new GregorianCalendar();
  		cal.setTime(getDayEnd());
  		cal.add(Calendar.DAY_OF_MONTH, -1);
  		return cal.getTime();
  	}
  	
  	/**
  	 * 获取本月的开始时间
  	 * @return
  	 */
  	public static Date getBeginDayOfMonth() {
  		Calendar calendar = Calendar.getInstance();
  		calendar.set(getNowYear(), getNowMonth() - 1, 1);
  		return getDayStartTime(calendar.getTime());
  	}
  	/**
  	 * 获取本月的结束时间
  	 * @return
  	 */
  	public static Date getEndDayOfMonth() {
  		Calendar calendar = Calendar.getInstance();
  		calendar.set(getNowYear(), getNowMonth() - 1, 1);
  		int day = calendar.getActualMaximum(5);
  		calendar.set(getNowYear(), getNowMonth() - 1, day);
  		return getDayEndTime(calendar.getTime());
  	}
  	/**
  	 * 获取上月的开始时间
  	 * @return
  	 */
  	public static Date getBeginDayOfLastMonth() {
  		Calendar calendar = Calendar.getInstance();
  		calendar.set(getNowYear(), getNowMonth() - 2, 1);
  		return getDayStartTime(calendar.getTime());
  	}
  	/**
  	 * 获取上月的结束时间
  	 * @return
  	 */
  	public static Date getEndDayOfLastMonth() {
  		Calendar calendar = Calendar.getInstance();
  		calendar.set(getNowYear(), getNowMonth() - 2, 1);
  		int day = calendar.getActualMaximum(5);
  		calendar.set(getNowYear(), getNowMonth() - 2, day);
  		return getDayEndTime(calendar.getTime());
  	}
  	
  	public static String yyyyMMddToFormat(String yyyyMMdd,String mode) {
  		if(StringUtils.isEmpty(yyyyMMdd)||StringUtils.isEmpty(mode)){
  			return null;
  		}
  		Date date = new Date();
		try {
			date = DateUtils.parseDate(yyyyMMdd, new String[]{"yyyyMMdd"});
		} catch (ParseException e) {
			e.printStackTrace();
		}
  		return DateFormatUtils.format(date, mode);
  	}
  	/**
  	 * 获取某个日期的开始时间
  	 * @param d
  	 * @return
  	 */
  	public static Timestamp getDayStartTime(Date d) {
  		Calendar calendar = Calendar.getInstance();
  		if(null != d){
  			calendar.setTime(d);
  		}
  		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
  		calendar.set(Calendar.MILLISECOND, 0);
  		return new Timestamp(calendar.getTimeInMillis());
  	}
  	
  	/**
  	 * 获取某个日期的结束时间
  	 * @param d
  	 * @return
  	 */
  	public static Timestamp getDayEndTime(Date d) {
  		Calendar calendar = Calendar.getInstance();
  		if(null != d) {
  			calendar.setTime(d);
  		}
  		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
  		calendar.set(Calendar.MILLISECOND, 999);
  		return new Timestamp(calendar.getTimeInMillis());
  	}
   
  	/**
  	 * 获取今年是哪一年
  	 * @return
  	 */
  	public static Integer getNowYear() {
  		Date date = new Date();
  		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
  		gc.setTime(date);
  		return Integer.valueOf(gc.get(1));
  	}
   
  	/**
  	 * 获取本月是哪一月
  	 * @return
  	 */
  	public static int getNowMonth() {
  		Date date = new Date();
  		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
  		gc.setTime(date);
  		return gc.get(2) + 1;
  	}
    /**
     * 获取当日开始时间
     * @return
     */
    public static Date getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}
    /**
     * 获取当日结束时间
     * @return
     */
    public static Date getnowEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}

    //将日期转换为没有时分秒的
  	public static Date getDate(){
  		Date date=new Date();
  		String str = dateToString(date, "yyyy-MM-dd");
  		try {
  			date = StringToDate(str, "yyyy-MM-dd");
  		} catch (ParseException e) {			
  			e.printStackTrace();
  		}
  		return date;
  	}
    public static final String[] weeks = new String[]{"周日","周一", "周二", "周三", "周四", "周五", "周六"};
    public static String getWeekDay(Integer date) {
        Date week = null;
        try {
            week = toUtilDate(date.toString(), "yyyyMMdd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getWeekStr(week);
    }
    public static Date toUtilDate(String dateStr, String dateFmt)  {
        SimpleDateFormat format = new SimpleDateFormat(dateFmt);
        Date date=null;
        try {
        	date=format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date; 
    }
    public static String getWeekStr(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return weeks[dayOfWeek - 1];
    }
	//////////////-------------------
    //获取日期
  	public static String getyyyyMMdd(){
  		Date d = new Date();
  		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  		return sdf.format(d);
  	}
  	//获取带毫秒时间戳
  	public static String getyyyyMMddHHmmssSSS(){
  		Date d = new Date();
  		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
  		return sdf.format(d);
  	}
  	//获取10000-100000的随机数
  	public static int getRandom(){
  		int max=100000;
          int min=10000;
          Random random = new Random();
          int s = random.nextInt(max)%(max-min+1) + min;
          return s;
  	}
	/**
	 * 时间差天数
	 * @param enddate 结束时间
	 * @param begindate 开始时间
	 * @return
	 */
	public static int getIntervalDays(Date enddate, Date begindate) {
		long millisecond = enddate.getTime() - begindate.getTime();
		int day = (int) (millisecond / 24L / 60L / 60L / 1000L);
		return day;
	}

	public static Date getStartTime(Calendar calendar) {
		Calendar c = (Calendar) calendar.clone();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	public static Date getEndTime(Calendar calendar) {
		Calendar c = (Calendar) calendar.clone();
		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static boolean isSameMonth(Date d1, Date d2) {
		if (d1 == null || d2 == null)
			return false;

		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		return isSameMonth(c1, c2);
	}

	public static boolean isSameMonth(Calendar c1, Calendar c2) {
		return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
				&& c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
	}

	

	
	// 返回一个月的第一天
	public static Calendar getFirstDateOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c;
	}

	// 返回一个月的最后一天
	public static Calendar getLastDateOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		int maxDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, maxDate);
		return c;
	}

	/**
	 * 取得当前日期所在周的第一天
	 */
	public static Calendar getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		if (c.get(Calendar.DAY_OF_WEEK) == 1) { // 特殊处理星期天是第一天的情况！按中国人习惯把周1看成第一天，星期天看成最后一天
			c.add(Calendar.DAY_OF_WEEK, -1);
		}
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); // Sunday
		return c;
	}

	// 获取当前日期的第二天
	public static Calendar getTomorrow(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		return c;
	}
	
	public static Date addDiffMonth(Date date,int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
	
	public static Date addDiffDay(Date date,int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, i);
		return c.getTime();
	}
	public static Date addDiffSeconds(Date date,int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, i);
		return c.getTime();
	}

	/**
	 * 日期加分钟
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date addDiffMinute(Date date,int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, i);
		return c.getTime();
	}
	

	
	/**
	 * 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}
	/**
	 * 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的小时
	 */
	public static int diffHours(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (3600 * 1000));
	}
	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}


	public static Date getDateFromMillis(Long millis)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);

		return calendar.getTime();
	}

	public static Date StringToDate(String dateStr, String mode)
			throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat(mode);
		return s.parse(dateStr);
	}

	public static String dateToString(Date date, String mode) {
		SimpleDateFormat s = new SimpleDateFormat(mode);
		return s.format(date);
	}

	public static String getXingqi(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int xingqi = c.get(Calendar.DAY_OF_WEEK);

		if (xingqi == 1) {
			return "星期日";
		} else if (xingqi == 2) {
			return "星期一";
		} else if (xingqi == 3) {
			return "星期二";
		} else if (xingqi == 4) {
			return "星期三";
		} else if (xingqi == 5) {
			return "星期四";
		} else if (xingqi == 6) {
			return "星期五";
		} else if (xingqi == 7) {
			return "星期六";
		} else {
			return "";
		}
	}
    public static String getweekNum(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int xingqi = c.get(Calendar.DAY_OF_WEEK);

        if (xingqi == 1) {
            return "周日";
        } else if (xingqi == 2) {
            return "周一";
        } else if (xingqi == 3) {
            return "周二";
        } else if (xingqi == 4) {
            return "周三";
        } else if (xingqi == 5) {
            return "周四";
        } else if (xingqi == 6) {
            return "周五";
        } else if (xingqi == 7) {
            return "周六";
        } else {
            return "";
        }
    }
	 /**
     * 将日期转换为字符串
     * 
     * @param date
     * @return
     */
    public static String Date2Str(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        if (date == null)
        {
            return "";
        }
        else
        {
            return sdf.format(date);
        }
    }
    

    //----------------------
    /**
     * 获得当前日期的年份
     * @param date
     * @return
     */
	public static int getYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 获得当前日期的月份
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		return month;
	}
	
	/**
	 * 取得当前日期是星期几
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date){
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_WEEK);
		return day;
	}
	
	//将日期转换为没有时分秒的
	public static Date parseDate(Date date){
		String str = dateToString(date, "yyyy-MM-dd");
		try {
			date = StringToDate(str, "yyyy-MM-dd");
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date parseDate2(Date date){
		date = getTomorrow(date).getTime();
		return parseDate(date);
	}
	//"yyyy-MM-dd HH:mm:ss"
	public static Date getMinMonthDate(String date){  
		        Calendar calendar = Calendar.getInstance();  
		        try {
					calendar.setTime(StringToDate(date,"yyyy-MM-dd"));
					calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
			        String temp=dateToString(calendar.getTime(),"yyyy-MM-dd")+" 00:00:00";
			        return StringToDate(temp,"yyyy-MM-dd HH:mm:ss"); 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}  
		         
    }
	  
	public static Date getMaxMonthDate(String date)  {  
	     Calendar calendar = Calendar.getInstance();  
	     try {
			calendar.setTime(StringToDate(date,"yyyy-MM-dd"));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		    String temp=dateToString(calendar.getTime(),"yyyy-MM-dd")+" 23:59:59";
		    return StringToDate(temp,"yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
	      
	       
	 } 
	/**
	 * 获取指定日期的十二点时间
	 * @param date
	 * @return
	 */
	public static Date getTwelveOfDate(String date)  {  
	     Calendar calendar = Calendar.getInstance();  
	     try {
			calendar.setTime(StringToDate(date,"yyyyMMdd"));
		    String temp=dateToString(calendar.getTime(),"yyyy-MM-dd")+" 12:00:00";
		    return StringToDate(temp,"yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
	      
	       
	 } 
	public static Date getMinWeekDate(Date date){  
        Calendar calendar = Calendar.getInstance();  
        try {
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY); 
	        String temp=dateToString(calendar.getTime(),"yyyy-MM-dd")+" 00:00:00";
	        return StringToDate(temp,"yyyy-MM-dd HH:mm:ss"); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
         
	}

	public static Date getMaxWeekDate(Date date)  {  
		 Calendar calendar = Calendar.getInstance();  
		 try {
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY); 
			calendar.add(Calendar.DATE, 7);
		    String temp=dateToString(calendar.getTime(),"yyyy-MM-dd")+" 23:59:59";
		    return StringToDate(temp,"yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} 
	
	public static Date getBeforWeek(int n){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, n*-7);
		return c.getTime();
	}

	public static Date getMonthdiff(int i){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int month = c.get(Calendar.MONTH);
		c.set(Calendar.MONTH, month - i);
		
		return c.getTime();
	}
	public static Date getMonthdiff(Date begindate,int i){
		Calendar c = Calendar.getInstance();
		c.setTime(begindate);
		int month = c.get(Calendar.MONTH);
		c.set(Calendar.MONTH, month + i);
		
		return c.getTime();
	}
	public static Date firstday(Date date){
		String statestr=DateUtil.dateToString(date, "yyyy-MM")+"-01 00:00";
		Date sDate=new Date();
		try {
			 sDate=DateUtil.StringToDate(statestr, "yyyy-MM-dd HH:mm");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sDate;
	}
	/**
	 * 获取日期所在周是当年是第几周
	 * @param date
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY); 
		c.setTime(date);
		int week = c.get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	public static Date getLimitTime() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		String timeStr=dateToString(c.getTime(), "yyyy-MM-dd");
		timeStr+=" 11:59:59";
		try {
			return StringToDate(timeStr, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static long getExpirySecend(Date expiryDate) {
		if (expiryDate==null) {
			return 0;
		}
		long diffTime=expiryDate.getTime()-getNowDate().getTime();
		return  diffTime/1000;
	}
	public static int getProguessSecend(Date oldDate) {
		if (oldDate==null) {
			return 0;
		}
		long diffTime=getNowDate().getTime()-oldDate.getTime();
		return (int) (diffTime/1000);
	}
	/**
	 * 获得当前日期的小时
	 * 
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (c.get(Calendar.DAY_OF_WEEK) == 1) { // 特殊处理星期天是第一天的情况！按中国人习惯把周1看成第一天，星期天看成最后一天
			c.add(Calendar.DAY_OF_WEEK, -1);
		}
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); // Sunday
		int hour = c.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
}
