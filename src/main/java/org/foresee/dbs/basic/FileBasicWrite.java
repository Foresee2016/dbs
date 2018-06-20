package org.foresee.dbs.basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter在写入时，如果文件不存在会自动创建。
 */
public class FileBasicWrite {
	public static void main(String[] args) {
		try {
			File file=new File("E:/test.txt");
			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
			writer.write("测试会不会自动创建文件");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
