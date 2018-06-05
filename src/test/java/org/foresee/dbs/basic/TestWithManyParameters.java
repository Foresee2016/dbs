package org.foresee.dbs.basic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestWithManyParameters {
	/**
	 * Parameterized是一个测试运行器，它能按照给定每一行参数运行测试方法。
	 * 比如下边，用7行2列的二维数组生成的List会有7行，每行一个一维数组，数组两个值，
	 * 分别会做出测试类的参数传入，然后运行测试方法。
	 */
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{0,0},{1,1},{2,1},{3,2},{4,3},{5,5},{6,8}
		});
	}
	private int fInput;
	private int fExpected;
	public TestWithManyParameters(int input, int expected) {
		fInput=input;
		fExpected=expected;
	}
	@Test
	public void testFibonacci(){
		assertEquals(fExpected, Fibonacci.compute(fInput));
	}
	/**
	 * 斐波那契类，1, 1, 2, 3, 5, 8, 计算第n个位置上数是几 
	 */
	public static class Fibonacci{
		public static int compute(int n) {
			int result=0;
			if(n<=1){
				result=n;
			}else{
				result=compute(n-1) + compute(n-2);
			}
			return result;
		}
	}
}
