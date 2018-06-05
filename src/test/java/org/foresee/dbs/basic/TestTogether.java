package org.foresee.dbs.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AssertExample.class,
	AssertExample2.class,
	CalculatorTest.class
})
public class TestTogether {
	// 这个类只作为holder，来把上边几个测试类用Suite一起执行
}
