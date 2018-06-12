package org.foresee.dbs;

import java.util.ArrayList;
import java.util.Comparator;

public class DemoCompare {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(1);
		arr.add(3);
		arr.add(4);
		arr.add(6);
		arr.add(5);
		arr.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2; // 正着减是升序的，反着减是降序的
			}
		});
		System.out.println(arr);
	}
}
