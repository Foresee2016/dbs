package org.foresee.dbs.basic;

public class OuterClass {
	public static void main(String[] args) {
		OuterClass outerClass=new OuterClass();
		outerClass.innerClass.method();
	}
	public InnerClass innerClass=new InnerClass();
	String str="outer";
	public void method() {
		System.out.println(str + " method");
	}
	public class InnerClass {
		String str="inner";
		public void method() {
			OuterClass.this.method(); //这样访问到外层
			System.out.println(OuterClass.this.str+" accessed");
			System.out.println(str + " method");
		}
	}
}
