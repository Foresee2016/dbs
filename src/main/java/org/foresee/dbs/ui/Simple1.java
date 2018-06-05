package org.foresee.dbs.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 测试JFrame窗口关闭后程序怎么停下来
 * @author Foresee
 *
 */
public class Simple1 {
	static boolean running=true;
	public static void main(String[] args) {		
		JFrame frame = new JFrame("打花-检测");
		frame.setLayout(null);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				System.out.println("MainFrame closed");
				running = false;
			}
		});
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		while(running){
			System.out.println("running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("over");
	}
}
