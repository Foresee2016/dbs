package org.foresee.dbs.basic;

import java.util.ArrayList;
import java.util.List;

public class Equal {

	public static void main(String[] args) {
		String s1="abc";
		String s2="abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		AAA a=new AAA(1);
		AAA b=new AAA(1);
		System.out.println(a==b);
		System.out.println(a.equals(b));
		@SuppressWarnings("unchecked")
		List<AAA> []arr=new List[10];
		arr[0]=new ArrayList<>();
		arr[0].add(new AAA(1));
		arr[9]=new ArrayList<>();
		arr[9].add(new AAA(9));
		for (List<AAA> list : arr) {
			if(list==null){
				continue;
			}
			System.out.println(list.size());
		}
		
	}
	public static class AAA {
		int aaa;
		public AAA(int aaa) {
			this.aaa=aaa;
		}
		@Override
		public boolean equals(Object other) {
			if(other instanceof AAA){
				return aaa==((AAA)other).aaa;
			}
			return false;
		}
	}
}
