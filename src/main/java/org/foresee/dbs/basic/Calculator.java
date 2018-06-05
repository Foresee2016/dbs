package org.foresee.dbs.basic;
/**
 * JUnit官网教程，hello world示例
 */
public class Calculator {
	public int evaluate(String expression) {
		int sum=0;
		for(String summand : expression.split("\\+")){
			sum+=Integer.valueOf(summand);
		}
		return sum;
	}
}
