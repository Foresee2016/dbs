package org.foresee.dbs.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;

public class Sample2 {
	public static void main(String[] args) {
		// e.x.1 lambda实现Runnable，Java8之前用匿名类，现在一行()->{}代替了
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java 8, anonymous Class.");
			}
		}).start();
		new Thread(() -> System.out.println("In Java8, Lambda expression")).start();
		// e.x.2 lambda 事件处理，比如Swing API
		JButton button = new JButton("Show");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handling with traditional anonymous Object.");
			}
		});
		button.addActionListener((e) -> {
			System.out.println("Event handling with Java8 lambda.");
		});
		// e.x.3 Iterate List
		List<String> features = Arrays.asList("Lambdas", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		features.forEach(n -> System.out.println(n));
		features.forEach(System.out::println);
		// e.x.4 java.util.function.Predicate 函数式接口，想API添加逻辑
		filter(features, (str) -> str.startsWith("L"));
		filter(features, (str) -> true);
		filter(features, (str) -> false);
		filter(features, (str) -> str.length() > 4);
		// e.x.5 允许两个或更多Predicate合成一个，用and(),or(),xor()
		Predicate<String> startWithS = (n) -> n.startsWith("S");
		Predicate<String> moreThanFour = (n) -> n.length() > 4;
		features.stream().filter(startWithS.and(moreThanFour)).forEach((n) -> System.out.print(n));
		;
		// e.x.6 函数式编程概念map，允许将对象进行转换
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			System.out.println(price);
		}
		costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
		// reduce()可以将所有值合并成一个，又称为折叠，类似于SQL中的sum，avg函数，例如计算总和
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			total += price;
		}
		System.out.println(total);
		double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println(bill);
		// e.x.7 过滤一个列表，得到结果列表
		List<String> strList = Arrays.asList("aa", "bbbb", "ccc", "dddddd", "eeeee");
		List<String> filted = strList.stream().filter(x -> x.length() > 3).collect(Collectors.toList());
		System.out.println(filted);
		// e.x.8 对列表每个元素应用一个函数，并连接它们
		String merged = strList.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
		System.out.println(merged);
		// e.x.9 复制不同的值，创建一个子列表
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println(distinct);
		// e.x.10 计算集合元素最大、最小、总和、平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 23, 52, 76, 87, 91);
		IntSummaryStatistics statistics = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(statistics.getMax() + "," + statistics.getMin() + "," + statistics.getSum() + ","
				+ statistics.getAverage());
		// 一些限制：Lambda表达式中只能引用final或final局部变量，不能修改域外变量，下例报错：
		// int factor=2;
		// primes.forEach(element->{factor++;});
	}

	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name);
			}
		}
	}

	public static void filter2(List<String> names, Predicate<String> condition) {
		// 可以用流式编程
		names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
			System.out.println(name);
		});
	}
}
