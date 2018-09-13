package org.foresee.dbs.tcp;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TcpClientUi implements Runnable{
	public static void main(String[] args) {
		try {
			new TcpClientUi();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private int serverPort=2018;
	private Socket sock;
	private BufferedReader reader;
	private PrintWriter writer;
	JFrame frame;
	JTextArea recvArea;
	JTextArea sendArea;
	JButton sendBtn;
	Thread recvThread;
	public TcpClientUi() throws UnknownHostException, IOException {
		sock=new Socket("127.0.0.1", serverPort);
		InputStream in=sock.getInputStream();
		reader=new BufferedReader(new InputStreamReader(in));
		OutputStream out=sock.getOutputStream();
		writer=new PrintWriter(out);
		initUi();
		initCtrl();
		recvThread=new Thread(this, "TcpRecv");
		recvThread.start();
	}
	private void initUi() {
		frame=new JFrame("TCP 简易客户端");
		Box vBox=Box.createVerticalBox();
		
		recvArea=new JTextArea("接收到的内容");
		recvArea.setPreferredSize(new Dimension(400, 100));
		JScrollPane scrollRecv=new JScrollPane(recvArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		vBox.add(scrollRecv);
		vBox.add(Box.createVerticalStrut(20));
		
		sendArea=new JTextArea("示例内容");
		sendArea.setPreferredSize(new Dimension(400, 200));
		JScrollPane scrollSend=new JScrollPane(sendArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		vBox.add(scrollSend);
		vBox.add(Box.createVerticalStrut(20));
		
		sendBtn=new JButton("Send");
		sendBtn.setPreferredSize(new Dimension(80, 40));
		
		Box btnBox=Box.createHorizontalBox();
		btnBox.add(sendBtn);
		btnBox.add(Box.createHorizontalStrut(10));
		
		vBox.add(btnBox);
		
		frame.setContentPane(vBox);
		frame.setSize(vBox.getPreferredSize().width, vBox.getPreferredSize().height);
		frame.setVisible(true);
	}
	private void initCtrl() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				try {
					if (writer!=null) {
						writer.close();
					}
					if(reader!=null){
						reader.close();
					}
					if(sock!=null){
						sock.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		sendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String sendStr=sendArea.getText();
				writer.println(sendStr);
				writer.flush();
			}
		});
	}
	@Override
	public void run() {
		while (sock!=null && !sock.isClosed()) {
			String data=null;
			try {
				while (reader!=null && (data=reader.readLine())!=null) {
					recvArea.setText(data);
					if(sock.isClosed()){
						break;
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("TcpClientUi Thread exit.");
	}
	
}
