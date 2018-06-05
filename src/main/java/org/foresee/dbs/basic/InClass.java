package org.foresee.dbs.basic;

import java.lang.reflect.Method;

public class InClass {
	public static void main(String[] args) {
		InClass inClass=new InClass();
		Class<? extends InClass> class1=inClass.getClass();
		try {
			InClass inClass2=class1.newInstance();
			inClass2.method1();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Method[] methods=InClass.class.getMethods();
		for (Method method : methods) {
//			try {
//				method.invoke(I, {});
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				e.printStackTrace();
//			}
			System.out.println(method);
		}
	}
	public void method1() {
		System.out.println("method 1");
	}
	public void method2() {
		System.out.println("method 2");
	}
	@Deprecated
	public void method3() {
		System.out.println("method 3 deprecated");
	}
}
