package org.foresee.dbs.extend;

public interface SameMethod {
	String getHello();
//	int getHello(); //这里的方法必须有相同返回值，不然多继承接口时报错
}
