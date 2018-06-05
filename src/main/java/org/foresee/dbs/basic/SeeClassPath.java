package org.foresee.dbs.basic;

public class SeeClassPath {
	public static void main(String[] args) {
		new SeeClassPath().seeResourcePath();
	}

	public void seeResourcePath() {
		// 输出 file:/E:/JavaSpace/dbs/target/classes/org/foresee/dbs/basic/
		System.out.println(this.getClass().getResource("")); // 当前类class文件的URI目录，不包括自己
		
		// 输出三个 file:/E:/JavaSpace/dbs/target/classes/
		System.out.println(this.getClass().getClassLoader().getResource(""));
		Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println(this.getClass().getResource("/")); // 当前的classpath的绝对URI路径
		
		// 输出空
		System.out.println(ClassLoader.getSystemResource(""));
	}
}
