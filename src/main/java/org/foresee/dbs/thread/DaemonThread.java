package org.foresee.dbs.thread;

public class DaemonThread extends Thread {
	Thread myThread;
	boolean running;
	public DaemonThread() {
		setDaemon(true);	//守护线程作为后台线程，当某时刻只有后台线程时，解释器会退出
		running=true;
		start();
	}
	@Override
	public void run() {
		int tick=0;
		while(running){			
			System.out.println("Daemon tick "+tick);
			tick++;
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DaemonThread terminated.");	//这句不会打印出来，因为只有后台线程时解释器退出了
	}
	
}
