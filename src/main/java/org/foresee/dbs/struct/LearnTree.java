package org.foresee.dbs.struct;

import java.util.TreeMap;

/**
 * 学习使用Java自带的二叉树数据结构，其内部使用红黑树实现，是平衡二叉树。
 */
public class LearnTree {
	
	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap=new TreeMap<>();
		treeMap.put("abc", 1);
		treeMap.put("abc", 2);
		treeMap.put("qwe", 3);
		treeMap.put("zxc", 4);
		for (String string : treeMap.keySet()) {
			System.out.println(string+":"+treeMap.get(string));
		}
	}
}
