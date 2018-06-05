package org.foresee.dbs.basic;

public class SeeChar {
	public static void main(String[] args) {
		String string="×";
		byte[] bytes=string.getBytes();
		int a,b;
		if(bytes[1]<0){
			a=bytes[1]+256;
		}else{
			a=bytes[1];
		}
		if(bytes[0]<0){
			b=bytes[0]+256;
		}else {
			b=bytes[0];
		}
		int val=a*256+b;
		System.out.println("UTF16: "+val);
	}
}
