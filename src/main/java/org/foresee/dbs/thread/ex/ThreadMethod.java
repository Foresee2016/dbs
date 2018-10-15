package org.foresee.dbs.thread.ex;

/**
 * 不太对，线程还是没同步
 */
public class ThreadMethod {
	public static void main(String[] args) {
		// ShareStatic ss=new ShareStatic("test");
		// System.out.println(ss.fib(100));
		Thread t1 = new Thread(new ShareStatic(), "thread1");
		Thread t2 = new Thread(new ShareStatic(), "thread2");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static class ShareStatic implements Runnable {
		static int count = 0;//静态变量不能加synchronized，可以把操作放在一个方法里，这个static synchronized由类的所有对象共享锁
		public static synchronized boolean increase(){
			if(count>=100){
				return false;
			}
			count++;
			System.out.println(Thread.currentThread().getName() + " count =" + count);
			return true;
		}
		@Override
		public void run() {
			while (increase()) {
				fib(1000);
				Thread.yield();
			}
		}

		/**
		 * 一个耗时任务，避免console太乱
		 */
		public int fib(int n) {
			if (n == 1 || n == 2) {
				return 1;
			}
			int a = 1, b = 1, c = 2, d = 2;
			while (n-- > 0) {
				d = c;
				c = a + b;
				a = b;
				b = d;
			}
			return c;
		}
	}
}
