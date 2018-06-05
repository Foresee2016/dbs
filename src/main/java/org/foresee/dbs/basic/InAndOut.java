package org.foresee.dbs.basic;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class InAndOut {
	public static void main(String[] args) {
		InputStream stdin=System.in;
		Scanner scanner=new Scanner(stdin);
		System.out.println("输入5个数，空格分隔");
		int[] data=new int[5];
		for(int i=0; i<5; i++){
			scanner.nextInt();
		}
		System.out.println("---排序后---");
		Arrays.sort(data);
		for(int i=0; i<data.length; i++){
			System.out.print(i+",");
		}
		scanner.close();
//		try {
//			int waiting=stdin.available();
//			if(waiting>0){
//				byte[] data=new byte[waiting];
//				stdin.read(data);
//			}
//			stdin.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
	}
}
