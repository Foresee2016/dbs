package org.foresee.dbs.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class NamedComsumer implements Runnable {
	public static void main(String[] args) {
		Producer producer = new Producer();
		Thread prodThread = new Thread(producer, "prod");
		prodThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			// 能获取到一些线程内的信息
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("catch: "+t.getName()+" exception");
				e.printStackTrace();
			}
		});
		prodThread.start();
		NamedComsumer comsumer = new NamedComsumer("one", producer);
		Thread one = new Thread(comsumer);
		one.start();
		comsumer = new NamedComsumer("two", producer);
		Thread two = new Thread(comsumer);
		two.start();
		try {
			Thread.sleep(25_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		prodThread.interrupt();
		one.interrupt();
		two.interrupt();
	}

	Producer producer;
	String name;

	public NamedComsumer(String name, Producer producer) {
		this.name = name;
		this.producer = producer;
	}

	@Override
	public void run() {
		System.out.println("cosumer线程开始");
		while (true) {
			String message = producer.getMessage(name);
			System.out.println(name + " got coffee: " + message);
			try {
				Thread.sleep(2800);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
