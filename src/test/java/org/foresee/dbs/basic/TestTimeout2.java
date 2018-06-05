package org.foresee.dbs.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestTimeout2 {
	public static String log;
	private final CountDownLatch latch=new CountDownLatch(1); //同步工具之一
	@Rule
	//全局超时设定，每个Test方法执行不超过2秒，包括@Before和@After的执行时间。
	//如果测试方法进入了无限循环，那么@After不会执行到
	public Timeout globalTimeout=Timeout.seconds(2); 
	@Test
	public void testWithTimeout() throws InterruptedException{
		log+="ran1";
		TimeUnit.SECONDS.sleep(100); //Sleep 100秒
	}
	@Test
	public void testBlockForever() throws InterruptedException{
		log+="ran2";
		latch.await(); // Will block
	}
}
