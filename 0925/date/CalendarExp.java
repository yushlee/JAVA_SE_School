package com.training.session7.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExp {

	public static void main(String[] args) {
		System.out.println("--------------------java.util.Calendar--------------------");
		// Calendar 基本操作
		Calendar calendarDate = Calendar.getInstance();
		int YEAR = calendarDate.get(Calendar.YEAR);
		int MONTH = calendarDate.get(Calendar.MONTH) + 1;
		int DAY = calendarDate.get(Calendar.DATE);
		System.out.println(YEAR + "/" + MONTH + "/" + DAY);
		Calendar calendar_2008 = Calendar.getInstance();
		int month = 2 - 1;
		calendar_2008.set(2008, month, 15);
		formatDate(calendar_2008.getTime());
		System.out.println("calendarDate before calendar_2008 ? " + calendarDate.before(calendar_2008));
		System.out.println("calendarDate after calendar_2008 ? " + calendarDate.after(calendar_2008));
		
		// Calendar 月份最大天數
		int actualMaximum = calendar_2008.getActualMaximum(Calendar.DATE);
		System.out.println("2008年2月份天數:"+ actualMaximum);
		
		// Calendar 加減天數運算
		Calendar date = Calendar.getInstance();
		formatDate(date.getTime());
		date.add(Calendar.YEAR, -2); // 加減"年"
		date.add(Calendar.MONTH, -2); // 加減"月"
		date.add(Calendar.DATE, -2); // 加減"日"
		date.add(Calendar.HOUR, -2); // 加減"時"
		date.add(Calendar.MINUTE, -2); // 加減"分"
		date.add(Calendar.SECOND, -5); // 加減"秒"
		formatDate(date.getTime());
		// 當前日所在月份的第幾日
		System.out.println("DAY_OF_MONTH" + date.get(Calendar.DAY_OF_MONTH));
		// 當前日是一周的第幾天(星期日為第一天)
		System.out.println("DAY_OF_WEEK" + date.get(Calendar.DAY_OF_WEEK) );
		// 當前日的星期所在月份的第幾週
		System.out.println("DAY_OF_WEEK_IN_MONTH" + date.get(Calendar.DAY_OF_WEEK_IN_MONTH) );
		// 當前日在這個年的第多少天
		System.out.println("DAY_OF_YEAR" + date.get(Calendar.DAY_OF_YEAR) );		
		
		// Calendar 閏年判斷
		boolean b = ((GregorianCalendar)calendarDate).isLeapYear(2008);
		if(b == true) {
			System.out.println("是閏年");   
		} else {   
		  System.out.println("不是閏年");   
		}
	}
	
	public static void formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(simpleDateFormat.format(date));
	}
}
