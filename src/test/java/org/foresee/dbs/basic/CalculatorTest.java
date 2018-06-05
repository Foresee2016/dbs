package org.foresee.dbs.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEvaluate() {
		Calculator calculator=new Calculator();
		int sum=calculator.evaluate("1+2+3");
		assertEquals(sum, 1+2+3);
//		assertEquals("This is a message when assert fail.", sum, 1+2);
	}

}
