package org.foresee.dbs.basic;

public class PlusPlus {
	public static void main(String[] args) {
		int i = 1;
		int j = i++;
		System.out.println("i = " + i + ", j = " + j);
		int a = 1;
		int b = ++a;
		System.out.println("a = " + a + ", b = " + b);
		int c = 1;
		int d = c = c + 1;
		System.out.println("c = " + c + ", d = " + d);
	}
}
