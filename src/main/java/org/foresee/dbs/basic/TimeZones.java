package org.foresee.dbs.basic;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZones {
	/**
	 * 自带了时区控制，同一个时间戳对不同时区，产生不同的Calendar 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		GregorianCalendar BeiJing=new GregorianCalendar();
		BeiJing.setTimeZone(TimeZone.getTimeZone("Etc/GMT+8"));
		GregorianCalendar NewYork=new GregorianCalendar();
		NewYork.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date date=new Date();
		System.out.println(date);
		System.out.println(date.getHours());
		BeiJing.setTime(date);
		NewYork.setTime(date);
		int hour=BeiJing.get(GregorianCalendar.HOUR);
		int minute=BeiJing.get(GregorianCalendar.MINUTE);
		int second=BeiJing.get(GregorianCalendar.SECOND);
		System.out.println("BeiJing: "+hour+":"+minute+":"+second);
		hour=NewYork.get(GregorianCalendar.HOUR);
		minute=NewYork.get(GregorianCalendar.MINUTE);
		second=NewYork.get(GregorianCalendar.SECOND);
		System.out.println("NewYork: "+hour+":"+minute+":"+second);
//		String[] zones=TimeZone.getAvailableIDs();	//所有TimeZone名字
//		for(int i=0; i<zones.length; i++){
//			System.out.println(zones[i]);
//		}
	}
}
