package org.foresee.dbs.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LearnJTable {
	public static void main(String[] args) {
		JFrame frame=new JFrame("测试JTable创建表格");
		Object[][] info={
			{"p1", new Integer(1), "abc"},	
			{"p2", new Integer(4), "zxc"},	
			{"p3", new Integer(6), "qwe"},	
		};
		String[] names={"标签","数值","字母"};
		JTable table=new JTable(info, names);
		table.setPreferredScrollableViewportSize(new Dimension(550, 100));
		JScrollPane scrollPane=new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
