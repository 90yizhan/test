package com.ss;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	 private final static String date1="2018-12-31";
	 private final static String date2="2019-1-7";
	public static void main(String[] args) {
		int day=201910;
		Integer year=Integer.parseInt((day+"").substring(0, 4));
		Integer month=Integer.parseInt((day+"").substring(4, 6));
		System.out.println(DateUtil.getDayStartTime(DateUtil.getFirstDateOfMonth(year, month).getTime()));
		System.out.println(DateUtil.getDayEndTime(DateUtil.getLastDateOfMonth(year, month).getTime()));
		  //System.out.println(getWeekOfYear(date1));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = format.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Calendar calendar = Calendar.getInstance(); 
        calendar.setFirstDayOfWeek(Calendar.MONDAY); 
        calendar.setTime(date); 
        int weekNo = calendar.get(Calendar.WEEK_OF_YEAR); 
        int year1 = calendar.get(Calendar.YEAR);  
        calendar.add(Calendar.DAY_OF_MONTH, -7);  
        int year2 = calendar.get(Calendar.YEAR);  
        int weekBefore = calendar.get(Calendar.WEEK_OF_YEAR); 
        if(weekNo<weekBefore){  
            year2+=1; 
            year = year2; 
        }else{ 
        year = year1; 
        } 
        System.out.println(year+"年第"+weekNo+"周"); 
        System.out.println(DateUtil.getWeek(date));
	}
	
	
	 public static Integer getWeekOfYear(String date_str) {
	        try {
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = format.parse(date_str);
	            Calendar calendar = Calendar.getInstance();
	    //        设置周一是一周的开始
	            calendar.setFirstDayOfWeek(Calendar.MONDAY);
	    //        每年的第一周最少有几天   odps函数  weekofyear  4天以上
	            calendar.setMinimalDaysInFirstWeek(5);
	            calendar.setTime(date);
	            return calendar.get(Calendar.WEEK_OF_YEAR);
	        } catch (Exception e) {
	            return null;
	        }

	    }
}
