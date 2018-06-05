package org.foresee.dbs.basic;

public class MathTool {
	/**
	 * 数学工具Math类 
	 */
	public static void main(String[] args) {
		double cubicSqrt=Math.cbrt(27);
		System.out.println(cubicSqrt);
		double a2PlusB2=Math.hypot(3, 4); // 计算(a*a+b*b)的平方根
		System.out.println(a2PlusB2);
		int max=Integer.MAX_VALUE;
		max++;
		System.out.println(max);
	}
}
