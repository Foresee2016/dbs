package org.foresee.dbs.rxtx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;

//import gnu.io.CommPort;
//import gnu.io.CommPortIdentifier;
//import gnu.io.NoSuchPortException;
//import gnu.io.PortInUseException;
//import gnu.io.SerialPort;
//import gnu.io.SerialPortEventListener;
//import gnu.io.UnsupportedCommOperationException;

@SuppressWarnings("unused")
public class SerialTool {
//	private static SerialTool serialTool = null;
//	static {
//		if (serialTool == null) {
//			serialTool = new SerialTool();
//		}
//	}
//
//	private SerialTool() {
//	}
//
//	public static SerialTool getSerialTool() {
//		return serialTool;
//	}
//
//	@SuppressWarnings("unchecked")
//	public static final List<String> findPorts() {
//		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
//		List<String> portNames = new ArrayList<>();
//		while (portList.hasMoreElements()) {
//			CommPortIdentifier commPortIdentifier = (CommPortIdentifier) portList.nextElement();
//			String portName = commPortIdentifier.getName();
//			portNames.add(portName);
//		}
//		return portNames;
//	}
//
//	public static final SerialPort openPort(String portName, int baudrate) throws NoSuchPortException,
//			PortInUseException, UnsupportedCommOperationException, NoThatSerialPortException {
//		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
//		// Open port with portName and timeout(unit-ms)
//		CommPort commPort = portIdentifier.open(portName, 2000);
//		if (commPort instanceof SerialPort) {
//			SerialPort serialPort = (SerialPort) commPort;
//			serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
//					SerialPort.PARITY_NONE);
//			return serialPort;
//		} else {
//			throw new NoThatSerialPortException(portName);
//		}
//	}
//
//	public static void closePort(SerialPort serialPort) {
//		if (serialPort != null) {
//			serialPort.close();
//			serialPort = null;
//		}
//	}
//
//	public static void sendToPort(SerialPort serialPort, byte[] bytes)
//			throws SendDataToSerialPortException, SerialPortOutputStreamCloseException {
//		OutputStream output = null;
//		try {
//			output = serialPort.getOutputStream();
//			output.write(bytes);
//			output.flush();
//		} catch (IOException e) {
//			throw new SendDataToSerialPortException(serialPort.getName());
//		} finally {
//			try {
//				if (output != null) {
//					output.close();
//					output = null;
//				}
//			} catch (IOException e2) {
//				throw new SerialPortOutputStreamCloseException(serialPort.getName());
//			}
//		}
//	}
//
//	public static byte[] readFromPort(SerialPort serialPort)
//			throws ReadSerialPortException, SerialPortInputStreamCloseException {
//		InputStream input = null;
//		byte[] bytes = null;
//		try {
//			input = serialPort.getInputStream();
//			int bufLength = input.available();
//			while (bufLength != 0) {
//				bytes = new byte[bufLength];
//				input.read(bytes);
//				bufLength = input.available();
//			}
//			return bytes;
//		} catch (IOException e) {
//			throw new ReadSerialPortException(serialPort.getName());
//		} finally {
//			try {
//				if (input != null) {
//					input.close();
//					input = null;
//				}
//			} catch (IOException e) {
//				throw new SerialPortInputStreamCloseException(serialPort.getName());
//			}
//		}
//	}
//
//	public static void addListener(SerialPort serialPort, SerialPortEventListener listener)
//			throws TooManyListenersException {
//		serialPort.addEventListener(listener);
//		serialPort.notifyOnDataAvailable(true);
//		serialPort.notifyOnBreakInterrupt(true);
//	}
//	
//	public static class NoThatSerialPortException extends Exception {
//		private static final long serialVersionUID = -979423513845189129L;
//		public NoThatSerialPortException(String portName) {
//			super("Cannot Open PortName "+portName);
//		}
//	}
//	public static class ReadSerialPortException extends Exception {
//		private static final long serialVersionUID = 5605149310858679653L;
//		public ReadSerialPortException(String portName) {
//			super("Error when reading SerialPort: "+portName);
//		}
//	}
//	public static class SendDataToSerialPortException extends Exception {
//		private static final long serialVersionUID = -2371542991359388076L;
//		public SendDataToSerialPortException(String portName) {
//			super("Error send to SerialPort: "+portName);
//		}
//	}
//	public static class SerialPortInputStreamCloseException extends Exception {
//		private static final long serialVersionUID = -2371542991359388076L;
//		public SerialPortInputStreamCloseException(String portName) {
//			super("Error close SerialPort's InputStream after read data: "+portName);
//		}
//	}
//	public static class SerialPortOutputStreamCloseException extends Exception {
//		private static final long serialVersionUID = -2371542991359388076L;
//		public SerialPortOutputStreamCloseException(String portName) {
//			super("Error close SerialPort's OutputStream after send data: "+portName);
//		}
//	}
}
