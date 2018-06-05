package org.foresee.dbs.basic;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class BasicOperation {
	public static void main(String[] args) {
		int x=1, y=3;
		int z=x^y;	// 按位异或，不是乘方
		System.out.println(z);
		byte byte1=100;
		byte byte2=50;
		byte byte3=(byte) (byte1+byte2);
		System.out.println(byte3);
		Integer int1=new Integer(10);
		Integer int2=new Integer(20);
		Integer int3=new Integer(20);
		System.out.println((int1==int2));
		// 对于包装器对象Integer的比较，会按照对象的==来比较是否同一，而不是把内部int值取出来比较相等
		System.out.println((int3==int2));
		change(int1, int2);
		System.out.println(int1+", "+int2);
		int number=123_456_789;	//可以用下划线分隔，这样长数字比较容易看
		System.out.println(number);
		number=0b1111_1111;
		System.out.println(number);
		number=011;
		System.out.println(number);
		number=0xf;
		System.out.println(number);
		char a='a', b='\u2635';	// char是16位Unicode值，'a'表示字符，'杠u'表示转义，后边是编码值
		System.out.println(a+","+b);
		throw new Error("无法恢复的严重错误用Error");
	}
	public void basicStringOperation(){
		String quote="To be or not to be";
		int length=quote.length();
		boolean isEmpty=quote.isEmpty();
		System.out.println(length+" "+isEmpty);
		char[] data=quote.toCharArray();
		data=new char[] {'L', 'E', 'M', 'O', 'N'};
		String lemon=new String(data);
		System.out.println(lemon);
		byte[] data2=new byte[]{97, 98, 99};
		String abc = null;
		try {
			abc = new String(data2, "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(abc);
		char b=abc.charAt(1);
		System.out.println(b);
		char[] abcd="abcd".toCharArray();
		System.out.println(abcd);
		String one=String.valueOf(1);
		String f=String.valueOf(2.345f);
		String notTrue=String.valueOf(false);
		System.out.println(one+" "+f+" "+notTrue);
		Date date = null;
		String nullStr=String.valueOf(date);	// 得到"null", 如果用date.toString有NullPointer异常
		System.out.println(nullStr);
		date=new Date();
		String d=String.valueOf(date);
		System.out.println(d);
	}
	/**
	 * 这里是一个对基础类型包装类问题的理解。
	 * 外部的Integer对象传给了int1，确实是传递了引用，按照一般对象的做法，那么对int1的赋值应该改变原值。
	 * 但是基础类型包装类不同，传递时对包装中的int类型值做了final修饰，现在int1=60的做法是一个新的int类型值60
	 * 被包装成Integer对象，并让int1指向它，所以下边int1和int2赋值后，都不指向原来引用位置了。
	 */
	public static void change(Integer int1, Integer int2) {
		int1=60;
		int2=80;
		int2=int1;
	}
}
