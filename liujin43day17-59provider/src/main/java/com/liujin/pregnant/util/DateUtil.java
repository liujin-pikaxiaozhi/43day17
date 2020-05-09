package com.liujin.pregnant.util;

import java.util.Date;

public class DateUtil {

	/*
	* 方法1
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	@SuppressWarnings("deprecation")
	public static Date getDateByInitMonth(Date date) {
		int month = date.getMonth();
		int year = date.getYear();
		Date date2 = new Date(year, month, 1,0,0,0);
		return date2;
	}
	
	/*
	* 方法2
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	@SuppressWarnings("deprecation")
	public static Date getDateByFullMonth(Date src){
		//TODO 实现代码
		int month = src.getMonth();
		if (month==2) {
			int year = src.getYear();
			Date date = new Date(year, month, 28, 23, 59, 59);
			return date;
		}else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			int year = src.getYear();
			Date date = new Date(year, month, 31, 23, 59, 59);
			return date;
		}else {
			int year = src.getYear();
			Date date = new Date(year, month, 30, 23, 59, 59);
			return date;
		}
	}
	
}
