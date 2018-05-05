package com.nit.weibo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class GetTime {

	public static String date() {
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);//获取年份
		int month=ca.get(Calendar.MONTH) + 1;//获取月份
		int day=ca.get(Calendar.DATE);//获取日
		int minute=ca.get(Calendar.MINUTE);//分
		int hour=ca.get(Calendar.HOUR_OF_DAY);//小时
		int second=ca.get(Calendar.SECOND);//秒
		//int WeekOfYear = ca.get(Calendar.DAY_OF_WEEK);//星期

		//System.out.println("用Calendar.getInstance().getTime()方式显示时间: " + ca.getTime());
		//System.out.println("用Calendar获得日期是：" + year +"年"+ month +"月"+ day + "日");
		//System.out.println("用Calendar获得时间是：" + hour +"时"+ minute +"分"+ second +"秒");
		//System.out.println(WeekOfYear);//显示今天是一周的第几天（我做的这个例子正好是周二，故结果显示2，如果你再周6运行，那么显示6）
		return year + "-" + String.format("%2d", month).replace(" ", "0") + "-" + String.format("%2d", day).replace(" ", "0") + " " + String.format("%2d", hour).replace(" ", "0") + ":" + String.format("%2d", minute).replace(" ", "0") + ":" + String.format("%2d", second).replace(" ", "0");
	}
	
	public static Date getNowDate() {
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    try {
			return sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	  }

	public static String datePerOne() {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.HOUR_OF_DAY,-1);//前一小时
		int year = ca.get(Calendar.YEAR);//获取年份
		int month=ca.get(Calendar.MONTH) + 1;//获取月份
		int day=ca.get(Calendar.DATE);//获取日
		int minute=ca.get(Calendar.MINUTE);//分
		int hour=ca.get(Calendar.HOUR_OF_DAY);//小时
		int second=ca.get(Calendar.SECOND);//秒
		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
	}
	
	public static String dateLaterTwo() {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.HOUR_OF_DAY,+2);//后两小时
		int year = ca.get(Calendar.YEAR);//获取年份
		int month=ca.get(Calendar.MONTH) + 1;//获取月份
		int day=ca.get(Calendar.DATE);//获取日
		int minute=ca.get(Calendar.MINUTE);//分
		int hour=ca.get(Calendar.HOUR_OF_DAY);//小时
		int second=ca.get(Calendar.SECOND);//秒
		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
	}
	
	public static String dateRiQi() {
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);//获取年份
		int month=ca.get(Calendar.MONTH) + 1;//获取月份
		int day=ca.get(Calendar.DATE);//获取日
		return year + "-" + month + "-" + day;
	}
	
	/*public static void main(String[] args) {
		System.out.println(getNowDate());
	}*/
}
