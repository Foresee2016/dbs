package org.foresee.dbs.rxtx;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.TooManyListenersException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import org.foresee.dbs.rxtx.SerialTool.NoThatSerialPortException;
//import org.foresee.dbs.rxtx.SerialTool.ReadSerialPortException;
//import org.foresee.dbs.rxtx.SerialTool.SendDataToSerialPortException;
//import org.foresee.dbs.rxtx.SerialTool.SerialPortInputStreamCloseException;
//import org.foresee.dbs.rxtx.SerialTool.SerialPortOutputStreamCloseException;
//
//import gnu.io.NoSuchPortException;
//import gnu.io.PortInUseException;
//import gnu.io.SerialPort;
//import gnu.io.SerialPortEvent;
//import gnu.io.SerialPortEventListener;
//import gnu.io.UnsupportedCommOperationException;

@SuppressWarnings("unused")
public class MainUi extends JFrame {
	public static void main(String[] args) {
		new MainUi();
	}
	private static final long serialVersionUID = -4896536233828966361L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	List<String> commNames = null;
//	SerialPort serialPort = null;
	
	JTextArea receiveTextArea = new JTextArea();
	JTextField sendTextField = new JTextField();
	JButton openPortBtn = new JButton();
	JButton sendBtn = new JButton();
	JComboBox<String> commChoice = new JComboBox<>();
	JComboBox<Integer> baudrateChoice = new JComboBox<>();
	
	public MainUi() {
		super();
//		commNames = SerialTool.findPorts();
		frame();
		controller();
	}

	public void view() {
		setLayout(null);
		
		receiveTextArea.setBounds(20, 20, WIDTH-20, 200);
		receiveTextArea.setText("接收信息：");
		add(receiveTextArea);
		
		for (String string : commNames) {
			commChoice.addItem(string);
		}
		commChoice.setBounds(20, 250, 200, 30);
		add(commChoice);
		
		baudrateChoice.addItem(9600);
		baudrateChoice.addItem(115200);		
		baudrateChoice.setBounds(20, 290, 200, 30);
		add(baudrateChoice);
		
		openPortBtn.setText("打开串口");
		openPortBtn.setBounds(20, 320, 100, 30);
		add(openPortBtn);
		
		sendTextField.setText("发送消息");
		sendTextField.setBounds(260, 290, 200, 40);
		add(sendTextField);
		
		sendBtn.setText("发送");
		sendBtn.setBounds(260, 350, 100, 30);
		add(sendBtn);
	}

	public void frame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int locX = (int) ((toolkit.getScreenSize().getWidth() - WIDTH) / 2);
		int locY = (int) ((toolkit.getScreenSize().getHeight() - HEIGHT) / 2);
		this.setBounds(locX, locY, WIDTH, HEIGHT);
		this.setTitle("Java串口示例");
		Image image = toolkit.getImage("winnieLogo.jpg");
		this.setIconImage(image);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
//				SerialTool.closePort(serialPort);
//				System.exit(0);
			}
		});
		view();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void controller() {
		openPortBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
//				String portName=commChoice.getItemAt(commChoice.getSelectedIndex());
//				int baudrate=baudrateChoice.getItemAt(baudrateChoice.getSelectedIndex());
//				try {
//					serialPort=SerialTool.openPort(portName, baudrate);
//					System.out.println("open: "+portName+" baud "+baudrate);
//					SerialTool.addListener(serialPort, new SerialPortListener());
//				} catch (NoSuchPortException e1) {
//					e1.printStackTrace();
//				} catch (PortInUseException e1) {
//					e1.printStackTrace();
//				} catch (UnsupportedCommOperationException e1) {
//					e1.printStackTrace();
//				} catch (NoThatSerialPortException e1) {
//					e1.printStackTrace();
//				} catch (TooManyListenersException e1) {
//					e1.printStackTrace();
//				}
			}
		});
		
//		sendBtn.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
//				String text=sendTextField.getText();				
//				byte[] bytes=text.getBytes();
//				System.out.println("send: "+new String(bytes));
//				try {
//					SerialTool.sendToPort(serialPort, bytes);
//				} catch (SendDataToSerialPortException e1) {
//					e1.printStackTrace();
//				} catch (SerialPortOutputStreamCloseException e1) {
//					e1.printStackTrace();
//				}
//				sendTextField.setText("");
//			}
//		});
//	}
//	public class SerialPortListener implements SerialPortEventListener{
		// 注：串口发了一串字节，并不一定只触发一次DATA_AVAILABLE时间，而且不一定哪几个字符触发一次
		// 可能的解决方案是设计一个终止符，接收到什么为止。
//		@Override
//		public void serialEvent(SerialPortEvent serialPortEvent) {
//			switch (serialPortEvent.getEventType()) {
//			case SerialPortEvent.BI:	// 10-通讯中断
//				receiveTextArea.setText(receiveTextArea.getText()+"\n"+"通讯中断！");
//				break;
//			case SerialPortEvent.DATA_AVAILABLE:
//				if(serialPort==null){
//					receiveTextArea.setText(receiveTextArea.getText()+"\n"+"有数据但串口为null");
//				}else{
//					String str="";
//					try {
//						byte[] data=SerialTool.readFromPort(serialPort);
//						if(data==null || data.length<1){
//							break;
//						}
//						str=new String(data);
//					} catch (ReadSerialPortException e) {
//						e.printStackTrace();
//					} catch (SerialPortInputStreamCloseException e) {
//						e.printStackTrace();
//					}
//					receiveTextArea.setText(receiveTextArea.getText()+str);
//				}				
//				break;
//			default:
//				break;
//			}
//		}
		
	}
}
