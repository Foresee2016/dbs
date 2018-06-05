package org.foresee.dbs.basic;

public class SplitString {
	public static void main(String[] args) {
		String string="高一1班，高一2班";
		String res=replaceCommaWith(string, "ClassName");
		System.out.println(res);
	}
	public static String replaceCommaWith(String withComma, String replaceBy) {
		String res=withComma.replaceAll(",", " or "+replaceBy+"=");
		res=withComma.replaceAll("，", " or "+replaceBy+"=");
		return res;
	}
}
