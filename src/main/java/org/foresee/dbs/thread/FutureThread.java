package org.foresee.dbs.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("unused")
public class FutureThread implements Runnable {
	public static void main(String[] args) {
//		ExecutorService service=Executors.newFixedThreadPool(3);
//		Future<V> future=service.sub 
	}
	@Override
	public void run() {
		System.out.println("执行了一次run");
	}
}
