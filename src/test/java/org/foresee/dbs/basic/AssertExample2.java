package org.foresee.dbs.basic;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

public class AssertExample2 {
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("g"), endsWith("d")));
		// 下边这条CombinableMatcher.<Integer>语法很奇怪
		assertThat(2, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		assertThat(new String("abc"), not(sameInstance("abc")));
	}
}
