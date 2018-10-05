package org.foresee.dbs.extend;

public class DemoMultiExtend implements TwoInterface, SameMethod{

	@Override
	public String getHello() {
		return "Hello";
//		return 0;
	}

	@Override
	public String getHi() {
		return "Hi";
	}
}
