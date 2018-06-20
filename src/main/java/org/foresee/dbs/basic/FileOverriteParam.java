package org.foresee.dbs.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 读取参数文件，到内存里，用StringBuffer存每一行，读取时要修改的部分改之后放进buf，之后buf整体写回文件里。
 */
public class FileOverriteParam {
	public static void main(String[] args) {
		try {
			File src = new File("ParamFile.txt");
			BufferedReader reader = new BufferedReader(new FileReader(src));
			StringBuffer buf = new StringBuffer();
			String str;
			// 读的同时修改值，写到buf
			while ((str = reader.readLine()) != null) {
				if (str.startsWith("#")) { // 注释行，不需要改
					buf.append(str+"\n");
					continue;
				}
				if (!str.contains("=")) { // 不是注释行但不包含等号，不应该出现
					System.out.println(str + "不包含等号，不能解析值");
					continue;
				}
				String[] keyValue = str.split("=");
				if (keyValue.length != 2) {
					System.out.println(str + "等号不是一个，也不能解析");
				}
				double rand = Math.random() * 10; // 随机一个0到10之间的数
				switch (keyValue[0]) {
				case "参数1":
					String randStr=String.format("%.2f", rand);
					System.out.println(keyValue[0] + "原值"+keyValue[1]);
					System.out.println(keyValue[0] + "设置随机值"+randStr);
					buf.append(keyValue[0]+"="+randStr+"\n");
					break;
				case "param2":
					String randStr2=String.format("%.5f", rand);
					System.out.println(keyValue[0] + "原值"+keyValue[1]);
					System.out.println(keyValue[0] + "设置随机值"+randStr2);
					buf.append(keyValue[0]+"="+randStr2+"\n");
					break;
				default:
					System.out.println(keyValue[0] + "不改变值"+keyValue[1]);
					buf.append(str+"\n");
					break;
				}
			}
			reader.close();
			BufferedWriter writer=new BufferedWriter(new FileWriter(src));
			writer.write(buf.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
