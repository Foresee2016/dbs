package org.foresee.dbs.thread;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SwingThread {

	public static void main(String[] args) {
		JFrame frame=new JFrame("测试Swing事件处理线程");
		JButton button1=new JButton("按钮1");
		button1.setSize(50, 30);
		JButton button2=new JButton("按钮2");
		button2.setSize(50, 30);
		JTextArea textArea=new JTextArea("提示文本");
		textArea.setSize(150, 150);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				textArea.setText("按钮1，睡眠5秒");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				textArea.setText("按钮1，睡眠5秒结束");
			}
		});
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				textArea.setText("按钮2，睡眠3秒");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
				textArea.setText("按钮2，睡眠3秒结束");
			}
		});
		frame.setLayout(new FlowLayout());
		frame.add(button1);
		frame.add(button2);
		frame.add(textArea);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println("最后一行");
	}

}
