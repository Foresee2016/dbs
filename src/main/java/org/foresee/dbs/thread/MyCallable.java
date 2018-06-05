package org.foresee.dbs.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String>{
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(3);
		Future<String> future=service.submit(new MyCallable());
		future.isDone();	// return true or false, not block
		try {
			String string=future.get(); // return value, block until execute finish
			System.out.println(string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String call() throws Exception {
		return "调用了call";
	}

}
