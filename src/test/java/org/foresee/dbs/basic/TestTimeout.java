package org.foresee.dbs.basic;

import org.junit.Test;

public class TestTimeout {
	/**
	 * 带超时的测试，毫秒为单位，测试会运行在另一个线程里，到时间的时候打断它。
	 * 但是如果它是不可打断的，比如while里执行，那么可能一直执行下去
	 */
	@Test(timeout=10)
	public void testWithTimeout(){
		try {
			Thread.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
