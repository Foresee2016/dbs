package org.foresee.dbs.thread;

public class MainThread implements Runnable {
	public static void main(String[] args) {
		MainThread sample=new MainThread();
		sample.start();
		new DaemonThread();
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sample.stop();
	}
	Thread myThread;
	boolean running;
	public MainThread() {
		
	}
	public void start() {
		if(!running){
			running=true;
			myThread=new Thread(this, "TickThread");
			myThread.start();
		}
	}
	public void stop(){
		if(running){
			myThread.interrupt();
			running=false;			
		}
	}
	@Override
	public void run() {
		int tick=0;
		while(running){
			System.out.println("tick "+tick+" s");
			tick++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
				System.out.println("interrupted.");
				break;
			}
		}
		System.out.println("myThread "+myThread.getName()+" terminating.");
	}
	
}
