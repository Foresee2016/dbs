package org.foresee.dbs.basic;

public class ArrayForeach {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		String[] abc = { "a", "b", "c" };
		for (String s : abc) {
			System.out.println(s);
		}
		String[] nil = null;
		try {
			for (String s : nil) { // Will NullPointerException
				System.out.println(s);
			}
		} catch (NullPointerException e) {
			System.out.println("For each 不能遍历null");
		}
		output();
		System.out.println("可变长参数列表虽然接收的跟数组一样，但For each遍历不会出错");
	}

	public static void output(String... strings) {
		for (String string : strings) {
			System.out.println(string);
		}
	}
}
