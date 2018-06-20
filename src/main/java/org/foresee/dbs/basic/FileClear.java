package org.foresee.dbs.basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 两个方法里都用到了FileWriter，构造函数中指定是否append，默认false会覆盖原内容。
 * 所以这两种方式都写空字符串导致文件被清空了。
 */
public class FileClear {
	public static void main(String[] args) {
		try {
			File file=new File("ClearFile.txt");
//			clearFile1(file);
			clearFile2(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void clearFile1(File file) throws IOException {
		FileWriter dstWriter = new FileWriter(file);
		dstWriter.write(""); // 清空备份文件的内容
		dstWriter.flush();
		dstWriter.close();
	}
	public static void clearFile2(File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(""); // 清空备份文件的内容
		writer.flush();
		writer.close();
	}
}
