package org.foresee.dbs.basic;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {
	// expected这种方式不推荐，因为方法内只要任意一行throw了这个异常，测试就通过，是哪个throw的不管
	@Test(expected=IndexOutOfBoundsException.class) 
	public void empty(){
		new ArrayList<Object>().get(0);
	}
	@Test
	public void testExceptionMessage(){
		try{	// 用try/catch习惯用法，在jUnit3.x常用
			new ArrayList<Object>().get(0);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		}catch (IndexOutOfBoundsException e) {
			assertThat(e.getMessage(), is("Index: 0, Size: 0"));
		}
	}
	//
	@Rule
	public ExpectedException thrown=ExpectedException.none();
	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException{
		List<Object> list=new ArrayList<>();
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: 0, Size: 0");
		thrown.expectMessage(containsString("Size: 0"));
		list.get(0);	// 会在这行有异常，所以下边不会执行到
	}
	@Test
	public void shouldThrow(){
		TestThing testThing=new TestThing();
		thrown.expect(TestException.class);
		thrown.expectMessage(startsWith("some"));
//		thrown.expect(hasProperty()); //没hasProperty这个方法，可能在其他依赖
		testThing.chunk();
	}
	private class TestThing{
		public void chunk(){
			Res res=new Res(404);
			throw new TestException("some message", res);
		}
	}
	public class TestException extends RuntimeException{
		private static final long serialVersionUID = -7917595633123221262L;
		public Res res;
		public TestException(String message, Res res) {
			super(message);
			this.res=res;
		}		
	}
	public class Res {
		public int status;
		public Res(int status) {
			this.status=status;
		}
	}
}
