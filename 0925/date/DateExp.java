package com.training.session7.date;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateExp {

	public static void main(String[] args) {		
		System.out.println("--------------------java.util.Date--------------------");
		Date currentDate = new Date();
		formatDate(currentDate);
		// Deprecated. As of JDK version 1.1, replaced by Calendar.set(Calendar.YEAR, year + 1900).
		int year = 2008 - 1900;	 // 年份需減1900
		int month = 2 - 1;       // 月份需減1
		Date date_2008 = new Date();
		date_2008.setYear(year);
		date_2008.setMonth(month);
		date_2008.setDate(15);
		formatDate(date_2008);
		// 判斷日期是否在所指定的日期之前
		System.out.println("currentDate before date_2008 ? " + currentDate.before(date_2008));
		// 判斷日期是否在所指定的日期之後
		System.out.println("currentDate after date_2008 ? " + currentDate.after(date_2008));
		long currentDateTime = currentDate.getTime(); // 秒/毫秒 -> 1/1000
		System.out.println("currentDateTime time : " + currentDateTime);
		
		// Date -> String
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
		System.out.println("Date -> String : " + simpleDateFormat.format(currentDate));		
		// String -> Date
		String dateStr = "2013-06-18(二)";
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd(E)");
		DateFormatSymbols symbols = simpleDateFormat1.getDateFormatSymbols();
		symbols.setShortWeekdays(new String[] {  "一", "二", "三", "四", "五", "六" ,"日" });
		
		simpleDateFormat1.setDateFormatSymbols(symbols);
		try {
			Date parseDate = simpleDateFormat1.parse(dateStr);
			System.out.print("String -> Date : ");
			formatDate(parseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss", Locale.US);
		System.out.println(simpleDateFormat.format(date));
	}
}
