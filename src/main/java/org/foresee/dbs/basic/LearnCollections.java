package org.foresee.dbs.basic;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class LearnCollections {
	public static void main(String[] args) {
		List<String> strings=new Vector<>();
		strings.add("abc");
		Properties properties=new Properties();	// 视为一个面向字符串的HashMap，像System.getProperty()
		properties.setProperty("myapp.xsize", "52");	
		properties.setProperty("myapp.ysize", "25");
		properties.list(System.out);
//		properties.save(System.out, "myapp properties");	//save到OutputStream，废弃了
//		properties.load(inStream);	// 从之前存的地方读回来，有针对XML的方法
		String xSize=properties.getProperty("myapp.xsize");
		int size=Integer.parseInt(xSize);
		System.out.println(size);
	}
}
