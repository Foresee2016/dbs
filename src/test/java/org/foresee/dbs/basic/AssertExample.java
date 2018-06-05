package org.foresee.dbs.basic;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.Test;

public class AssertExample {
	@Test
	public void testAssertArrayEquals(){
		byte[] expected="trial".getBytes();
		byte[] actual="trial".getBytes();
		assertArrayEquals("byte array not same", expected, actual);
	}
	@Test
	public void testAssertEquals(){
		assertEquals("strings should be equal", "text", "text");
	}
	@Ignore("If you want to ignore this test.")
	@Test
	public void testAssertFalse(){
		assertFalse("should be false", false);
	}
	@Test
	public void testAssertTrue(){
		assertTrue("should be true", true);
	}
	@Test
	public void testAssertNotNull(){
		assertNotNull("should not be null", new Object());
	}
	@Test
	public void testAssertSame(){
		Integer aNumber=Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}
	
	// JUnit Matchers assertThat
	@Test
	public void testAssertThatBothContainsString(){
		assertThat("should have both.", "albumen", both(containsString("a")).and(containsString("b")).and(containsString("n")));
	}
	@Test
	public void testAssertThatHasItems(){
		assertThat("shold have items.", Arrays.asList("one","two","three"), hasItems("one","two"));
	}
	@Test
	public void testAssertThatEveryItemContainsString(){
		assertThat("every should string.", Arrays.asList(new String[]{"fun", "ban", "net"}), everyItem(containsString("n")));
	}
	// Core Hamcrest Matchers with assertThat
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("good")));
		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		// 下边这条CombinableMatcher.<Integer>语法很奇怪，可能是为了指定类型
		assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		assertThat(7, not(either(equalTo(3)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}
}
