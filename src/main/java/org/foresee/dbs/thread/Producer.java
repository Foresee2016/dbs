package org.foresee.dbs.thread;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {
	static final int MAX_QUEUE=5;
	private List<String> messages=new ArrayList<>();
	@Override
	public void run() {
		System.out.println("prod线程开始");
		int coffee=0;
		while(true){
			putMessage(coffee);
			try {
				coffee++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {	// 这个Catch中不能获取到线程中的信息
				e.printStackTrace();
				break;
			}
		}
	}
	private synchronized void putMessage(int coffee) {
		while(messages.size()>=MAX_QUEUE){
			try {
				System.out.println("达到最大值，稍后生产");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		messages.add("coffee "+coffee);
		System.out.println("生产了coffee: "+coffee);
		notify();
	}
	public synchronized String getMessage(String who) {
		while(messages.size()==0){
			try {
				System.out.println(who+": 没了，等待生产");
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String message=messages.remove(0);
		notify();
		return message;
	}
}
