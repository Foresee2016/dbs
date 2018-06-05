package org.foresee.dbs.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sample {
	public static void main(String[] args) {
		List<Integer> integers=new ArrayList<>();
		for(int i=0; i<30;i++){
			integers.add((int) Math.random());
		}		
		// Java8 函数式风格
		// 并行流遍历列表
		Optional<Integer> maxOp=integers.parallelStream().reduce(Integer::max);
		int max1=maxOp.get();
		System.out.println(max1);
		// 流遍历列表
		Optional<Integer> maxOp2=integers.stream().reduce(Integer::max);
		System.out.println(maxOp2.get());
		// Lambda表达式
		int max2=integers.stream().reduce(Integer.MIN_VALUE, (a,b)->Integer.max(a, b));
		System.out.println(max2);
	}
}
