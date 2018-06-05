package org.foresee.dbs.basic;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class UseTimer {
	public static void main(String[] args) {
		Timer timer=new Timer();
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(new Date()+" 到了，执行定时任务");
				System.out.println("Hello Timer.");
			}
		};
		Calendar calendar=new GregorianCalendar(2017,Calendar.NOVEMBER,29, 16, 25);
		timer.schedule(task, calendar.getTime());
		System.out.println("设置了在：‘"+calendar.getTime().toString()+"’执行的任务");
//		timer.scheduleAtFixedRate(task, firstTime, period); 定速率
//		timer.schedule(task, delay, period);	定延迟一段时间
	}
}
